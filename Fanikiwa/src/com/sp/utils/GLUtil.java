package com.sp.utils;

import com.sp.fanikiwa.api.AccountEndpoint;
import com.sp.fanikiwa.api.TransactionTypeEndpoint;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.TransactionType;

public class GLUtil {
	/*These are public methods but not APIs*/
	public static double GetAvailableBalance(Account acc)
	{
		return acc.getClearedBalance() - acc.getLimit();
	}
	public static boolean AccountExists(Long id)
	{ 
		if(id == null) return false;
		
		AccountEndpoint aep = new AccountEndpoint();
		Account acc = aep.getAccount(id);
		return acc != null;
	}
	
	public static boolean CheckLimit( Account acc, double Amount)
	{
		return acc.getLimit() > Amount;
	}
	public static Account GetAccount(Long accId)
	{
		if(accId == null) return null;
		AccountEndpoint aep = new AccountEndpoint();
		
		return aep.getAccount(accId);
	}
	public static TransactionType GetTransactionType(Long TtypeId)
	{
		if(TtypeId == null) return null;
		TransactionTypeEndpoint aep = new TransactionTypeEndpoint();
		
		return aep.getTransactionType(TtypeId);
	}
}
