package com.adjecti.entity;

import java.util.*;

public class YearWise {
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Take user input as a string
	        String input = "Order No,Order Date,Customer No,Amount\n" +
	                "1001,01/03/2021,C001,250000\n" +
	                "1002,11/04/2021,C002,150000\n" +
	                "1003,01/05/2021,C001,300000\n" +
	                "1004,05/06/2021,C001,350000\n" +
	                "1005,07/07/2021,C002,200000\n" +
	                "1006,08/08/2021,C002,250000\n" +
	                "1007,09/09/2021,C001,300000\n" +
	                "1008,10/10/2021,C002,350000\n" +
	                "1009,11/11/2021,C001,400000\n" +
	                "1010,12/12/2021,C001,450000\n" +
	                "1011,01/01/2022,C002,500000\n" +
	                "1012,02/02/2022,C002,550000\n";

	        System.out.println(input);
	        // Convert the input string to a 2D array
	        String[][] data = convertTo2DArray(input);

	        // Perform year-wise and month-wise analysis
	        int[][] yearMonthWiseAnalysis = performYearMonthWiseAnalysis(data);

	        // Display the year-wise and month-wise analysis result
	        displayYearMonthWiseAnalysis(yearMonthWiseAnalysis);
	    }

	    public static String[][] convertTo2DArray(String input) {
	        String[] rows = input.split("\n");
	        String[][] result = new String[rows.length - 1][];
	        for (int i = 1; i < rows.length; i++) {
	            result[i - 1] = rows[i].split(",");
	        }
	        return result;
	    }

	    public static int[][] performYearMonthWiseAnalysis(String[][] data) {
	        int[][] yearMonthWiseAnalysis = new int[12][2];

	        for (String[] row : data) {
	            String orderDate = row[1];
	            String[] dateParts = orderDate.split("/");
	            int year = Integer.parseInt(dateParts[2]);
	            int month = Integer.parseInt(dateParts[1]);

	            yearMonthWiseAnalysis[month - 1][0] = year;  
	            yearMonthWiseAnalysis[month - 1][1] += Integer.parseInt(row[3]);  
	        }

	        return yearMonthWiseAnalysis;
	    }

	    public static void displayYearMonthWiseAnalysis(int[][] yearMonthWiseAnalysis) {
	        System.out.println("Month Year,Total Amount");

	        for (int i = 0; i < 12; i++) {
	            if (yearMonthWiseAnalysis[i][0] != 0) {
	                String monthName = getMonthName(i + 1);
	                System.out.println(monthName + " " + yearMonthWiseAnalysis[i][0] + "," + yearMonthWiseAnalysis[i][1]);
	            }
	        }
	    }

	    public static String getMonthName(int month) {
	        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	        return monthNames[month - 1];
	    }
	    }
