package com.sp.fanikiwa.business.Jobs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.api.server.spi.response.NotFoundException;
import com.sp.fanikiwa.api.LoanEndpoint;
import com.sp.fanikiwa.business.InterestComponent;
import com.sp.fanikiwa.business.financialtransactions.GenericTransaction;
import com.sp.fanikiwa.business.financialtransactions.NarrativeFormat;
import com.sp.fanikiwa.business.financialtransactions.TransactionPost;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.Loan;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.Offer;
import com.sp.fanikiwa.entity.RequestResult;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.fanikiwa.entity.TransactionType;
import com.sp.utils.Config;
import com.sp.utils.DateExtension;
import com.sp.utils.GLUtil;
import com.sp.utils.LoanUtil;
import com.sp.utils.StringExtension;

public class JobApplyLoanInterest implements IJobItem {
	boolean EnableLog = true;
	String userID = "SYS";
	String Authorizer = "Auth";
	private static final Logger log = Logger
			.getLogger(JobAccrueLoanInterest.class.getName());

	@Override
	public void Run(Date d) {
		// TODO Auto-generated method stub
		if (EnableLog)
			log.info("Interest accrual for [" + d + "] started");
		ApplyLoanInterest(d);
		if (EnableLog)
			log.info("Interest accrual for [" + d + "] ended");
	}

	private void ApplyLoanInterest(Date d) {
		// TODO Auto-generated method stub
		LoanEndpoint ep = new LoanEndpoint();
		Collection<Loan> _Schedule = ep.NextIntAppLoanByDate(d).getItems();

		if (EnableLog)
			log.info("Processing Loan Int application [" + _Schedule.size()
					+ "] Loan transactions");
		for (Loan loan : _Schedule) {
			// Process now
			try {
				String msg = String.format("Accruing interest for LoanId[%s]",
						loan.getId());
				if (EnableLog)
					log.info(msg);

				ProcessLoanInterestApplication(loan, d);
				if (EnableLog)
					log.info("Processing Accrual [" + loan.getId()
							+ "] completed");
			} catch (Exception ex) {
				log.log(Level.SEVERE,
						"An error occurred while processing Accrual for Loan["
								+ loan.getId() + "] \n", ex);
			}

		}

	}

	private void ProcessLoanInterestApplication(Loan loan, Date date)
			throws NotFoundException {

		// step 1. create loan application transactions.
		List<Transaction> txns = LoanInterestApplicationTransactions(loan);

		// step 2. post the transactions.
		RequestResult res = TransactionPost.Post(txns);
		if (res.isResult()) {

			// step 3. Set varaiables
			LoanEndpoint lep = new LoanEndpoint();
			
			//Zerolize Accrual Interest.
			loan.setAccruedInterest(0);
			loan.setLastIntAppDate(date);
			loan.setNextIntAppDate(LoanUtil.GetNextIntApplicationDate(loan, date));
			
			//Update now
			lep.updateLoan(loan);
		}
	}

	private List<Transaction> LoanInterestApplicationTransactions(Loan loan) {
		// Use this for all general ledger methods that does not post

		// create all transactions
		List<Transaction> txns = new ArrayList<Transaction>();

		TransactionType intt = Config
				.GetTransactionType("INTERESTTRANSACTIONTYPE");
		if (intt == null)
			throw new NullPointerException("Transaction type cannot be null");

		Account paidAccount = GLUtil.GetAccount(loan.getIntPaidAccount());
		Account payingAccount = GLUtil.GetAccount(loan.getIntPayingAccount());

		// Accrue interest
		GenericTransaction inttxn = new GenericTransaction(intt, "INT",
				new Date(), payingAccount, paidAccount,
				loan.getAccruedInterest(), false, "Y", Authorizer, userID, loan
						.getId().toString());

		txns.addAll(inttxn.GetTransactionsIncludingCommission(
				new NarrativeFormat(intt), new NarrativeFormat(intt)));

		return txns;
	}

}