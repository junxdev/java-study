package com.bit.day19;
class Lec03 {
	static int su1 = 1111;
	int su2 = 2222;
	
	class Lec33 {
//		static int su3 = 3333; // ��ü ���� �ÿ� ������ �� �����Ƿ� �Ұ���
		static final int su5 = 5555; // ���� : ������ �������� ��� ������ ����
		int su4 = 4444;
		
//		static void func03() {}
		void func04() {
			System.out.println(su1);
			func01();
			Lec03 inner = new Lec03();
			System.out.println(inner.su2);
			inner.func02();
			System.out.println(su2); // Lec33 ��ü�� Lec03 ��ü�� ����ϹǷ� su2�� Lec33 > Lec03���� ã�´�. (��ӿ��� �θ� Ŭ�������� ã����)
			func02();
		}
	}
	
	Lec03() {}
	
	static void func01() {
//		Lec33 lec33 = new Lec33(); ������ ������ Lec33 ��ü�� �������� ����
		Lec03 lec03 = new Lec03(); // ���Ƿ� Lec03 ��ü�� ���� ��
		Lec33 lec33 = lec03.new Lec33(); // Lec33 ��ü ����
		System.out.println(lec33.su4);
		lec33.func04();
	}
	
	void func02() { // Lec03 ��ü ����(Lec33 ��ü �Բ� ������)
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
		Lec03.Lec33 inner = outer.new Lec33(); // Lec03.Lec33 Ÿ���� outer.Lec33�� ��ü inner ����
		
		inner.func04();
	}

}
