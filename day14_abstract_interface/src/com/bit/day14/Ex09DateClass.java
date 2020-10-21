package com.bit.day14;

import java.sql.Date;

public class Ex09DateClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(now);
		java.util.Date now = new java.util.Date();
		System.out.print(1900 + now.getYear() + "��");
		System.out.print(1 + now.getMonth() + "��");
		System.out.print(now.getDate() + "��");
		System.out.print(now.getHours() + "��");
		System.out.print(now.getMinutes() + "��");
		System.out.println(now.getSeconds() + "��");
		
		String msg= "";
		for (int i = 0; i < 9999; i++) {
			msg += i;
		}
		
		java.util.Date now2 = new java.util.Date();
		System.out.print(1900 + now2.getYear() + "��");
		System.out.print(1 + now2.getMonth() + "��");
		System.out.print(now2.getDate() + "��");
		switch (now2.getDay()) {
		case 0:	System.out.print("�Ͽ���");	break;
		case 1:	System.out.print("������");	break;
		case 2:	System.out.print("ȭ����");	break;
		case 3:	System.out.print("������");	break;
		case 4:	System.out.print("�����");	break;
		case 5:	System.out.print("�ݿ���");	break;
		case 6:	System.out.print("�����");	break;

		default: break;
		}
		System.out.print(now2.getHours() + "��");
		System.out.print(now2.getMinutes() + "��");
		System.out.println(now2.getSeconds() + "��");
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
