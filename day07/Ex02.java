package com.bit.day07;

class Ex02 { 

/*
	1. direct call: non-static method ~ static method
	2. direct call: non-static method ~ non-static method
	3. direct call: static method ~ static method
	4. reference use: static method ~ static method
*/
 
	public static void main(String[] args) { 
 
		// Ex02 me = new Ex02();
		// me.func02();
		func01();
 
	} // main end 

	public static void func01() {
		System.out.println("static method 1");
		func11();
	}

	public void func02() {
		System.out.println("non-static method 1");
		func22();
	}

	public static void func11() {
		System.out.println("static method 2");
	}

	public void func22() {
		System.out.println("non-static method 2");
	}
 
 
} // class end 
