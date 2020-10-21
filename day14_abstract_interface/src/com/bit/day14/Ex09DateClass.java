package com.bit.day14;

import java.sql.Date;

public class Ex09DateClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(now);
		java.util.Date now = new java.util.Date();
		System.out.print(1900 + now.getYear() + "년");
		System.out.print(1 + now.getMonth() + "월");
		System.out.print(now.getDate() + "일");
		System.out.print(now.getHours() + "시");
		System.out.print(now.getMinutes() + "분");
		System.out.println(now.getSeconds() + "초");
		
		String msg= "";
		for (int i = 0; i < 9999; i++) {
			msg += i;
		}
		
		java.util.Date now2 = new java.util.Date();
		System.out.print(1900 + now2.getYear() + "년");
		System.out.print(1 + now2.getMonth() + "월");
		System.out.print(now2.getDate() + "일");
		switch (now2.getDay()) {
		case 0:	System.out.print("일요일");	break;
		case 1:	System.out.print("월요일");	break;
		case 2:	System.out.print("화요일");	break;
		case 3:	System.out.print("수요일");	break;
		case 4:	System.out.print("목요일");	break;
		case 5:	System.out.print("금요일");	break;
		case 6:	System.out.print("토요일");	break;

		default: break;
		}
		System.out.print(now2.getHours() + "시");
		System.out.print(now2.getMinutes() + "분");
		System.out.println(now2.getSeconds() + "초");
		System.out.println("-----------------------");
		System.out.println(now.before(now2));
		System.out.println(now.after(now2));
		System.out.println(now2.before(now));
		System.out.println(now2.after(now));
		System.out.println("-----------------------");
		System.out.println(now2.compareTo(now));
		System.out.println(now.compareTo(now2));
		
		msg = "2005/05/24 12:00:00";
		System.out.println(Date.parse(msg));
		System.out.println(System.currentTimeMillis());
		System.out.println(now.getTime());
		long t = System.currentTimeMillis();
		java.util.Date now3 = new java.util.Date(t);
		System.out.println(now3);
		now3 = new java.util.Date(Date.parse(msg));
		System.out.println(now3);
		
		java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
		long t2 = gc.getTimeInMillis();
		now3 = new java.util.Date(t2);
		System.out.println(now3);
		
		java.util.Calendar c = java.util.Calendar.getInstance();
		long t3 = c.getTimeInMillis();
		now3 = new java.util.Date(t3);
		System.out.println(now3);
	}

}
