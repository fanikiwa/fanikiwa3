package com.sp.fanikiwa.business;

import java.util.List;

import com.sp.fanikiwa.Enums.PostingCheckFlag;
import com.sp.fanikiwa.business.financialtransactions.TransactionFactory;
import com.sp.fanikiwa.business.financialtransactions.TransactionPost;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.BatchSimulateStatus;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.RequestResult;
import com.sp.fanikiwa.entity.SimulatePostStatus;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.fanikiwa.entity.WithdrawalMessage;
import com.sp.utils.MpesaPayUtil;
import com.sp.utils.PeerLendingUtil;

public class WithdrawalComponent {
	final String USERID = "SYS";
	final String AUTHORIZER = "SYS";

	/*
	 * 1.
	 */
	public RequestResult Withdraw(WithdrawalMessage wm) throws Exception {
		PeerLendingUtil.SetWithdrawalStatus(wm, "Processing");
		// Step 1 Debit the account
		RequestResult re = AccountWithdraw(wm.getAccountId(), wm.getAmount());
		
		if (re.isSuccess()) {
			PeerLendingUtil.SetWithdrawalStatus(wm, "Transacted");
			// Step 2: Remit the money
			RequestResult re2= RemitMoney( wm);
			if(re2.isSuccess())
			{
				PeerLendingUtil.SetWithdrawalStatus(wm, "Remitted");
				return re2;
			}else
			{
				PeerLendingUtil.SetWithdrawalStatus(wm, "RemissionError",re2.getResultMessage());
				return re2;
			}
		}else
		{
			PeerLendingUtil.SetWithdrawalStatus(wm, "TransactionError",re.getResultMessage());
		}
		
		return re;
	}

	private RequestResult RemitMoney(WithdrawalMessage wm) {
		RequestResult re = new RequestResult();
		re.setSuccess(true);
		re.setResultMessage("Success");
		Member member = PeerLendingUtil.GetMember(wm.getMemberId());
		if(member == null)
		{
			re.setSuccess(false);
			re.setResultMessage("Member not found +[" +wm.getMemberId()+ "]" );
			return re;
		}

		switch (wm.getRemissionMethod()) // MPESA|EFT|BANKMOBI
		{
		case "MPESA":
			//1. Get phone details
			//2. instruct Safaricom to send money via MPESA

			MpesaPayUtil.PostToMpesaTest(wm.getAmount(), member.getTelephone());

			break;
		case "EFT":
			//1. Get banking details
			//2. instruct our bank to pay via EFT
			break;
		case "BANKMOBI":
			//1. Get member phone
			//2. instruct our bank to pay via MobileMoney
			break;

		}

		return re;

	}

	private RequestResult AccountWithdraw(Long AccountId, double Amount)
			throws Exception {
		return AccountWithdraw(AccountId, Amount, "Withdrawal", "");
	}

	private RequestResult AccountWithdraw(Long AccountId, double Amount,
			String Narr, String reference) throws Exception {
		RequestResult re = new RequestResult();
		re.setSuccess(true);
		re.setResultMessage("Success");

		List<Transaction> txns = TransactionFactory.Withdraw(AccountId, Amount,
				Narr, reference);

		BatchSimulateStatus bss = TransactionPost.SimulatePost(txns,
				PostingCheckFlag.CheckLimitAndPassFlag);
		boolean canPost = bss.CanPost();
		if (!canPost) {
			String msg = "";
			for (SimulatePostStatus s : bss.SimulateStatus) {
				for (Exception e : s.Errors) {
					msg += e.getMessage() + "\n";
				}
			}
			re.setSuccess(true);
			re.setResultMessage("Simulation Error: \n" + msg);
			return re;
		}

		TransactionPost.Post(txns);
		return re;
	}
}
