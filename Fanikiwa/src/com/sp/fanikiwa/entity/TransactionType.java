package com.sp.fanikiwa.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class TransactionType {

	@Id
	Long transactionTypeID;

	private boolean absolute;

	private String amountExpression;

	private boolean canSuspend;

	private boolean chargeCommission;

	private boolean chargeCommissionToTransaction;

	private String chargeWho;

	private String commComputationMethod;

	private double commissionAmount;

	private String commissionAmountExpression;

	private String commissionContraNarrative;

	private Long commissionCrAccount;

	private Long commissionDrAccount;

	private boolean commissionDrAnotherAccount;

	private String commissionMainNarrative;

	private short commissionNarrativeFlag;

	private Long commissionTransactionType;

	private String crCommCalcMethod;

	private String debitCredit;

	private double defaultAmount;

	private Long defaultContraAccount;

	private String defaultContraNarrative;

	private Long defaultMainAccount;

	private String defaultMainNarrative;

	private String description;

	private short dialogFlag;

	private String drCommCalcMethod;

	private boolean forcePost;

	private short narrativeFlag;

	private String shortCode;

	private String statFlag;

	private Long suspenseCrAccount;

	private Long suspenseDrAccount;

	private Long tieredTableId;

	private short txnClass;

	private short txnTypeView;

	private short valueDateOffset;

	public TransactionType() {
	}

	public Long getTransactionTypeID() {
		return this.transactionTypeID;
	}

	public void setTransactionTypeID(Long transactionTypeID) {
		this.transactionTypeID = transactionTypeID;
	}

	public boolean getAbsolute() {
		return this.absolute;
	}

	public void setAbsolute(boolean absolute) {
		this.absolute = absolute;
	}

	public String getAmountExpression() {
		return this.amountExpression;
	}

	public void setAmountExpression(String amountExpression) {
		this.amountExpression = amountExpression;
	}

	public boolean getCanSuspend() {
		return this.canSuspend;
	}

	public void setCanSuspend(boolean canSuspend) {
		this.canSuspend = canSuspend;
	}

	public boolean getChargeCommission() {
		return this.chargeCommission;
	}

	public void setChargeCommission(boolean chargeCommission) {
		this.chargeCommission = chargeCommission;
	}

	public boolean getChargeCommissionToTransaction() {
		return this.chargeCommissionToTransaction;
	}

	public void setChargeCommissionToTransaction(
			boolean chargeCommissionToTransaction) {
		this.chargeCommissionToTransaction = chargeCommissionToTransaction;
	}

	public String getChargeWho() {
		return this.chargeWho;
	}

	public void setChargeWho(String chargeWho) {
		this.chargeWho = chargeWho;
	}

	public String getCommComputationMethod() {
		return this.commComputationMethod;
	}

	public void setCommComputationMethod(String commComputationMethod) {
		this.commComputationMethod = commComputationMethod;
	}

	public double getCommissionAmount() {
		return this.commissionAmount;
	}

	public void setCommissionAmount(double commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public String getCommissionAmountExpression() {
		return this.commissionAmountExpression;
	}

	public void setCommissionAmountExpression(String commissionAmountExpression) {
		this.commissionAmountExpression = commissionAmountExpression;
	}

	public String getCommissionContraNarrative() {
		return this.commissionContraNarrative;
	}

	public void setCommissionContraNarrative(String commissionContraNarrative) {
		this.commissionContraNarrative = commissionContraNarrative;
	}

	public Long getCommissionCrAccount() {
		return this.commissionCrAccount;
	}

	public void setCommissionCrAccount(Long commissionCrAccount) {
		this.commissionCrAccount = commissionCrAccount;
	}

	public Long getCommissionDrAccount() {
		return this.commissionDrAccount;
	}

	public void setCommissionDrAccount(Long commissionDrAccount) {
		this.commissionDrAccount = commissionDrAccount;
	}

	public boolean getCommissionDrAnotherAccount() {
		return this.commissionDrAnotherAccount;
	}

	public void setCommissionDrAnotherAccount(boolean commissionDrAnotherAccount) {
		this.commissionDrAnotherAccount = commissionDrAnotherAccount;
	}

	public String getCommissionMainNarrative() {
		return this.commissionMainNarrative;
	}

	public void setCommissionMainNarrative(String commissionMainNarrative) {
		this.commissionMainNarrative = commissionMainNarrative;
	}

	public short getCommissionNarrativeFlag() {
		return this.commissionNarrativeFlag;
	}

	public void setCommissionNarrativeFlag(short commissionNarrativeFlag) {
		this.commissionNarrativeFlag = commissionNarrativeFlag;
	}

	public Long getCommissionTransactionType() {
		return this.commissionTransactionType;
	}

	public void setCommissionTransactionType(Long commissionTransactionType) {
		this.commissionTransactionType = commissionTransactionType;
	}

	public String getCrCommCalcMethod() {
		return this.crCommCalcMethod;
	}

	public void setCrCommCalcMethod(String crCommCalcMethod) {
		this.crCommCalcMethod = crCommCalcMethod;
	}

	public String getDebitCredit() {
		return this.debitCredit;
	}

	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}

	public double getDefaultAmount() {
		return this.defaultAmount;
	}

	public void setDefaultAmount(double defaultAmount) {
		this.defaultAmount = defaultAmount;
	}

	public Long getDefaultContraAccount() {
		return this.defaultContraAccount;
	}

	public void setDefaultContraAccount(Long defaultContraAccount) {
		this.defaultContraAccount = defaultContraAccount;
	}

	public String getDefaultContraNarrative() {
		return this.defaultContraNarrative;
	}

	public void setDefaultContraNarrative(String defaultContraNarrative) {
		this.defaultContraNarrative = defaultContraNarrative;
	}

	public Long getDefaultMainAccount() {
		return this.defaultMainAccount;
	}

	public void setDefaultMainAccount(Long defaultMainAccount) {
		this.defaultMainAccount = defaultMainAccount;
	}

	public String getDefaultMainNarrative() {
		return this.defaultMainNarrative;
	}

	public void setDefaultMainNarrative(String defaultMainNarrative) {
		this.defaultMainNarrative = defaultMainNarrative;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getDialogFlag() {
		return this.dialogFlag;
	}

	public void setDialogFlag(short dialogFlag) {
		this.dialogFlag = dialogFlag;
	}

	public String getDrCommCalcMethod() {
		return this.drCommCalcMethod;
	}

	public void setDrCommCalcMethod(String drCommCalcMethod) {
		this.drCommCalcMethod = drCommCalcMethod;
	}

	public boolean getForcePost() {
		return this.forcePost;
	}

	public void setForcePost(boolean forcePost) {
		this.forcePost = forcePost;
	}

	public short getNarrativeFlag() {
		return this.narrativeFlag;
	}

	public void setNarrativeFlag(short narrativeFlag) {
		this.narrativeFlag = narrativeFlag;
	}

	public String getShortCode() {
		return this.shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getStatFlag() {
		return this.statFlag;
	}

	public void setStatFlag(String statFlag) {
		this.statFlag = statFlag;
	}

	public Long getSuspenseCrAccount() {
		return this.suspenseCrAccount;
	}

	public void setSuspenseCrAccount(Long suspenseCrAccount) {
		this.suspenseCrAccount = suspenseCrAccount;
	}

	public Long getSuspenseDrAccount() {
		return this.suspenseDrAccount;
	}

	public void setSuspenseDrAccount(Long suspenseDrAccount) {
		this.suspenseDrAccount = suspenseDrAccount;
	}

	public Long getTieredTableId() {
		return this.tieredTableId;
	}

	public void setTieredTableId(Long tieredTableId) {
		this.tieredTableId = tieredTableId;
	}

	public short getTxnClass() {
		return this.txnClass;
	}

	public void setTxnClass(short txnClass) {
		this.txnClass = txnClass;
	}

	public short getTxnTypeView() {
		return this.txnTypeView;
	}

	public void setTxnTypeView(short txnTypeView) {
		this.txnTypeView = txnTypeView;
	}

	public short getValueDateOffset() {
		return this.valueDateOffset;
	}

	public void setValueDateOffset(short valueDateOffset) {
		this.valueDateOffset = valueDateOffset;
	}

}