package com.bit.day09; 
 
class Ex01 { 

	// method
		// static method : 클래스 메서드
		// non-static method : 인스턴스 메서드
	// variable
		// static variable : 정적, 전역
		// non-static variable : 멤버 필드
	int su = 1234;
	static int su2 = 4321;
	
	// 생성자
		// 생성자의 이름 == 클래스명
		// 리턴 값이 없기 때문에 리턴 자료형을 표기하지 않는다.
		// 리턴 값 대신에 주소 값을 반환한다. 
		// default 생성자 : 클래스명() {}
		// default 생성자는 다른 생성자가 존재하지 않을 시 생략 가능(지금까지는 생략하고 인스턴스를 사용한 것)

		// 자동 생성자 : public Ex01() {}	

	private Ex01() { //다른 클래스에서 Ex01 객체 생성 불가능
		System.out.println("객체 생성");
		return;
	}
 
	public static void main(String[] args) { 
		java.util.Scanner sc = new java.util.Scanner(System.in);

 		Ex01 me = new Ex01();
		Ex01 you = new Ex01();
		
		System.out.println("su = " + me.su); 
 
	} // main end 

	static void func01() {
		System.out.println("static method func01()");
	}
 
	public void func02() {
		System.out.println("non-static method func02()");
	}


} // class end 
