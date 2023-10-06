package com.adjecti.entity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CodeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int m = scanner.nextInt();

        String[][] inputData = new String[n][m];
        scanner.nextLine();
        System.out.println("Enter the fields separated by commas: ");
        String s = scanner.nextLine();
        String[] arr = s.trim().split(", ");

        for (int i = 0; i < n; i++) {
            System.out.println("Enter data for row " + (i + 1) + ":");
            String input = scanner.nextLine();
            String[] rowData = input.split(", ");

            for (int j = 0; j < rowData.length; j++) {
                inputData[i][j] = rowData[j];
            }
        }

        // Process the data
        StringBuilder yearArr = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            try {
                String dateStr = findDateString(inputData[i]);
                if (dateStr != null) {
                    Date date = dateFormat.parse(dateStr);
                    String year = new SimpleDateFormat("yyyy").format(date);

                    if (!yearArr.toString().contains(year)) {
                        if (yearArr.length() > 0) {
                            yearArr.append(",");
                        }
                        yearArr.append(year);
                    }
                }
            } catch (Exception e) {
                // Handle exception (you might want to log it)
            }
        }

        System.out.println(yearArr.toString());

        String[] resultYear = yearArr.toString().split(",");
        String[][] resultMat = new String[resultYear.length][13];

        for (int i = 0; i < resultYear.length; i++) {
            System.out.print(resultYear[i] + " " + i);
            System.out.print(" | ");
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            try {
                String dateStr = findDateString(inputData[i]);
                if (dateStr != null) {
                    Date date = dateFormat.parse(dateStr);
                    String year = new SimpleDateFormat("yyyy").format(date);
                    
                    int amount = Integer.parseInt(inputData[i][findAmountIndex(inputData[i])]);
                    int monthIndex = Integer.parseInt(new SimpleDateFormat("MM").format(date));

                    int yearIndex = Arrays.asList(resultYear).indexOf(year);

                    if (resultMat[yearIndex][monthIndex] == null) {
                        resultMat[yearIndex][monthIndex] = String.valueOf(amount);
                    } else {
                        int amount1 = Integer.parseInt(inputData[i][findAmountIndex(inputData[i])]);
                        resultMat[yearIndex][monthIndex] = String.valueOf(amount + amount1);
                    }
                }
            } catch (Exception e) {
                // Handle exception (you might want to log it)
            }
        }

        String[] monthNames = { "Year", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        for (String monthName : monthNames) {
            System.out.print(monthName + " | ");
        }
        System.out.println();

        for (int i = 0; i < resultYear.length; i++) {
            for (int j = 0; j < 13; j++) {
                if (j == 0) {
                    resultMat[i][0] = resultYear[i];
                }
                if (resultMat[i][j] == null) {
                    resultMat[i][j] = "00";
                }
                System.out.print(resultMat[i][j] + "  |  ");
            }
            System.out.println();
        }
    }

     static String findDateString(String[] row) {
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

     static int findAmountIndex(String[] row) {
        for (int i = 0; i < row.length; i++) {
            try {
                Integer.parseInt(row[i]);
                return i;
            } catch (NumberFormatException ignored) {
            }
        }
        return -1;
    }
    
     
     
    


}
