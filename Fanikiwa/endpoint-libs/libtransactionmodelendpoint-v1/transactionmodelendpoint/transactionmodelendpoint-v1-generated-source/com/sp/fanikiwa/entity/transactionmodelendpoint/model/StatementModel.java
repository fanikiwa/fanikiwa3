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
 * on 2015-05-30 at 05:34:43 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.transactionmodelendpoint.model;

/**
 * Model definition for StatementModel.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the transactionmodelendpoint. For a detailed explanation
 * see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class StatementModel extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double amount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double balance;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String contraReference;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double credit;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double debit;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String narrative;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime postDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long transactionID;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAmount() {
    return amount;
  }

  /**
   * @param amount amount or {@code null} for none
   */
  public StatementModel setAmount(java.lang.Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getBalance() {
    return balance;
  }

  /**
   * @param balance balance or {@code null} for none
   */
  public StatementModel setBalance(java.lang.Double balance) {
    this.balance = balance;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getContraReference() {
    return contraReference;
  }

  /**
   * @param contraReference contraReference or {@code null} for none
   */
  public StatementModel setContraReference(java.lang.String contraReference) {
    this.contraReference = contraReference;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getCredit() {
    return credit;
  }

  /**
   * @param credit credit or {@code null} for none
   */
  public StatementModel setCredit(java.lang.Double credit) {
    this.credit = credit;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getDebit() {
    return debit;
  }

  /**
   * @param debit debit or {@code null} for none
   */
  public StatementModel setDebit(java.lang.Double debit) {
    this.debit = debit;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getNarrative() {
    return narrative;
  }

  /**
   * @param narrative narrative or {@code null} for none
   */
  public StatementModel setNarrative(java.lang.String narrative) {
    this.narrative = narrative;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getPostDate() {
    return postDate;
  }

  /**
   * @param postDate postDate or {@code null} for none
   */
  public StatementModel setPostDate(com.google.api.client.util.DateTime postDate) {
    this.postDate = postDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getTransactionID() {
    return transactionID;
  }

  /**
   * @param transactionID transactionID or {@code null} for none
   */
  public StatementModel setTransactionID(java.lang.Long transactionID) {
    this.transactionID = transactionID;
    return this;
  }

  @Override
  public StatementModel set(String fieldName, Object value) {
    return (StatementModel) super.set(fieldName, value);
  }

  @Override
  public StatementModel clone() {
    return (StatementModel) super.clone();
  }

}
