package com.bit.day19;
class Lec04 {
	static int su1 = 1111;
	int su2 = 2222;
	
	Lec04() {}
	
	static void func01() {
		int su9 = 9999;
		
		class Lec44 {
//			static int su3 = 3333; error
			int su4 = 4444;
			
			Lec44() {}
			
//			static void func03() {} error
			void func04() {}
		}
	}
	
	void func02(int su5) {
		int su9 = 9999;
//		su9 = 222; error : final 생략된 su9
		
		class Lec44 {
//			static int su3 = 3333; error
			static final int su3 = 3333;
			int su4 = 4444;
			
			Lec44() {}
			
//			static void func03() {} error
			void func04() {}
			void func05() {
				func04();
				func02(1);
				int a = su9; // su9가 final이어야 하는 이유 : 객체 생성 시마다 동적으로 자료가 변경되지 말아야 하므로
				int b = su1;
				int c = su2;
				int d = su5;
			}
		}
		
		Lec44 inner = new Lec44();
		System.out.println(inner.su3);
		System.out.println(inner.su4);
		inner.func04();
	}
}
public class Ex11LocalClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
