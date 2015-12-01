package com.companyname.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputHelper {

	// Get String from the console
	public static String getStringInput(String prompt) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(prompt);
		System.out.flush();
		
		try {
			return input.readLine();
		} catch (Exception exception) {
			return "Error: " + exception.getMessage();
		}
	}
	
	// Get Integer from the console
	public static int getIntegerInput(String prompt) throws NumberFormatException {
		String input = getStringInput(prompt);
		return Integer.parseInt(input);
	}
	
	// Get Double from the console
	public static double getDoubleInput(String prompt) throws NumberFormatException {
		String input = getStringInput(prompt);
		return Double.parseDouble(input);
	}
	
	// Get Date from the console
	public static java.sql.Date getDateInput(String prompt) throws ParseException {
		String input = getStringInput(prompt);
		Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(input);
		java.sql.Date SQLDate = new java.sql.Date(newDate.getTime());
		return SQLDate;
	}

}












