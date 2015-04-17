package com.sp.fanikiwa.business.financialtransactions;

import java.util.List;

import com.sp.fanikiwa.Enums.PostingCheckFlag;
import com.sp.fanikiwa.api.AccountEndpoint;
import com.sp.fanikiwa.entity.BatchSimulateStatus;
import com.sp.fanikiwa.entity.DoubleEntry;
import com.sp.fanikiwa.entity.MultiEntry;
import com.sp.fanikiwa.entity.Transaction;

public class TransactionPost {

    public static void Post(List<Transaction> txns)
    {
        //now request posting service to post
        AccountEndpoint aep = new AccountEndpoint();
        MultiEntry multiEntry = new MultiEntry();
        multiEntry.setTransactions(txns);
        aep.BatchPost(multiEntry,PostingCheckFlag.CheckLimitAndPassFlag);
    }

    public static void Post(DoubleEntry de)
    {
    	 AccountEndpoint aep = new AccountEndpoint();
    	aep.DoubleEntryPost(de,PostingCheckFlag.CheckLimitAndPassFlag);
    }

    public static BatchSimulateStatus SimulatePost(List<Transaction> txns,PostingCheckFlag flags)
    {
        AccountEndpoint aep = new AccountEndpoint();
        MultiEntry multiEntry = new MultiEntry(txns);
        return aep.Simulate(multiEntry,flags);
    }

	public static void BatchPost(List<Transaction> txns,
			PostingCheckFlag postingCheckFlag) {
		AccountEndpoint aep = new AccountEndpoint();
		aep.BatchPost(new MultiEntry(txns), postingCheckFlag);
	}

}
