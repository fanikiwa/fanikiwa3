package com.sp.fanikiwa.business.Jobs;

import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.api.server.spi.response.NotFoundException;
import com.sp.fanikiwa.api.AccountEndpoint;
import com.sp.fanikiwa.api.LoanEndpoint;
import com.sp.fanikiwa.api.STOEndpoint;
import com.sp.fanikiwa.business.InterestComponent;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.Loan;
import com.sp.fanikiwa.entity.STO;
import com.sp.utils.DateExtension;
import com.sp.utils.LoanUtil;
import com.sp.utils.StringExtension;

public class JobAccrueLoanInterest implements IJobItem {

	boolean EnableLog = true;

	private static final Logger log = Logger
			.getLogger(JobAccrueLoanInterest.class.getName());

	@Override
	public void Run(Date d) {
		// TODO Auto-generated method stub
		if (EnableLog)
			log.info("Interest accrual for [" + d + "] started");
		AccrueInterest(d);
		if (EnableLog)
			log.info("Interest accrual for [" + d + "] ended");
	}

	private void AccrueInterest(Date d) {
		// TODO Auto-generated method stub
		LoanEndpoint ep = new LoanEndpoint();
		Collection<Loan> _Schedule = ep.NextIntAccrualLoanByDate(d).getItems();

		if (EnableLog)
			log.info("Processing [" + _Schedule.size() + "] Loan transactions");
		for (Loan loan : _Schedule) {
			// Process now
			try {
				String msg = String.format("Accruing interest for LoanId[%s]",
						loan.getId());
				if (EnableLog)
					log.info(msg);

				ProcessAccrual(loan, d);
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

	private void ProcessAccrual(Loan loan, Date date) throws NotFoundException {
		// 1. Compute interest
		InterestComponent ic = new InterestComponent();
		double intr = 0;
		String period = loan.getInterestComputationTerm();
		if (StringExtension.isNullOrEmpty(period))
			period = "Y";

		String method = loan.getInterestComputationMethod();
		if (!StringExtension.isNullOrEmpty(method)
				&& method.toUpperCase().equals("C")) {
			intr = ic.ComputeCompoundInterest(loan.getAmount(),
					LoanUtil.GetAccountTerm(loan, date),
					(double) LoanUtil.GetEffectiveIntRate(loan));
		} else {
			intr = ic.ComputeSimpleInterest(period, loan.getAmount(),
					LoanUtil.GetAccountTerm(loan, date),
					(double) LoanUtil.GetEffectiveIntRate(loan));
		}

		// 2. Adjust interest accrual field
		if (loan.isAccrueInSusp()) {
			loan.setAccruedIntInSusp(loan.getAccruedIntInSusp() + intr);
		} else {
			loan.setAccruedInterest(loan.getAccruedInterest() + intr);
		}

		// 3. adjusting next accrual date
		AdjustNextAccrualDate(loan, date);
	}

	private void AdjustNextAccrualDate(Loan loan, Date date)
			throws NotFoundException {
		// 1
		Date nextIntAccrualDate = LoanUtil.GetNextIntAccrualDate(loan, date);

		// 2
		loan.setLastIntAccrualDate(date);
		loan.setNextIntAccrualDate(nextIntAccrualDate);
		LoanEndpoint ep = new LoanEndpoint();
		ep.updateLoan(loan);

	}


}
