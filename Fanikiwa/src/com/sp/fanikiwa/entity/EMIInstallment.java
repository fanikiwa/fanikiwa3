package com.sp.fanikiwa.entity;

public class EMIInstallment {
	private int month;
	private double interestPerMonth;
	private double principalPerMonth;
	private double balance;
	private double emi;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getInterestPerMonth() {
		return interestPerMonth;
	}

	public void setInterestPerMonth(double interestPerMonth) {
		this.interestPerMonth = interestPerMonth;
	}

	public double getPrincipalPerMonth() {
		return principalPerMonth;
	}

	public void setPrincipalPerMonth(double principalPerMonth) {
		this.principalPerMonth = principalPerMonth;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

}
