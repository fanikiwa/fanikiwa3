/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-03-26 20:30:19 UTC)
 * on 2015-07-04 at 07:52:45 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.accountendpoint.model;

/**
 * Model definition for AccountDTO.
 *
 * <p>
 * This is the Java data model class that specifies how to parse/serialize into
 * the JSON that is transmitted over HTTP when working with the accountendpoint.
 * For a detailed explanation see: <a
 * href="http://code.google.com/p/google-http-java-client/wiki/JSON"
 * >http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class AccountDTO extends com.google.api.client.json.GenericJson {

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	@com.google.api.client.json.JsonString
	private java.lang.Long accountID;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String accountName;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String accountNo;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	@com.google.api.client.json.JsonString
	private java.lang.Long accounttype;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Boolean accrueInSusp;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Double accruedInt;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Double accruedIntInSusp;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Double bookBalance;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String branch;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Double clearedBalance;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Boolean closed;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	@com.google.api.client.json.JsonString
	private java.lang.Long coadet;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private com.google.api.client.util.DateTime createDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	@com.google.api.client.json.JsonString
	private java.lang.Long customer;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	@com.google.api.client.json.JsonString
	private java.lang.Long intPayAccount;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String interestAccrualInterval;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String interestApplicationMethod;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String interestComputationMethod;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String interestComputationTerm;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Double interestRate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Double interestRateSusp;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private com.google.api.client.util.DateTime lastIntAccrualDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private com.google.api.client.util.DateTime lastIntAppDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Double limit;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.Integer limitCheckFlag;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String limitFlag;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private com.google.api.client.util.DateTime maturityDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private com.google.api.client.util.DateTime nextIntAccrualDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private com.google.api.client.util.DateTime nextIntAppDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String passFlag;

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Long getAccountID() {
		return accountID;
	}

	/**
	 * @param accountID
	 *            accountID or {@code null} for none
	 */
	public AccountDTO setAccountID(java.lang.Long accountID) {
		this.accountID = accountID;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName
	 *            accountName or {@code null} for none
	 */
	public AccountDTO setAccountName(java.lang.String accountName) {
		this.accountName = accountName;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo
	 *            accountNo or {@code null} for none
	 */
	public AccountDTO setAccountNo(java.lang.String accountNo) {
		this.accountNo = accountNo;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Long getAccounttype() {
		return accounttype;
	}

	/**
	 * @param accounttype
	 *            accounttype or {@code null} for none
	 */
	public AccountDTO setAccounttype(java.lang.Long accounttype) {
		this.accounttype = accounttype;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Boolean getAccrueInSusp() {
		return accrueInSusp;
	}

	/**
	 * @param accrueInSusp
	 *            accrueInSusp or {@code null} for none
	 */
	public AccountDTO setAccrueInSusp(java.lang.Boolean accrueInSusp) {
		this.accrueInSusp = accrueInSusp;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Double getAccruedInt() {
		return accruedInt;
	}

	/**
	 * @param accruedInt
	 *            accruedInt or {@code null} for none
	 */
	public AccountDTO setAccruedInt(java.lang.Double accruedInt) {
		this.accruedInt = accruedInt;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Double getAccruedIntInSusp() {
		return accruedIntInSusp;
	}

	/**
	 * @param accruedIntInSusp
	 *            accruedIntInSusp or {@code null} for none
	 */
	public AccountDTO setAccruedIntInSusp(java.lang.Double accruedIntInSusp) {
		this.accruedIntInSusp = accruedIntInSusp;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Double getBookBalance() {
		return bookBalance;
	}

	/**
	 * @param bookBalance
	 *            bookBalance or {@code null} for none
	 */
	public AccountDTO setBookBalance(java.lang.Double bookBalance) {
		this.bookBalance = bookBalance;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getBranch() {
		return branch;
	}

	/**
	 * @param branch
	 *            branch or {@code null} for none
	 */
	public AccountDTO setBranch(java.lang.String branch) {
		this.branch = branch;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Double getClearedBalance() {
		return clearedBalance;
	}

	/**
	 * @param clearedBalance
	 *            clearedBalance or {@code null} for none
	 */
	public AccountDTO setClearedBalance(java.lang.Double clearedBalance) {
		this.clearedBalance = clearedBalance;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Boolean getClosed() {
		return closed;
	}

	/**
	 * @param closed
	 *            closed or {@code null} for none
	 */
	public AccountDTO setClosed(java.lang.Boolean closed) {
		this.closed = closed;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Long getCoadet() {
		return coadet;
	}

	/**
	 * @param coadet
	 *            coadet or {@code null} for none
	 */
	public AccountDTO setCoadet(java.lang.Long coadet) {
		this.coadet = coadet;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            createDate or {@code null} for none
	 */
	public AccountDTO setCreateDate(
			com.google.api.client.util.DateTime createDate) {
		this.createDate = createDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Long getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            customer or {@code null} for none
	 */
	public AccountDTO setCustomer(java.lang.Long customer) {
		this.customer = customer;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Long getIntPayAccount() {
		return intPayAccount;
	}

	/**
	 * @param intPayAccount
	 *            intPayAccount or {@code null} for none
	 */
	public AccountDTO setIntPayAccount(java.lang.Long intPayAccount) {
		this.intPayAccount = intPayAccount;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getInterestAccrualInterval() {
		return interestAccrualInterval;
	}

	/**
	 * @param interestAccrualInterval
	 *            interestAccrualInterval or {@code null} for none
	 */
	public AccountDTO setInterestAccrualInterval(
			java.lang.String interestAccrualInterval) {
		this.interestAccrualInterval = interestAccrualInterval;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getInterestApplicationMethod() {
		return interestApplicationMethod;
	}

	/**
	 * @param interestApplicationMethod
	 *            interestApplicationMethod or {@code null} for none
	 */
	public AccountDTO setInterestApplicationMethod(
			java.lang.String interestApplicationMethod) {
		this.interestApplicationMethod = interestApplicationMethod;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getInterestComputationMethod() {
		return interestComputationMethod;
	}

	/**
	 * @param interestComputationMethod
	 *            interestComputationMethod or {@code null} for none
	 */
	public AccountDTO setInterestComputationMethod(
			java.lang.String interestComputationMethod) {
		this.interestComputationMethod = interestComputationMethod;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getInterestComputationTerm() {
		return interestComputationTerm;
	}

	/**
	 * @param interestComputationTerm
	 *            interestComputationTerm or {@code null} for none
	 */
	public AccountDTO setInterestComputationTerm(
			java.lang.String interestComputationTerm) {
		this.interestComputationTerm = interestComputationTerm;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Double getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate
	 *            interestRate or {@code null} for none
	 */
	public AccountDTO setInterestRate(java.lang.Double interestRate) {
		this.interestRate = interestRate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Double getInterestRateSusp() {
		return interestRateSusp;
	}

	/**
	 * @param interestRateSusp
	 *            interestRateSusp or {@code null} for none
	 */
	public AccountDTO setInterestRateSusp(java.lang.Double interestRateSusp) {
		this.interestRateSusp = interestRateSusp;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getLastIntAccrualDate() {
		return lastIntAccrualDate;
	}

	/**
	 * @param lastIntAccrualDate
	 *            lastIntAccrualDate or {@code null} for none
	 */
	public AccountDTO setLastIntAccrualDate(
			com.google.api.client.util.DateTime lastIntAccrualDate) {
		this.lastIntAccrualDate = lastIntAccrualDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getLastIntAppDate() {
		return lastIntAppDate;
	}

	/**
	 * @param lastIntAppDate
	 *            lastIntAppDate or {@code null} for none
	 */
	public AccountDTO setLastIntAppDate(
			com.google.api.client.util.DateTime lastIntAppDate) {
		this.lastIntAppDate = lastIntAppDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Double getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            limit or {@code null} for none
	 */
	public AccountDTO setLimit(java.lang.Double limit) {
		this.limit = limit;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.Integer getLimitCheckFlag() {
		return limitCheckFlag;
	}

	/**
	 * @param limitCheckFlag
	 *            limitCheckFlag or {@code null} for none
	 */
	public AccountDTO setLimitCheckFlag(java.lang.Integer limitCheckFlag) {
		this.limitCheckFlag = limitCheckFlag;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getLimitFlag() {
		return limitFlag;
	}

	/**
	 * @param limitFlag
	 *            limitFlag or {@code null} for none
	 */
	public AccountDTO setLimitFlag(java.lang.String limitFlag) {
		this.limitFlag = limitFlag;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getMaturityDate() {
		return maturityDate;
	}

	/**
	 * @param maturityDate
	 *            maturityDate or {@code null} for none
	 */
	public AccountDTO setMaturityDate(
			com.google.api.client.util.DateTime maturityDate) {
		this.maturityDate = maturityDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getNextIntAccrualDate() {
		return nextIntAccrualDate;
	}

	/**
	 * @param nextIntAccrualDate
	 *            nextIntAccrualDate or {@code null} for none
	 */
	public AccountDTO setNextIntAccrualDate(
			com.google.api.client.util.DateTime nextIntAccrualDate) {
		this.nextIntAccrualDate = nextIntAccrualDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getNextIntAppDate() {
		return nextIntAppDate;
	}

	/**
	 * @param nextIntAppDate
	 *            nextIntAppDate or {@code null} for none
	 */
	public AccountDTO setNextIntAppDate(
			com.google.api.client.util.DateTime nextIntAppDate) {
		this.nextIntAppDate = nextIntAppDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getPassFlag() {
		return passFlag;
	}

	/**
	 * @param passFlag
	 *            passFlag or {@code null} for none
	 */
	public AccountDTO setPassFlag(java.lang.String passFlag) {
		this.passFlag = passFlag;
		return this;
	}

	@Override
	public AccountDTO set(String fieldName, Object value) {
		return (AccountDTO) super.set(fieldName, value);
	}

	@Override
	public AccountDTO clone() {
		return (AccountDTO) super.clone();
	}

}
