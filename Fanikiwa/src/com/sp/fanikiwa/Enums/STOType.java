package com.sp.fanikiwa.Enums;

public enum STOType {
	Normal(0), Sweep(1);

	private int value;

	private STOType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
