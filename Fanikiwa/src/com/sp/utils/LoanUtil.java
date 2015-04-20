package com.sp.utils;

import java.util.Date;

import com.sp.fanikiwa.entity.Loan;

public class LoanUtil {
	public static Date GetNextIntAccrualDate(Loan loan, Date date) {
		// TODO Auto-generated method stub

		String term = loan.getInterestAccrualInterval();
		int timeInDays =  AccrualTermToInt( term,  date);
		return DateExtension.addDays(date, timeInDays);
	}

	public static int AccrualTermToInt(String term, Date date) {
		if (StringExtension.isNullOrEmpty(term))
			return 1;
		switch (term.toUpperCase()) // D1, D360, D365, M1, M30, Y
		{
		case "D1":
			return 1;
		case "D360":
			return 360;
		case "D365":
			return 365;
		case "M":
			return DateExtension.DaysOfTheMonth(date);
		case "M30":
			return 30;
		case "Y":
			return DateExtension.DaysOfTheYear(date);
		default:
			return 1;
		}
	}

	public static double GetEffectiveIntRate(Loan loan) {
		if (loan.isAccrueInSusp()) {
			return loan.getInterestRateSusp();
		} else {
			return loan.getInterestRate();
		}
	}

	public static int GetAccountTerm(Loan loan, Date date) // return term in days
	{
		return DateExtension.DiffDays(loan.getLastIntAccrualDate(), date);
	}

	public static Date GetNextIntApplicationDate(Loan loan, Date date) {
		String term = loan.getInterestComputationTerm();
		int timeInDays =  AccrualTermToInt( term,  date);
		return DateExtension.addDays(date, timeInDays);
	}

}
