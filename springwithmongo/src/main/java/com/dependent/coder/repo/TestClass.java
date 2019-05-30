package com.dependent.coder.repo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class TestClass {
	
	private static final Locale localeTH = new Locale("th", "TH");

	private static final Locale localeEN = new Locale("en", "US");
	
	public static void main(String[] args) throws ParseException {		
		String expDateTh = "2520-02-29";		
		
		System.out.println(getDateENFromThaiDate(expDateTh));
	}
	
	public static String getDateENFromThaiDate(String date) throws ParseException {
		SimpleDateFormat sfTH = new SimpleDateFormat("yyyy-MM-dd",localeTH);
		SimpleDateFormat sfEN = new SimpleDateFormat("yyyy-MM-dd",localeEN);
		
		//input date in thai
		Date date1 = sfTH.parse(date);
		
		//return date in english
		return sfEN.format(date1);
	}

//	public static String getDateEnSmartCard(String date) throws ParseException {
//		System.out.println("expDateTh :: "+date);
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd" , new Locale ("th", "TH"));
//		//formatter.setLenient(false);
//		Date formattedt = formatter.parse(date);
//		System.out.println(formattedt);
//		Date expDate = getDateENFromThaiDate(formattedt);		
//		System.out.println(expDate);
//		return formatter.format(expDate);
//	}
} 
