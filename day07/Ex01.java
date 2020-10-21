package com.bit.day07;

public class Ex01 { 

	// method
	// 1. static method;class method
	// 2. non-static method;instance method

	public void func01() {
		System.out.println("non-static method");
		System.out.println("instance method");
	}

	public static void func02() {
		System.out.println("static method");
		System.out.println("class method");
	} 

	public static void main(String[] args) { 
 
		System.out.println("hello"); 
		
		Ex01 me = new Ex01();
		me.func01();

//		me.func02(); // not recommended
		func02();
 
	} // main end 
 
} // class end 
