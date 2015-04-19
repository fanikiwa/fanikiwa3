package com.sp.fanikiwa.business.SMS;
 
public class AccountsListMessage extends FanikiwaMessage {

	public String Pwd;

	public AccountsListMessage() {

	}

	public AccountsListMessage(String pwd) {
		this.Pwd = pwd;
	}

}
