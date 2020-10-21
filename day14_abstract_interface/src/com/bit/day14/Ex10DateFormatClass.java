package com.bit.day14;

import java.text.SimpleDateFormat;

public class Ex10DateFormatClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date now = new java.util.Date();
		System.out.println(now);
		
		java.text.DateFormat df = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL);
		String msg = df.format(now);
		System.out.println(msg);
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yy³â M¿ù dÀÏ");
		msg = sdf.format(now);
		System.out.println(msg);
	}

}
