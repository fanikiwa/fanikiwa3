package com.sp.fanikiwa.entity;

import java.util.ArrayList;

public class EMI {

	private double rate; // in Years
	private double principal;
	private double installmentAmount;
	private double months;
	private double totalInterest;
	private double totalAmount;
	private double intPerMonth;
	private ArrayList<EMIInstallment> installments;

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(double installment) {
		this.installmentAmount = installment;
	}

	public double getTotalInterest() {
		return totalInterest;
	}

	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getIntPerMonth() {
		return intPerMonth;
	}

	public void setIntPerMonth(double intPerMonth) {
		this.intPerMonth = intPerMonth;
	}

	public ArrayList<EMIInstallment> getInstallments() {
		return installments;
	}

	public void setInstallments(ArrayList<EMIInstallment> installments) {
		this.installments = installments;
	}

	public double getMonths() {
		return months;
	}

	public void setMonths(double months) {
		this.months = months;
	}

}
