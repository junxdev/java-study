package com.bit.day08; 
 
class Ex02 { 

	static int su1; // 값을 입력하지 않아도 변수를 사용할 수 있다.
	static String msg;
	// su1 = 4321; 초기화는 메모리에서 실행되는 메소드 내에서 이루어진다.
 
	public static void main(String[] args) { 
 
		System.out.println(msg + "aaa"); // nullaaa 출력
		func01();

		Ex02 me = new Ex02();
		me.func02();

	}  // main end 
	public static void func01() {
		System.out.println(su1);
	
	}
	public void func02() {
		System.out.println(su1);

	}
 
} // class end 
