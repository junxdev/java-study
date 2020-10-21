package com.bit.day14;

abstract class Lec03 {
	
	Lec03() {
		System.out.println("Lec03()");
	}
	
	void func01() {
		System.out.println("Lec03 func01");
	}
	
	abstract void func02();
}

class Lec33 extends Lec03 {
	
	Lec33() {
		System.out.println("자식 객체 Lec33 생성");
	}
	
	void func02() {
		System.out.println("자식 객체 Lec33 func02 실행");
	}
	
}

public class Ex03UseAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lec03 me = new Lec33();
		me.func01();
		
		Lec33 you = new Lec33();
		you.func02();
	}

}
