package com.bit.day12;

public class Ex03ExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "10";
		int[] arr = new int[10];
		try {
			int su = Integer.parseInt(msg);
			double su2 = 10.0 / su;
			arr[su] = (int)su2;
			System.out.println("10 / " + msg + " = " + su2);
		} catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭 �ε��� �ʰ�");
		}

	}

}
