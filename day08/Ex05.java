package com.bit.day08; 
 
class Ex05 { 

	static int a = 10;
 
	public static void main(String[] args) { 
		int a = 1234;

		Ex01 me1 = new Ex01();
		Ex05 me2 = new Ex05();
		 
		System.out.println("me1 a = " + me1.b);
		System.out.println("me2 a = " + a); 

		me1.a ++;
		 
		System.out.println("me1 a++");
		System.out.println("me1 a = " + me1.a);
		System.out.println("me2 a = " + me2.a); //m2 객체의 필드 a는 변함 없음

		me1.a ++;
		 
		System.out.println("me1 a++");
		System.out.println("me1 a = " + me1.a);
		System.out.println("me2 a = " + me2.a); 
 
	} // main end 
 
} // class end 
