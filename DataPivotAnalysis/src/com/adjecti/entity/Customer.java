package com.adjecti.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Customer {

	public static void main(String[] args) throws ParseException {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of rows: ");
		int rows = scanner.nextInt();

		System.out.print("Enter number of columns: ");
		int cols = scanner.nextInt();

		String[][] stringMatrix = new String[rows][cols];
		scanner.nextLine();
		System.out.println("Enter the fields ---eg-  , ");
		String s = scanner.nextLine();
		String[] arr = s.trim().split(", ");

		for (int i = 0; i < rows; i++) {

			System.out.println("Enter data for row " + (i + 1) + ":");
			String input = scanner.nextLine();
			String[] rowData = input.split(", ");

			for (int j = 0; j < rowData.length; j++) {

				stringMatrix[i][j] = rowData[j];
			}
		}

		System.out.println("Matrix:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(stringMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Enter the field --");
		String s1 = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Enter the field --");
		String s2 = scanner.nextLine();
		int indexOfWhichCoulmn = 0;
		int indexonWhichCoulmn = 0;
		int dateColumn = 0;
		String date = "Date";
		System.out.println(date+" before");
		
		
		
		
		
		
	
		  for (int i = 0; i < arr.length; i++) { // System.out.println(arr[i]+" " +i);
		  if (s1.contentEquals(arr[i])) {
		  
		  indexOfWhichCoulmn = i; } if (s2.contentEquals(arr[i])) { indexonWhichCoulmn
		  = i; } if (date.contentEquals(arr[i])) { dateColumn = i; } }
		  
		  Map<String, Integer> hm = new HashMap<>(); for (int i = 0; i < rows; i++) {
		  if (hm.containsKey(stringMatrix[i][indexOfWhichCoulmn])) { int currentValue =
		  hm.get(stringMatrix[i][indexOfWhichCoulmn]); int newValue =
		  Integer.parseInt(stringMatrix[i][indexonWhichCoulmn]);
		  hm.put(stringMatrix[i][indexOfWhichCoulmn], currentValue + newValue); } else
		  { int newValue = Integer.parseInt(stringMatrix[i][indexonWhichCoulmn]);
		  hm.put(stringMatrix[i][indexOfWhichCoulmn], newValue); } }
		  
		  for (Map.Entry<String, Integer> entry : hm.entrySet()) {
		  System.out.println(s1 + " " + entry.getKey() + " " + s2 + " " +
		 entry.getValue()); } System.out.println();
		

//		int[][] yearMonthWiseAnalysis = performYearMonthWiseAnalysis(stringMatrix, indexOfDate,indexonWhichCoulmn);
//
//		displayYearMonthWiseAnalysis(yearMonthWiseAnalysis);
		monthWiseReport(stringMatrix, dateColumn, indexonWhichCoulmn, rows);

	}

//	Sorting by Monthly basis;

	public static void monthWiseReport(String[][] inputData, int dateColumn, int indexonWhichCoulmn, int rows)
			throws ParseException {
		System.out.println("Month wise report---");
		/*
		 * String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
		 * "Aug", "Sep", "Oct", "Nov", "Dec" }; SimpleDateFormat sdf=new
		 * SimpleDateFormat("dd/MM/yyyy");
		 * 
		 * String[] mat=new String[12];
		 * 
		 * Calendar c=Calendar.getInstance();
		 * 
		 * 
		 * for (int i = 0; i < matrix.length - 1; i++) { String
		 * date=matrix[i][dateColumn];
		 * 
		 * Date date3=sdf.parse(date); c.setTime(date3);
		 * System.out.println(c.get(Calendar.YEAR));
		 * 
		 * // System.out.println(date3.getYear());
		 * 
		 * for (int j = i + 1; j < matrix.length; j++) { Date date1 =
		 * sdf.parse(matrix[i][dateColumn]); Date date2 =
		 * sdf.parse(matrix[j][dateColumn]);
		 * 
		 * if (date1.compareTo(date2) > 0) { // Swap rows i and j String[] temp =
		 * matrix[i]; matrix[i] = matrix[j]; matrix[j] = temp; } }
		 * 
		 * for (int l = 0; l < 12; l++) { System.out.print(monthNames[l]+" ");
		 * 
		 * }
		 * 
		 * 
		 * System.out.println();
		 * 
		 * for (int l = 0; l < matrix.length; l++) { for(int q=0;q<12;q++) {
		 * if(q==indexonWhichCoulmn) { mat[l]=matrix[l][indexonWhichCoulmn]; } else {
		 * mat[l]=null; } }
		 * 
		 * 
		 * } for(int l=0;l<mat.length;l++) { System.out.println(mat[l]+" "); } }
		 * 
		 */

		int minYear = Integer.MAX_VALUE;
		int maxYear = Integer.MIN_VALUE;
		for (String[] row : inputData) {
			System.out.println(row[2]);
			String dateStr = findDateString(row);
			System.out.println(dateStr);
			if (dateStr != null) {
				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
					int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
					minYear = Math.min(minYear, year);
					maxYear = Math.max(maxYear, year);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		List<String[]> resultRows = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i < rows; i++) {
			try {
				String dateStr = findDateString(inputData[i]);
				if (dateStr != null) {
					Date date = dateFormat.parse(dateStr);
					String year = new SimpleDateFormat("yyyy").format(date);
					System.out.println(year);
					String[] resultRow;

					if ((resultRow = findResultRow(resultRows, year)) == null) {
						resultRow = new String[13];
						resultRow[0] = year;
						resultRows.add(resultRow);
					}

					int amount = Integer.parseInt(inputData[i][findAmountIndex(inputData[i])]);
					System.out.println(amount);
					int monthIndex = Integer.parseInt(new SimpleDateFormat("MM").format(date));
					System.out.println(monthIndex);
					
					
					resultRow[monthIndex] = String.valueOf(amount);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (String[] row : resultRows) {
			for (String value : row) {
				System.out.print(value != null ? value : "null");
				System.out.print(" | ");
			}
			System.out.println();
			System.out.println("row");
		}

		System.out.println("Month wise report---Done");

	}

	public static String findDateString(String[] row) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (String s : row) {
			try {
				dateFormat.parse(s);
				return s;
			} catch (Exception ignored) {
			}
		}
		return null;
	}

	public static int findAmountIndex(String[] row) {
		for (int i = 0; i < row.length; i++) {
			try {
				Integer.parseInt(row[i]);
				return i;
			} catch (NumberFormatException ignored) {
			}
		}
		return -1;
	}

	public static String[] findResultRow(List<String[]> resultRows, String year) {
		for (String[] row : resultRows) {
			if (row[0].equals(year)) {
				return row;
				
			}
		}
		return null;
	}

}

//	public static int[][] performYearMonthWiseAnalysis(String[][] data, int indexOfDate,int indexonWhichCoulmn) {
//
//		int[][] yearMonthWiseAnalysis = new int[12][indexOfDate];
//
//		for (String[] row : data) {
//			String orderDate = row[indexOfDate];
//			String[] dateParts = orderDate.split("/");
//			int year = Integer.parseInt(dateParts[2]);
//			int month = Integer.parseInt(dateParts[1]);
//
//			yearMonthWiseAnalysis[month - 1][0] = year;
//			yearMonthWiseAnalysis[month - 1][1] += Integer.parseInt(row[indexonWhichCoulmn]);
//
//		}
//
//		return yearMonthWiseAnalysis;
//	}
//
//	public static void displayYearMonthWiseAnalysis(int[][] yearMonthWiseAnalysis) {
//
//		for (int i = 0; i < 12; i++) {
//			if (yearMonthWiseAnalysis[i][0] != 0) {
//				String monthName = getMonthName(i + 1);
//				System.out.println(monthName + " " + yearMonthWiseAnalysis[i][0] + "," + yearMonthWiseAnalysis[i][1]);
//			}
//		}
//	}
//
//	public static String getMonthName(int month) {
//		String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
//		return monthNames[month - 1];
//	}
