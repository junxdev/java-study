package com.bit.day14;

interface Inter05 extends Inter04, Inter03{
	void func02();
//	int func01(); ����� �������̽��� �޼���� �ٸ� Ÿ������ ����
	int func01(int a);
}
public class Ex05Interface implements Inter05{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	public int func01(int a) {
		// TODO Auto-generated method stub
		return a;
	}


}

