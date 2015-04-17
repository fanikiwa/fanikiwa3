package com.sp.fanikiwa.business;

import java.util.List;

import com.sp.fanikiwa.business.financialtransactions.TransactionFactory;
import com.sp.fanikiwa.business.financialtransactions.TransactionPost;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.utils.MpesaPayUtil;

public class WithdrawalComponent {
	final String USERID = "SYS";
	final String AUTHORIZER = "SYS";

	/*
	 * 1.
	 */
	public String MemberWithdraw(Member member, double Amount) throws Exception {
		String msg="Not Successful";
		//Step 1 Debit the account
		 if(AccountWithdraw(member.getCurrentAccount().getAccountID(), Amount))
		 {
			 //Step 2: Request Mpesa to transfer money
			 MpesaPayUtil.PostToMpesaTest(Amount, member.getTelephone());
			 msg="Successful";
		 }
		 return msg;
	}

	private boolean AccountWithdraw(Long AccountId, double Amount) throws Exception {
		return AccountWithdraw(AccountId, Amount, "Withdrawal", "");
	}

	private boolean AccountWithdraw(Long AccountId, double Amount, String Narr,
			String reference) throws Exception {
		List<Transaction> txns = TransactionFactory.Withdraw(AccountId, Amount,
				Narr, reference);
		TransactionPost.Post(txns);

		return true;
	}
}
