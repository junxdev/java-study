package com.bit.day12;

public class Ex06WhereExceptionHappens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main ����");
		for(int i = 0; i < 6; i++) {
			try {
				func01(i);
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				System.out.println("���� ȸ��");				
			}
		}
		System.out.println("main ����");
	}
	
	public static void func01(int a) throws ArrayIndexOutOfBoundsException {
		System.out.println("���� Ȯ�� ���� 1");
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println("���� Ȯ�� ���� 2");
		System.out.println(arr[a]);
		System.out.println("���� Ȯ�� ���� 3");
	}

}
