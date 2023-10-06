package com.adjecti.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClass {
	public static void main(String[] args) {
		
		
		int row=3;
		int coulmn=13;
		String[][] result=new String[row][coulmn];
		
		String[] months=new String[12];
		String[] mon= {"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Oct","Nov","Dec"};
//		for (int i=0;i<12;i++) {
//			System.out.print(mon[i]+" ");
//		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try {
			String str="23/02/2023";
			Calendar calendar=Calendar.getInstance();
			Date date=sdf.parse(str);
			calendar.setTime(date);
			
			for(int i=0;i<row;i++) {
				
			}
					
			
			if(calendar.get(Calendar.MONTH)==1) {
				System.out.println("Feb");
			}
			System.out.println(calendar.get(Calendar.YEAR));
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<coulmn;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

}
