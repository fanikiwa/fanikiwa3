package com.sp.fanikiwa.Enums;

public enum STOCommSourceFlag {
	/*
	 * NoCommission = 0, PayCommPerSTO = 1, PayCommissionPerOnce = 2
	 */
	NoCommission(0), STO(1), TransactionType(2);
	private int value;

	private STOCommSourceFlag(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
