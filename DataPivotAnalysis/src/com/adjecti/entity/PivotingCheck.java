package com.adjecti.entity;

import java.util.Scanner;

public class PivotingCheck {

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

//		find the index on which pivoting start

		System.out.println("Enter the first column ");
		String firstCol = scanner.nextLine();
		System.out.println("Enter the first column ");
		String secondCol = scanner.nextLine();
		int indexOf1stCol = 0;
		int indexOn2ndCol = 0;
		for (int i = 0; i < arr.length; i++) {
			if (firstCol.equals(arr[i])) {
				indexOf1stCol = i;
			}
			if (secondCol.equals(arr[i])) {
				indexOn2ndCol = i;
			}
		}

//		String [] firstColKey=new String[2];
	
		
		String[][] valueMatrix = new String[n][2];
		int resultIndex = 0;

		for (int i = 0; i < n; i++) {
		    boolean found = false;
		    for (int j = 0; j < n; j++) {
		        if (valueMatrix[j][0] != null && valueMatrix[j][0].equals(inputData[i][indexOf1stCol])) {
		            int value = Integer.parseInt(valueMatrix[j][1]);
		            int value1 = Integer.parseInt(inputData[i][indexOn2ndCol]);
		            valueMatrix[j][1] = String.valueOf(value + value1);
		            found = true;
		            break;  
		        }
		    }
		    if (!found) {
		        valueMatrix[resultIndex][0] = inputData[i][indexOf1stCol];
		        valueMatrix[resultIndex][1] = inputData[i][indexOn2ndCol];
		        resultIndex++;
		    }
		}

	
		for(int i=0; i<resultIndex; i++) {
		    for(int j=0; j<2; j++) {
		        System.out.print(valueMatrix[i][j]+" ");
		    }
		    System.out.println();
		}

	}

}
