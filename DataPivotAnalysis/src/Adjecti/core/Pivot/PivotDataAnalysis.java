package Adjecti.core.Pivot;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class PivotDataAnalysis {

	 private static String[][] inputData;
	 static  String[] arr;
	static int indexOn2ndCol;
	    private static boolean hasInput = false; // Flag to check if input has been provided

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        if (!hasInput) {
	            System.out.println("Enter number of rows: ");
	            int n = scanner.nextInt();

	            System.out.println("Enter number of columns: ");
	            int m = scanner.nextInt();

	            inputData = new String[n][m];
	            scanner.nextLine(); // Consume the newline

	            System.out.println("Enter the fields separated by commas: ");
	            String s = scanner.nextLine();
	            arr = s.trim().split(", ");
	            for (int i = 0; i < n; i++) {
	                System.out.println("Enter data for row " + (i + 1) + ":");
	                String input = scanner.nextLine();
	                String[] rowData = input.split(", ");

	                for (int j = 0; j < rowData.length; j++) {
	                    inputData[i][j] = rowData[j];
	                }
	            }

	            hasInput = true; // Set the flag to true after input is provided
	        }

	        while (true) {
	            System.out.println("Choose operation:");
	            System.out.println("1. Sorting on 2 columns");
	            System.out.println("2. Yearly Monthly Data");
	            System.out.println("3. Exit");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter the first column name: ");
	                    String firstCol = scanner.nextLine();
	                    System.out.println("Enter the second column name: ");
	                    String secondCol = scanner.nextLine();
	                   
	        	      

	                    
	                   indexOn2ndCol=sortingData(arr, inputData, firstCol, secondCol);
	                   
	                   
	                    break;
	                case 2:
	                	yearlyDistribution(inputData, indexOn2ndCol	);;
	                    break;
	                case 3:
	                    System.out.println("Exiting the application.");
	                    return; 
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }


	    static int sortingData(String[] mat,String[][] arr, String firstCol, String secondCol) { {
	    	int indexOf1stCol = -1;
	    	int indexOn2ndCol = -1;
	    	for (int i = 0; i < mat.length; i++) {
	    	    if (firstCol.equals(mat[i])) {
	    	        indexOf1stCol = i;
	    	    }
	    	    if (secondCol.equals(mat[i])) {
	    	        indexOn2ndCol = i;
	    	    }
	    	}

	    	if (indexOf1stCol == -1 || indexOn2ndCol == -1) {
	    	    System.out.println("Invalid column names.");
	    	    return -1;
	    	}

	        String[][] valueMatrix = new String[inputData.length][2];
	        int resultIndex = 0;

	        for (int i = 0; i < inputData.length; i++) {
	            boolean found = false;
	            for (int j = 0; j < inputData.length; j++) {
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

	        for (int i = 0; i < resultIndex; i++) {
	            for (int j = 0; j < 2; j++) {
	                System.out.print(valueMatrix[i][j] + " ");
	            }
	            System.out.println();
	        }
			return indexOn2ndCol;
	    }
	}

	static void yearlyDistribution(String[][] inputData, int indexOn2ndCol) {
		StringBuilder yearArr = new StringBuilder();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i < inputData.length; i++) {
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
				e.printStackTrace();
			}
		}

//		System.out.println(yearArr.toString());

		String[] resultYear = yearArr.toString().split(",");
		String[][] resultMat = new String[resultYear.length][13];

		for (int i = 0; i < inputData.length; i++) {
			try {
				String dateStr = findDateString(inputData[i]);
				if (dateStr != null) {
					Date date = dateFormat.parse(dateStr);
					String year = new SimpleDateFormat("yyyy").format(date);

					  int amount = Integer.parseInt(inputData[i][indexOn2ndCol]);
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
				e.printStackTrace();
			}
		}
		String[] monthNames = { "Year", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
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
