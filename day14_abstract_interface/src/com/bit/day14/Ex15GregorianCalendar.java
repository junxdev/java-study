package com.bit.day14;

import java.util.Calendar;

public class Ex15GregorianCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.GregorianCalendar cal = null;
		cal = new java.util.GregorianCalendar();
		
		System.out.println(cal.toString());
		System.out.print(cal.get(Calendar.YEAR) + "��");
		System.out.print(1 + cal.get(Calendar.MONTH) + "��");
		System.out.print(cal.get(Calendar.DATE) + "��");
		System.out.print(cal.get(Calendar.HOUR_OF_DAY) + "��");
		System.out.print(cal.get(Calendar.MINUTE) + "��");
		System.out.print(cal.get(Calendar.SECOND) + "��");
	}

}
