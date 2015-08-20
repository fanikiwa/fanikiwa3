package com.sp.fanikiwa.business;

import java.util.ArrayList;

import com.sp.fanikiwa.entity.EMI;
import com.sp.fanikiwa.entity.EMIInstallment;

public class InterestComponent {
	// term is in years and rate is in doubles
	// Interest = Pricipal x rate x time
	/*
	 * A = P(1 + rt); R = r * 100
	 * 
	 * Where:
	 * 
	 * A = Total Accrued Amount (principal + interest) P = Principal Amount I =
	 * Interest Amount r = Rate of Interest per year in double; r = R/100 t =
	 * Time Period involved in months or years
	 * 
	 * From the base formula, A = P(1 + rt) derived from A = P + I and I = Prt
	 * so A = P + I = P + Prt = P(1 + rt)
	 */
	public double ComputeSimpleInterest(double amount, int term, double rate) // Yearly
	{
		return ComputeSimpleInterest("Y", amount, term, rate);
	}

	public double ComputeSimpleInterest(String period, double amount,
			int termInDays, double rate) {
		double termInYears360 = termInDays / 360.0;// turn term into years
		double termInYears365 = termInDays / 365.0;

		if (period.toUpperCase().equals("D"))
			return amount * termInYears360 * (rate / 100.0);

		if (period.toUpperCase().equals("D360"))
			return amount * termInYears360 * (rate / 100.0);

		if (period.toUpperCase().equals("D365"))
			return amount * termInYears365 * (rate / 100.0);

		if (period.toUpperCase().equals("M"))
			return amount * termInYears360 * 30 * (rate / 100.0);
		if (period.toUpperCase().equals("M30"))
			return amount * termInYears360 * 30 * (rate / 100.0);
		if (period.toUpperCase().equals("M360"))
			return amount * termInYears360 * 30 * (rate / 100.0);
		if (period.toUpperCase().equals("M365"))
			return amount * termInYears365 * 30 * (rate / 100.0);

		// Yearly == defaulut
		double t = termInYears360;
		double r = (float) rate / 100;
		double intr = amount * t * r;
		return intr;
	}

	// Compound Interest
	// Always term is in years
	public double ComputeCompoundInterest(double amount, int term, double rate) {
		return amount * Math.pow((1 + rate / 100), term);
	}

	public Double calcEmi(double p, double r, double n) {
		double R = (r / 12) / 100;
		double e = (p * R * (Math.pow((1 + R), n)) / ((Math.pow((1 + R), n)) - 1));

		return e;

	}

	public EMI calcEmiAllMonths(double p, double r, double n) {

		double R = (r / 12) / 100;
		double P = p;
		double e = calcEmi(P, r, n);
		double totalInt = Math.round((e * n) - p);
		double totalAmt = Math.round((e * n));
		double intPerMonth = Math.round(totalInt / n);

		EMI emi = new EMI();
		emi.setPrincipal(P);
		emi.setRate(r);
		emi.setMonths(n);
		emi.setInstallmentAmount(Math.round(e));
		emi.setTotalInterest(totalInt);
		emi.setTotalAmount(totalAmt);

		ArrayList<EMIInstallment> installments = new ArrayList<EMIInstallment>();
		for (double i = 1; i <= n; i++) {
			intPerMonth = (P * R);
			P = ((P) - ((e) - (intPerMonth)));

			EMIInstallment inst = new EMIInstallment();
			inst.setMonth((int) i);
			inst.setInterestPerMonth(Math.round(intPerMonth));
			inst.setPrincipalPerMonth(Math.round((e) - intPerMonth));
			inst.setBalance(Math.round(P));
			installments.add(inst);
		}
		emi.setInstallments(installments);

		return emi;
	}
}
