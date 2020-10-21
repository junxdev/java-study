package com.bit.day14;

interface Inter01 {
	public abstract void func01(); // 오직 추상 메서드만 갖는다. 따라서 상속을 통한 오버라이딩 강제
	public void func02(); // 따라서 abstract 생략 가능
	
//	public void func02() {
//		System.out.println("메서드 구현은 불가능");
//	}
	void func03(); // 생략 시 default가 아닌 public 사용, 접근 제어는 interface에서 함
//	private void func03(); 상속이 필요하므로 private 사용 불가능
//	Inter01() { 클래스가 아니기 때문에 생성자 생성이 불가능하고 따라서 객체 생성도 불가능(?)
//		
//	}
	public static final int su1 = 1111; // public static final 변수만 가능
	static final int su2 = 2222; // 생략 시 default가 아닌 public 사용, 접근 제어는 interface에서 함
	final int su3 = 3333; // 객체가 없으므로 항상 static
	int su4 = 4444; // 객체가 없으므로 수정이 불가하여 항상 final
//	int a; 객체 생성이 불가능하기에 필드 생성 불가능
}

interface Inter02 extends Inter01 {
}
interface Inter03 {
} // Ex05의 Inter05가 상속받으나 아무런 메서드가 없음
// 클래스의 정보 표시 : 클래스 명에 표시할 수 없는 정보들을 부가적으로 표시
// 클래스를 분류하고 제약

public class Ex04WhatIsInterface extends Object implements Inter01, Inter02, Inter03, Inter04{ // 클래스 상속과 무관하며 다중상속 가능
	
	public static void main(String[] args) {
		Inter01 me = new Ex04WhatIsInterface();
		me.func01();
		me.func02();
		me.func03();
		System.out.println(Inter01.su1);
		System.out.println(Inter01.su2);
		System.out.println(Inter01.su3);
//		System.out.println(Inter01.su4++); final이므로 오류
	}

	@Override
	public void func01() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void func02() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void func03() {
		// TODO Auto-generated method stub
		
	}

}
