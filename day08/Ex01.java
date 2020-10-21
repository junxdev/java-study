package com.bit.day08; 
 
public class Ex01 { 

	//클래스 구성요소
	//1. 메소드
	//2. 변수	

	public static int a = 999; 	//클래스 변수, 전역 변수
	int b;			//멤버 필드, 인스턴스 변수

 	public void func() {
		a++;
		System.out.println("a = " + a); 
	}
		
	public static void main(String[] args) { 

		Ex01 me = new Ex01();
		me.func();
 
	} // main end 
 
} // class end 
