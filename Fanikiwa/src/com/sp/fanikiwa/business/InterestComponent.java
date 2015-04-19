package com.sp.fanikiwa.business;

public class InterestComponent {
	  // term is in years and rate is in doubles
    //Interest = Pricipal x rate x time
    /*
     * A = P(1 + rt); R = r * 100

Where:

A = Total Accrued Amount (principal + interest)
P = Principal Amount
I = Interest Amount
r = Rate of Interest per year in double; r = R/100
t = Time Period involved in months or years

From the base formula, A = P(1 + rt) derived from A = P + I and I = Prt so A = P + I = P + Prt = P(1 + rt)
     */
    public double ComputeSimpleInterest(double amount, int term, double rate) //Yearly
    {
        return ComputeSimpleInterest("Y", amount, term, rate);
    }
    public double ComputeSimpleInterest(String period, double amount, int term, double rate) 
    {
        if (period.toUpperCase().equals("D"))
            return amount * term * 30.0 * (rate / 100.0);

        if(period.toUpperCase().equals("D360"))
            return amount * (term * 30.0 / 360.0) * (rate / 100.0);

        if (period.toUpperCase().equals("D365"))
            return amount * (term * 30.0 / 365.0) * (rate / 100.0);

        if(period.toUpperCase().equals("M"))
            return amount * term * (rate / 100.0);
            
        //Yearly == defaulut
        double t = (float)term / 12;
        double r =  (float)rate / 100;
        double intr = amount * t * r;
        return intr;
    }


    //Compound Interest
    //Always term is in years
    public double ComputeCompoundInterest(double amount, int term, double rate)
    {
    	return  amount * Math.pow((1 + rate/100),term); 
    }
}

