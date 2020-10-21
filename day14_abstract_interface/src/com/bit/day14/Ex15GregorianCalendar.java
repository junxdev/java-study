package com.bit.day14;

import java.util.Calendar;

public class Ex15GregorianCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.GregorianCalendar cal = null;
		cal = new java.util.GregorianCalendar();
		
		System.out.println(cal.toString());
		System.out.print(cal.get(Calendar.YEAR) + "년");
		System.out.print(1 + cal.get(Calendar.MONTH) + "월");
		System.out.print(cal.get(Calendar.DATE) + "일");
		System.out.print(cal.get(Calendar.HOUR_OF_DAY) + "시");
		System.out.print(cal.get(Calendar.MINUTE) + "분");
		System.out.print(cal.get(Calendar.SECOND) + "초");
	}

}
