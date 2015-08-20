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
 * on 2015-07-04 at 07:54:24 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.lendinggroupendpoint.model;

/**
 * Model definition for Account.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the lendinggroupendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Account extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
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
  private AccountType accounttype;

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
  private Coadet coadet;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime createDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Customer customer;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
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
   * @param accountID accountID or {@code null} for none
   */
  public Account setAccountID(java.lang.Long accountID) {
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
   * @param accountName accountName or {@code null} for none
   */
  public Account setAccountName(java.lang.String accountName) {
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
   * @param accountNo accountNo or {@code null} for none
   */
  public Account setAccountNo(java.lang.String accountNo) {
    this.accountNo = accountNo;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public AccountType getAccounttype() {
    return accounttype;
  }

  /**
   * @param accounttype accounttype or {@code null} for none
   */
  public Account setAccounttype(AccountType accounttype) {
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
   * @param accrueInSusp accrueInSusp or {@code null} for none
   */
  public Account setAccrueInSusp(java.lang.Boolean accrueInSusp) {
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
   * @param accruedInt accruedInt or {@code null} for none
   */
  public Account setAccruedInt(java.lang.Double accruedInt) {
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
   * @param accruedIntInSusp accruedIntInSusp or {@code null} for none
   */
  public Account setAccruedIntInSusp(java.lang.Double accruedIntInSusp) {
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
   * @param bookBalance bookBalance or {@code null} for none
   */
  public Account setBookBalance(java.lang.Double bookBalance) {
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
   * @param branch branch or {@code null} for none
   */
  public Account setBranch(java.lang.String branch) {
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
   * @param clearedBalance clearedBalance or {@code null} for none
   */
  public Account setClearedBalance(java.lang.Double clearedBalance) {
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
   * @param closed closed or {@code null} for none
   */
  public Account setClosed(java.lang.Boolean closed) {
    this.closed = closed;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Coadet getCoadet() {
    return coadet;
  }

  /**
   * @param coadet coadet or {@code null} for none
   */
  public Account setCoadet(Coadet coadet) {
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
   * @param createDate createDate or {@code null} for none
   */
  public Account setCreateDate(com.google.api.client.util.DateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * @param customer customer or {@code null} for none
   */
  public Account setCustomer(Customer customer) {
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
   * @param intPayAccount intPayAccount or {@code null} for none
   */
  public Account setIntPayAccount(java.lang.Long intPayAccount) {
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
   * @param interestAccrualInterval interestAccrualInterval or {@code null} for none
   */
  public Account setInterestAccrualInterval(java.lang.String interestAccrualInterval) {
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
   * @param interestApplicationMethod interestApplicationMethod or {@code null} for none
   */
  public Account setInterestApplicationMethod(java.lang.String interestApplicationMethod) {
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
   * @param interestComputationMethod interestComputationMethod or {@code null} for none
   */
  public Account setInterestComputationMethod(java.lang.String interestComputationMethod) {
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
   * @param interestComputationTerm interestComputationTerm or {@code null} for none
   */
  public Account setInterestComputationTerm(java.lang.String interestComputationTerm) {
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
   * @param interestRate interestRate or {@code null} for none
   */
  public Account setInterestRate(java.lang.Double interestRate) {
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
   * @param interestRateSusp interestRateSusp or {@code null} for none
   */
  public Account setInterestRateSusp(java.lang.Double interestRateSusp) {
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
   * @param lastIntAccrualDate lastIntAccrualDate or {@code null} for none
   */
  public Account setLastIntAccrualDate(com.google.api.client.util.DateTime lastIntAccrualDate) {
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
   * @param lastIntAppDate lastIntAppDate or {@code null} for none
   */
  public Account setLastIntAppDate(com.google.api.client.util.DateTime lastIntAppDate) {
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
   * @param limit limit or {@code null} for none
   */
  public Account setLimit(java.lang.Double limit) {
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
   * @param limitCheckFlag limitCheckFlag or {@code null} for none
   */
  public Account setLimitCheckFlag(java.lang.Integer limitCheckFlag) {
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
   * @param limitFlag limitFlag or {@code null} for none
   */
  public Account setLimitFlag(java.lang.String limitFlag) {
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
   * @param maturityDate maturityDate or {@code null} for none
   */
  public Account setMaturityDate(com.google.api.client.util.DateTime maturityDate) {
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
   * @param nextIntAccrualDate nextIntAccrualDate or {@code null} for none
   */
  public Account setNextIntAccrualDate(com.google.api.client.util.DateTime nextIntAccrualDate) {
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
   * @param nextIntAppDate nextIntAppDate or {@code null} for none
   */
  public Account setNextIntAppDate(com.google.api.client.util.DateTime nextIntAppDate) {
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
   * @param passFlag passFlag or {@code null} for none
   */
  public Account setPassFlag(java.lang.String passFlag) {
    this.passFlag = passFlag;
    return this;
  }

  @Override
  public Account set(String fieldName, Object value) {
    return (Account) super.set(fieldName, value);
  }

  @Override
  public Account clone() {
    return (Account) super.clone();
  }

}
