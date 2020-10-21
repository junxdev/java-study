package com.bit.day19;

//import com.bit.day19.Lec02.Lec22;

class Lec02 {
	static int su1 = 1111;
	int su2 = 2222;
	
	static class Lec22{
		static int su3 = 3333;
		int su4 = 4444;
		
		Lec22() {}
		
		static void func03() {
			System.out.println("Inner Lec22 func03");
			System.out.println(Lec02.su1);
			Lec02.func01();
			System.out.println(su1);
			func01();
			System.out.println("------------------");
			Lec02 lec02 = new Lec02();
			System.out.println(lec02.su2);
			lec02.func02();
//			System.out.println(su2); error
//			func02(); error
		}
		void func04() {
			System.out.println("Inner Lec22 func04");
			System.out.println(Lec02.su1);
			Lec02.func01();
			System.out.println(su1);
			func01();
			System.out.println("------------------");
			Lec02 lec02 = new Lec02();
			System.out.println(lec02.su2);
			lec02.func02();
//			System.out.println(su2); error
//			func02(); error
		}
	}
	
	Lec02() {}
	
	static void func01() {
		System.out.println(Lec22.su3);
		Lec22.func03();
		System.out.println("Create instance");
		Lec22 inner = new Lec22();
		System.out.println(inner.su4);
		inner.func04();
	}
	
	void func02() {
		System.out.println(Lec22.su3);
		Lec22.func03();
		System.out.println("Create instance");
		Lec22 inner = new Lec22();
		System.out.println(inner.su4);
		inner.func04();
	}
}
public class Ex08StaticInnerClass {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Lec02.Lec22.su3);
		Lec02.Lec22.func03();
		System.out.println("------------------------");
//		Lec22 inner = new Lec22(); // import com.bit.day19.Lec02
		Lec02.Lec22 inner = new Lec02.Lec22();
		System.out.println(inner.su4);
		inner.func04();
		System.out.println("------------------------");
		Lec02.func01();
		System.out.println("------------------------");
		Lec02 inner2 = new Lec02();
		inner2.func02();
		System.out.println("------------------------");
	}

}
