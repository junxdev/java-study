package com.bit.day19;
class Lec03 {
	static int su1 = 1111;
	int su2 = 2222;
	
	class Lec33 {
//		static int su3 = 3333; // 객체 생성 시에 변형될 수 있으므로 불가능
		static final int su5 = 5555; // 예외 : 컴파일 시점부터 상수 영역에 고정
		int su4 = 4444;
		
//		static void func03() {}
		void func04() {
			System.out.println(su1);
			func01();
			Lec03 inner = new Lec03();
			System.out.println(inner.su2);
			inner.func02();
			System.out.println(su2); // Lec33 객체는 Lec03 객체에 기반하므로 su2를 Lec33 > Lec03에서 찾는다. (상속에서 부모 클래스에서 찾듯이)
			func02();
		}
	}
	
	Lec03() {}
	
	static void func01() {
//		Lec33 lec33 = new Lec33(); 컴파일 시점에 Lec33 객체는 생성되지 않음
		Lec03 lec03 = new Lec03(); // 임의로 Lec03 객체를 생성 후
		Lec33 lec33 = lec03.new Lec33(); // Lec33 객체 생성
		System.out.println(lec33.su4);
		lec33.func04();
	}
	
	void func02() { // Lec03 객체 생성(Lec33 객체 함께 생성됨)
		Lec33 lec33 = new Lec33(); // 
		System.out.println(lec33.su4);
		lec33.func04();
	}
}
public class Ex10NonStaticInnverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lec03 outer = new Lec03();
//		Lec03.Lec33 inner = new Lec03.Lec33();
		Lec03.Lec33 inner = outer.new Lec33(); // Lec03.Lec33 타입의 outer.Lec33의 객체 inner 생성
		
		inner.func04();
	}

}
