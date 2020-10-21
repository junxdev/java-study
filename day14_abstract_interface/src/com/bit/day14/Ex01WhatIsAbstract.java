package com.bit.day14;

abstract class Lec01 {
	
	public abstract void func01(); // 세미콜론으로 명령 닫음
	
}

class Lec11 extends Lec01 {
	
	public void func01() {
		System.out.println("상속, 오버라이드에 의한 추상 메서드 구현 Lec11 func01");
		
	}
}

abstract class Lec111 extends Lec01 {
	
}

public abstract class Ex01WhatIsAbstract {
	// abstract class; 추상클래스
	// 추상 메서드를 0개 이상 갖는 클래스
	// 추상 메서드 : 메서드의 선언(o), 메서드의 구현(x)
	// 독립적으로 사용할 수 없기에 구현 강제
	// 아직 구현하지 않은 메서드를 미래의 구조에 활용할 수 있음 
		public static void main(String[] args) {
			
			System.out.println("main test");
			
//			Lec01 me = new Lec01(); 추상 클래스는 객체화(instantiate) 할 수 없다
//			me.func01();
						
			Lec11 lec11 = new Lec11();
			lec11.func01();
			
			Lec01 lec01 = new Lec11(); // 다형성 객체 생성
			lec01.func01();
			
		}
}
