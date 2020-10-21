package com.bit.day09; 
 
class Ex02 { 

	// 접근제한자
	// public > default > private
	// public : 어디서나 접근 허용
	// default : 별도로 기재하지 않으며 동일 패키지 내에서만 접근 허용
	// pirvate : 동일 클래스 내에서만 접근 허용
	Ex02() {}
	int su;
	void func01() {}
	
 
	public static void main(String[] args) { 
 
		Ex01.func01();
		System.out.println(Ex01.su2);

//		Ex01 you = new Ex01();
//		you.func02();
//		System.out.println(you.su);

//		System.out.println(com.bit.day08.Ex01.a);
 
	} // main end 
 
} // class end 
