package com.bit.day14;

interface Inter01 {
	public abstract void func01(); // ���� �߻� �޼��常 ���´�. ���� ����� ���� �������̵� ����
	public void func02(); // ���� abstract ���� ����
	
//	public void func02() {
//		System.out.println("�޼��� ������ �Ұ���");
//	}
	void func03(); // ���� �� default�� �ƴ� public ���, ���� ����� interface���� ��
//	private void func03(); ����� �ʿ��ϹǷ� private ��� �Ұ���
//	Inter01() { Ŭ������ �ƴϱ� ������ ������ ������ �Ұ����ϰ� ���� ��ü ������ �Ұ���(?)
//		
//	}
	public static final int su1 = 1111; // public static final ������ ����
	static final int su2 = 2222; // ���� �� default�� �ƴ� public ���, ���� ����� interface���� ��
	final int su3 = 3333; // ��ü�� �����Ƿ� �׻� static
	int su4 = 4444; // ��ü�� �����Ƿ� ������ �Ұ��Ͽ� �׻� final
//	int a; ��ü ������ �Ұ����ϱ⿡ �ʵ� ���� �Ұ���
}

interface Inter02 extends Inter01 {
}
interface Inter03 {
} // Ex05�� Inter05�� ��ӹ����� �ƹ��� �޼��尡 ����
// Ŭ������ ���� ǥ�� : Ŭ���� �� ǥ���� �� ���� �������� �ΰ������� ǥ��
// Ŭ������ �з��ϰ� ����

public class Ex04WhatIsInterface extends Object implements Inter01, Inter02, Inter03, Inter04{ // Ŭ���� ��Ӱ� �����ϸ� ���߻�� ����
	
	public static void main(String[] args) {
		Inter01 me = new Ex04WhatIsInterface();
		me.func01();
		me.func02();
		me.func03();
		System.out.println(Inter01.su1);
		System.out.println(Inter01.su2);
		System.out.println(Inter01.su3);
//		System.out.println(Inter01.su4++); final�̹Ƿ� ����
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
