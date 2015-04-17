package com.sp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateExtension {
	
	private final static String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";
	
	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
	public static Date addMonths(Date date, int months)
	{
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}
	public static Date addYears(Date date, int years)
	{
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.add(Calendar.YEAR, years);
		return cal.getTime();
	}
	
	public static Date parse(String s) throws ParseException
	{
		return parse( s, DATE_FORMAT);
	}
	public static Date parse(String s, String Format) throws ParseException
	{
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat(Format);
		return df.parse(s);
	}
	
	public static Date parse(String s, Locale locale) throws ParseException
	{
		 int style = DateFormat.MEDIUM;
		 DateFormat   df = DateFormat.getDateInstance(style,locale);
		return df.parse(s);
	}
}
