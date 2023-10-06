package com.adjecti.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FieldInput {

	public static Field getInput() {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		String value = scanner.nextLine();
		FieldType type = determineType(value);
		Object objectValue = convertToType(value, type);
		return new Field(name, value, type);
	}

	private static FieldType determineType(String value) {
		if (isInteger(value)) {
			return FieldType.INTEGER;
		} else if (isLong(value)) {
			return FieldType.LONG;
		} else if (isDate(value)) {
			return FieldType.DATE;
		} else {
			return FieldType.STRING; 
		}
	}

	
	 private static Object convertToType(String value, FieldType type) {
	      

	        switch (type) {
	            case INTEGER:
	                return Integer.parseInt(value);
	            case LONG:
	                return Long.parseLong(value);
	            case DATE:
	              
	            case STRING:
	            default:
	                return value;
	        }
	    }
	 
	private static boolean isDate(String value) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);

		try {
			Date date = dateFormat.parse(value);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	private static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static boolean isLong(String value) {
		try {
			Long.parseLong(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
