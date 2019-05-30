package com.dependent.coder.repo;

import java.util.Locale;

import java.util.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestDate {

	public static void main(String[] args) throws ParseException {

		// Get the current system date and time.

		Date date = new Date();

		// Get a France locale using a Locale constant.

		Locale localeTH = new Locale("th", "TH");

		// Create an English/US locale using the constructor.

		Locale localeEN = new Locale("en", "US");

		// Get a date time formatter for display in France.

		SimpleDateFormat sfTH = new SimpleDateFormat("yyyy-MM-dd",localeTH);
		SimpleDateFormat sfEN = new SimpleDateFormat("yyyy-MM-dd",localeEN);
		
		Date date1 = sfTH.parse("2520-02-29");

		System.out.println("Locale: " + localeTH.getDisplayName());

		System.out.println(sfTH.format(date1));

		System.out.println("Locale: " + localeEN.getDisplayName());

		System.out.println(sfEN.format(date1));

	}

}