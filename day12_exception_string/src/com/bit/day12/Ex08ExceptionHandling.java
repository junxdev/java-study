package com.bit.day12;

public class Ex08ExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};

		try {
			for(int i = 0; i < 10; i++) {
				System.out.println(arr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {		// i < 10������ i�� 5�� �� ���� ó��
			System.out.println("���� ȸ��");				// try - catch ������ ������ ������ ��Ȳ�� ���� ����� �ٸ� ���� ���
		}
		
	}

}
