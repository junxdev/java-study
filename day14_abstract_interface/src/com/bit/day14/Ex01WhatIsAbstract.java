package com.bit.day14;

abstract class Lec01 {
	
	public abstract void func01(); // �����ݷ����� ��� ����
	
}

class Lec11 extends Lec01 {
	
	public void func01() {
		System.out.println("���, �������̵忡 ���� �߻� �޼��� ���� Lec11 func01");
		
	}
}

abstract class Lec111 extends Lec01 {
	
}

public abstract class Ex01WhatIsAbstract {
	// abstract class; �߻�Ŭ����
	// �߻� �޼��带 0�� �̻� ���� Ŭ����
	// �߻� �޼��� : �޼����� ����(o), �޼����� ����(x)
	// ���������� ����� �� ���⿡ ���� ����
	// ���� �������� ���� �޼��带 �̷��� ������ Ȱ���� �� ���� 
		public static void main(String[] args) {
			
			System.out.println("main test");
			
//			Lec01 me = new Lec01(); �߻� Ŭ������ ��üȭ(instantiate) �� �� ����
//			me.func01();
						
			Lec11 lec11 = new Lec11();
			lec11.func01();
			
			Lec01 lec01 = new Lec11(); // ������ ��ü ����
			lec01.func01();
			
		}
}
