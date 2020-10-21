package com.bit.day08; 
 
class Ex03 { 

	static int a; 	//클래스 변수, 전역 변수로 선언하면 클래스 내 다양한 메소드에서 접근할 수 있어 
			//매개 변수;parameter를 선언하지 않아도 된다.

	public static void func01() {
		a++;
		System.out.println("a = " + a);

	}

	public static void func02() {
		a++;
		int b = a;
		System.out.println("b = " + b);

	}
 
	public static void main(String[] args) { 
 		
		a = 1234;
		func01();
		func02();
 
	} // main end 
 
} // class end 
