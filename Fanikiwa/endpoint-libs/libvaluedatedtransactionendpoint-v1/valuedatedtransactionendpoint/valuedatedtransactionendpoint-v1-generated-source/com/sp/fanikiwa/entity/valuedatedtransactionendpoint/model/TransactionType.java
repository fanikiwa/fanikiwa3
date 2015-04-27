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
 * on 2015-04-26 at 13:15:28 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model;

/**
 * Model definition for TransactionType.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the valuedatedtransactionendpoint. For a detailed
 * explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class TransactionType extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean absolute;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String amountExpression;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean canSuspend;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean chargeCommission;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean chargeCommissionToTransaction;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String chargeWho;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String commComputationMethod;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double commissionAmount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String commissionAmountExpression;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String commissionContraNarrative;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long commissionCrAccount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long commissionDrAccount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean commissionDrAnotherAccount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String commissionMainNarrative;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer commissionNarrativeFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long commissionTransactionType;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String crCommCalcMethod;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String debitCredit;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double defaultAmount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long defaultContraAccount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String defaultContraNarrative;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long defaultMainAccount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String defaultMainNarrative;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String description;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer dialogFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String drCommCalcMethod;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean forcePost;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer narrativeFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String shortCode;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String statFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long suspenseCrAccount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long suspenseDrAccount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long tieredTableId;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long transactionTypeID;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer txnClass;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer txnTypeView;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer valueDateOffset;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getAbsolute() {
    return absolute;
  }

  /**
   * @param absolute absolute or {@code null} for none
   */
  public TransactionType setAbsolute(java.lang.Boolean absolute) {
    this.absolute = absolute;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAmountExpression() {
    return amountExpression;
  }

  /**
   * @param amountExpression amountExpression or {@code null} for none
   */
  public TransactionType setAmountExpression(java.lang.String amountExpression) {
    this.amountExpression = amountExpression;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getCanSuspend() {
    return canSuspend;
  }

  /**
   * @param canSuspend canSuspend or {@code null} for none
   */
  public TransactionType setCanSuspend(java.lang.Boolean canSuspend) {
    this.canSuspend = canSuspend;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getChargeCommission() {
    return chargeCommission;
  }

  /**
   * @param chargeCommission chargeCommission or {@code null} for none
   */
  public TransactionType setChargeCommission(java.lang.Boolean chargeCommission) {
    this.chargeCommission = chargeCommission;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getChargeCommissionToTransaction() {
    return chargeCommissionToTransaction;
  }

  /**
   * @param chargeCommissionToTransaction chargeCommissionToTransaction or {@code null} for none
   */
  public TransactionType setChargeCommissionToTransaction(java.lang.Boolean chargeCommissionToTransaction) {
    this.chargeCommissionToTransaction = chargeCommissionToTransaction;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getChargeWho() {
    return chargeWho;
  }

  /**
   * @param chargeWho chargeWho or {@code null} for none
   */
  public TransactionType setChargeWho(java.lang.String chargeWho) {
    this.chargeWho = chargeWho;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCommComputationMethod() {
    return commComputationMethod;
  }

  /**
   * @param commComputationMethod commComputationMethod or {@code null} for none
   */
  public TransactionType setCommComputationMethod(java.lang.String commComputationMethod) {
    this.commComputationMethod = commComputationMethod;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getCommissionAmount() {
    return commissionAmount;
  }

  /**
   * @param commissionAmount commissionAmount or {@code null} for none
   */
  public TransactionType setCommissionAmount(java.lang.Double commissionAmount) {
    this.commissionAmount = commissionAmount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCommissionAmountExpression() {
    return commissionAmountExpression;
  }

  /**
   * @param commissionAmountExpression commissionAmountExpression or {@code null} for none
   */
  public TransactionType setCommissionAmountExpression(java.lang.String commissionAmountExpression) {
    this.commissionAmountExpression = commissionAmountExpression;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCommissionContraNarrative() {
    return commissionContraNarrative;
  }

  /**
   * @param commissionContraNarrative commissionContraNarrative or {@code null} for none
   */
  public TransactionType setCommissionContraNarrative(java.lang.String commissionContraNarrative) {
    this.commissionContraNarrative = commissionContraNarrative;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getCommissionCrAccount() {
    return commissionCrAccount;
  }

  /**
   * @param commissionCrAccount commissionCrAccount or {@code null} for none
   */
  public TransactionType setCommissionCrAccount(java.lang.Long commissionCrAccount) {
    this.commissionCrAccount = commissionCrAccount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getCommissionDrAccount() {
    return commissionDrAccount;
  }

  /**
   * @param commissionDrAccount commissionDrAccount or {@code null} for none
   */
  public TransactionType setCommissionDrAccount(java.lang.Long commissionDrAccount) {
    this.commissionDrAccount = commissionDrAccount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getCommissionDrAnotherAccount() {
    return commissionDrAnotherAccount;
  }

  /**
   * @param commissionDrAnotherAccount commissionDrAnotherAccount or {@code null} for none
   */
  public TransactionType setCommissionDrAnotherAccount(java.lang.Boolean commissionDrAnotherAccount) {
    this.commissionDrAnotherAccount = commissionDrAnotherAccount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCommissionMainNarrative() {
    return commissionMainNarrative;
  }

  /**
   * @param commissionMainNarrative commissionMainNarrative or {@code null} for none
   */
  public TransactionType setCommissionMainNarrative(java.lang.String commissionMainNarrative) {
    this.commissionMainNarrative = commissionMainNarrative;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getCommissionNarrativeFlag() {
    return commissionNarrativeFlag;
  }

  /**
   * @param commissionNarrativeFlag commissionNarrativeFlag or {@code null} for none
   */
  public TransactionType setCommissionNarrativeFlag(java.lang.Integer commissionNarrativeFlag) {
    this.commissionNarrativeFlag = commissionNarrativeFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getCommissionTransactionType() {
    return commissionTransactionType;
  }

  /**
   * @param commissionTransactionType commissionTransactionType or {@code null} for none
   */
  public TransactionType setCommissionTransactionType(java.lang.Long commissionTransactionType) {
    this.commissionTransactionType = commissionTransactionType;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCrCommCalcMethod() {
    return crCommCalcMethod;
  }

  /**
   * @param crCommCalcMethod crCommCalcMethod or {@code null} for none
   */
  public TransactionType setCrCommCalcMethod(java.lang.String crCommCalcMethod) {
    this.crCommCalcMethod = crCommCalcMethod;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDebitCredit() {
    return debitCredit;
  }

  /**
   * @param debitCredit debitCredit or {@code null} for none
   */
  public TransactionType setDebitCredit(java.lang.String debitCredit) {
    this.debitCredit = debitCredit;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getDefaultAmount() {
    return defaultAmount;
  }

  /**
   * @param defaultAmount defaultAmount or {@code null} for none
   */
  public TransactionType setDefaultAmount(java.lang.Double defaultAmount) {
    this.defaultAmount = defaultAmount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getDefaultContraAccount() {
    return defaultContraAccount;
  }

  /**
   * @param defaultContraAccount defaultContraAccount or {@code null} for none
   */
  public TransactionType setDefaultContraAccount(java.lang.Long defaultContraAccount) {
    this.defaultContraAccount = defaultContraAccount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDefaultContraNarrative() {
    return defaultContraNarrative;
  }

  /**
   * @param defaultContraNarrative defaultContraNarrative or {@code null} for none
   */
  public TransactionType setDefaultContraNarrative(java.lang.String defaultContraNarrative) {
    this.defaultContraNarrative = defaultContraNarrative;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getDefaultMainAccount() {
    return defaultMainAccount;
  }

  /**
   * @param defaultMainAccount defaultMainAccount or {@code null} for none
   */
  public TransactionType setDefaultMainAccount(java.lang.Long defaultMainAccount) {
    this.defaultMainAccount = defaultMainAccount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDefaultMainNarrative() {
    return defaultMainNarrative;
  }

  /**
   * @param defaultMainNarrative defaultMainNarrative or {@code null} for none
   */
  public TransactionType setDefaultMainNarrative(java.lang.String defaultMainNarrative) {
    this.defaultMainNarrative = defaultMainNarrative;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDescription() {
    return description;
  }

  /**
   * @param description description or {@code null} for none
   */
  public TransactionType setDescription(java.lang.String description) {
    this.description = description;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getDialogFlag() {
    return dialogFlag;
  }

  /**
   * @param dialogFlag dialogFlag or {@code null} for none
   */
  public TransactionType setDialogFlag(java.lang.Integer dialogFlag) {
    this.dialogFlag = dialogFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDrCommCalcMethod() {
    return drCommCalcMethod;
  }

  /**
   * @param drCommCalcMethod drCommCalcMethod or {@code null} for none
   */
  public TransactionType setDrCommCalcMethod(java.lang.String drCommCalcMethod) {
    this.drCommCalcMethod = drCommCalcMethod;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getForcePost() {
    return forcePost;
  }

  /**
   * @param forcePost forcePost or {@code null} for none
   */
  public TransactionType setForcePost(java.lang.Boolean forcePost) {
    this.forcePost = forcePost;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getNarrativeFlag() {
    return narrativeFlag;
  }

  /**
   * @param narrativeFlag narrativeFlag or {@code null} for none
   */
  public TransactionType setNarrativeFlag(java.lang.Integer narrativeFlag) {
    this.narrativeFlag = narrativeFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getShortCode() {
    return shortCode;
  }

  /**
   * @param shortCode shortCode or {@code null} for none
   */
  public TransactionType setShortCode(java.lang.String shortCode) {
    this.shortCode = shortCode;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getStatFlag() {
    return statFlag;
  }

  /**
   * @param statFlag statFlag or {@code null} for none
   */
  public TransactionType setStatFlag(java.lang.String statFlag) {
    this.statFlag = statFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getSuspenseCrAccount() {
    return suspenseCrAccount;
  }

  /**
   * @param suspenseCrAccount suspenseCrAccount or {@code null} for none
   */
  public TransactionType setSuspenseCrAccount(java.lang.Long suspenseCrAccount) {
    this.suspenseCrAccount = suspenseCrAccount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getSuspenseDrAccount() {
    return suspenseDrAccount;
  }

  /**
   * @param suspenseDrAccount suspenseDrAccount or {@code null} for none
   */
  public TransactionType setSuspenseDrAccount(java.lang.Long suspenseDrAccount) {
    this.suspenseDrAccount = suspenseDrAccount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getTieredTableId() {
    return tieredTableId;
  }

  /**
   * @param tieredTableId tieredTableId or {@code null} for none
   */
  public TransactionType setTieredTableId(java.lang.Long tieredTableId) {
    this.tieredTableId = tieredTableId;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getTransactionTypeID() {
    return transactionTypeID;
  }

  /**
   * @param transactionTypeID transactionTypeID or {@code null} for none
   */
  public TransactionType setTransactionTypeID(java.lang.Long transactionTypeID) {
    this.transactionTypeID = transactionTypeID;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getTxnClass() {
    return txnClass;
  }

  /**
   * @param txnClass txnClass or {@code null} for none
   */
  public TransactionType setTxnClass(java.lang.Integer txnClass) {
    this.txnClass = txnClass;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getTxnTypeView() {
    return txnTypeView;
  }

  /**
   * @param txnTypeView txnTypeView or {@code null} for none
   */
  public TransactionType setTxnTypeView(java.lang.Integer txnTypeView) {
    this.txnTypeView = txnTypeView;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getValueDateOffset() {
    return valueDateOffset;
  }

  /**
   * @param valueDateOffset valueDateOffset or {@code null} for none
   */
  public TransactionType setValueDateOffset(java.lang.Integer valueDateOffset) {
    this.valueDateOffset = valueDateOffset;
    return this;
  }

  @Override
  public TransactionType set(String fieldName, Object value) {
    return (TransactionType) super.set(fieldName, value);
  }

  @Override
  public TransactionType clone() {
    return (TransactionType) super.clone();
  }

}
