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
//		su9 = 222; error : final ������ su9
		
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
				int a = su9; // su9�� final�̾�� �ϴ� ���� : ��ü ���� �ø��� �������� �ڷᰡ ������� ���ƾ� �ϹǷ�
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
