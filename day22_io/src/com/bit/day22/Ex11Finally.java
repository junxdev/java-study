package com.bit.day22;

public class Ex11Finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean boo = true;
		try {
			int[ ]arr = {1, 3, 5, 9};
			System.out.println((arr[2]));
			if(boo) {
				System.exit(1);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("���� ȸ��");
		} finally {
			System.out.println("�����ϼ̽��ϴ�.");
		}
	}

}
