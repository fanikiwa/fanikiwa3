package com.sp.fanikiwa.entity;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Account {

	@Id
	Long accountID;

	private String accountName;

	private String accountNo;

	private double accruedInt;

	private double bal30;

	private double bal60;

	private double bal90;

	private double balOver90;

	private double bookBalance;

	private String branch;

	private double clearedBalance;

	private boolean closed;

	private double interestRate;

	private double intRate30;

	private double intRate60;

	private double intRate90;

	private double intRateOver90;

	private double limit;

	private int limitCheckFlag;

	private int limitFlag;

	private int passFlag;

	// Foreign Keys
	@Load
	Ref<Customer> customer;

	@Load
	Ref<Coadet> coadet;

	@Load
	Ref<AccountType> accounttype;

	public Account() {
	}

	public Long getAccountID() {
		return this.accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getAccruedInt() {
		return this.accruedInt;
	}

	public void setAccruedInt(double accruedInt) {
		this.accruedInt = accruedInt;
	}

	public double getBal30() {
		return this.bal30;
	}

	public void setBal30(double bal30) {
		this.bal30 = bal30;
	}

	public double getBal60() {
		return this.bal60;
	}

	public void setBal60(double bal60) {
		this.bal60 = bal60;
	}

	public double getBal90() {
		return this.bal90;
	}

	public void setBal90(double bal90) {
		this.bal90 = bal90;
	}

	public double getBalOver90() {
		return this.balOver90;
	}

	public void setBalOver90(double balOver90) {
		this.balOver90 = balOver90;
	}

	public double getBookBalance() {
		return this.bookBalance;
	}

	public void setBookBalance(double bookBalance) {
		this.bookBalance = bookBalance;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getClearedBalance() {
		return this.clearedBalance;
	}

	public void setClearedBalance(double clearedBalance) {
		this.clearedBalance = clearedBalance;
	}

	public boolean getClosed() {
		return this.closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getIntRate30() {
		return this.intRate30;
	}

	public void setIntRate30(double intRate30) {
		this.intRate30 = intRate30;
	}

	public double getIntRate60() {
		return this.intRate60;
	}

	public void setIntRate60(double intRate60) {
		this.intRate60 = intRate60;
	}

	public double getIntRate90() {
		return this.intRate90;
	}

	public void setIntRate90(double intRate90) {
		this.intRate90 = intRate90;
	}

	public double getIntRateOver90() {
		return this.intRateOver90;
	}

	public void setIntRateOver90(double intRateOver90) {
		this.intRateOver90 = intRateOver90;
	}

	public double getLimit() {
		return this.limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public int getLimitCheckFlag() {
		return this.limitCheckFlag;
	}

	public void setLimitCheckFlag(int limitCheckFlag) {
		this.limitCheckFlag = limitCheckFlag;
	}

	public int getLimitFlag() {
		return this.limitFlag;
	}

	public void setLimitFlag(int i) {
		this.limitFlag = i;
	}

	public int getPassFlag() {
		return this.passFlag;
	}

	public void setPassFlag(int i) {
		this.passFlag = i;
	}

	// Foreign Keys

	public Customer getCustomer() {
		return this.customer.get();
	}

	public void setCustomer(Customer customer) {
		this.customer = Ref.create(customer);
	}

	public AccountType getAccounttype() {
		return this.accounttype.get();
	}

	public void setAccounttype(AccountType accounttype) {
		this.accounttype = Ref.create(accounttype);
	}

	public Coadet getCoadet() {
		return this.coadet.get();
	}

	public void setCoadet(Coadet coadet) {
		this.coadet = Ref.create(coadet);
	}
}