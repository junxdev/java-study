package com.bit.day12;

public class Ex09ExceptionHandlingUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lotto = new int[6];
		
		int count = 0;
		try {
			while(true) {
				lotto[count++] = (int)(Math.random() * 45) + 1;
			}
		} catch (ArrayIndexOutOfBoundsException e) {					// �ؿ�: �ó����� �� ������ ������ �״�� �ΰ� ���� ó��
		}																// ����: ���� ó���� �ִ��� ȸ���ϴ� �������� �ڵ� �ۼ�
		
		for(int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}
	}

}
