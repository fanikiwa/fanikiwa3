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
 * on 2015-05-30 at 05:42:55 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.accountendpoint.model;

/**
 * Model definition for SimulatePostStatus.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the accountendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class SimulatePostStatus extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("AccountID") @com.google.api.client.json.JsonString
  private java.lang.Long accountID;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("BlockedStatus")
  private java.lang.String blockedStatus;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("BookBalanceBeforePosting")
  private java.lang.Double bookBalanceBeforePosting;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("ClearedBalanceBeforePosting")
  private java.lang.Double clearedBalanceBeforePosting;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("Errors")
  private java.util.List<Exception> errors;

  static {
    // hack to force ProGuard to consider Exception used, since otherwise it would be stripped out
    // see http://code.google.com/p/google-api-java-client/issues/detail?id=528
    com.google.api.client.util.Data.nullOf(Exception.class);
  }

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("Limit")
  private java.lang.Double limit;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("LimitStatus")
  private java.lang.String limitStatus;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("TransactionAmount")
  private java.lang.Double transactionAmount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("TransactionTypeId") @com.google.api.client.json.JsonString
  private java.lang.Long transactionTypeId;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean canPost;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getAccountID() {
    return accountID;
  }

  /**
   * @param accountID accountID or {@code null} for none
   */
  public SimulatePostStatus setAccountID(java.lang.Long accountID) {
    this.accountID = accountID;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getBlockedStatus() {
    return blockedStatus;
  }

  /**
   * @param blockedStatus blockedStatus or {@code null} for none
   */
  public SimulatePostStatus setBlockedStatus(java.lang.String blockedStatus) {
    this.blockedStatus = blockedStatus;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getBookBalanceBeforePosting() {
    return bookBalanceBeforePosting;
  }

  /**
   * @param bookBalanceBeforePosting bookBalanceBeforePosting or {@code null} for none
   */
  public SimulatePostStatus setBookBalanceBeforePosting(java.lang.Double bookBalanceBeforePosting) {
    this.bookBalanceBeforePosting = bookBalanceBeforePosting;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getClearedBalanceBeforePosting() {
    return clearedBalanceBeforePosting;
  }

  /**
   * @param clearedBalanceBeforePosting clearedBalanceBeforePosting or {@code null} for none
   */
  public SimulatePostStatus setClearedBalanceBeforePosting(java.lang.Double clearedBalanceBeforePosting) {
    this.clearedBalanceBeforePosting = clearedBalanceBeforePosting;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<Exception> getErrors() {
    return errors;
  }

  /**
   * @param errors errors or {@code null} for none
   */
  public SimulatePostStatus setErrors(java.util.List<Exception> errors) {
    this.errors = errors;
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
  public SimulatePostStatus setLimit(java.lang.Double limit) {
    this.limit = limit;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getLimitStatus() {
    return limitStatus;
  }

  /**
   * @param limitStatus limitStatus or {@code null} for none
   */
  public SimulatePostStatus setLimitStatus(java.lang.String limitStatus) {
    this.limitStatus = limitStatus;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getTransactionAmount() {
    return transactionAmount;
  }

  /**
   * @param transactionAmount transactionAmount or {@code null} for none
   */
  public SimulatePostStatus setTransactionAmount(java.lang.Double transactionAmount) {
    this.transactionAmount = transactionAmount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getTransactionTypeId() {
    return transactionTypeId;
  }

  /**
   * @param transactionTypeId transactionTypeId or {@code null} for none
   */
  public SimulatePostStatus setTransactionTypeId(java.lang.Long transactionTypeId) {
    this.transactionTypeId = transactionTypeId;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getCanPost() {
    return canPost;
  }

  /**
   * @param canPost canPost or {@code null} for none
   */
  public SimulatePostStatus setCanPost(java.lang.Boolean canPost) {
    this.canPost = canPost;
    return this;
  }

  @Override
  public SimulatePostStatus set(String fieldName, Object value) {
    return (SimulatePostStatus) super.set(fieldName, value);
  }

  @Override
  public SimulatePostStatus clone() {
    return (SimulatePostStatus) super.clone();
  }

}
