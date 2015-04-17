package com.sp.utils;
//
//import org.apache.commons.jexl2.JexlContext;
//import org.apache.commons.jexl2.JexlEngine;
//import org.apache.commons.jexl2.MapContext;
//import org.apache.commons.jexl2.UnifiedJEXL;

public  class StringExtension {
	public static boolean isNullOrEmpty(String s) {
	    return s == null || s.length() == 0;
	}
	
	public static String format(String format, Object ... inputs) {
//        JexlContext context = new MapContext();
//        for (int i=0;i<inputs.length;i++) {
//            context.set("_" + (i+1), inputs[i] );
//        }
//        JexlEngine jexl = new JexlEngine();
//        UnifiedJEXL ujexl = new UnifiedJEXL(jexl);
//        UnifiedJEXL.Expression expr = ujexl.parse(format);
//        return expr.evaluate(context).toString();
		return format; //placeholder for now
    }
	
	//parses objects from string by calling the object's constructor
	public static <T> T parseObjectFromString(String s, Class<T> clazz) throws Exception {
	    return clazz.getConstructor(new Class[] {String.class }).newInstance(s);
	}
	
	public static boolean isAlphaNumeric(String s){
	    String pattern= "^[a-zA-Z0-9]*$";
	        if(s.matches(pattern)){
	            return true;
	        }
	        return false;   
	}
	public static boolean isKenyaMobileNumber(String s)
	{
		return s.startsWith("0")  || s.startsWith("+254"); 
	}
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
}
