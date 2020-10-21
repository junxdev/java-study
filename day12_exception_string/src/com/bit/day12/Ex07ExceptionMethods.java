package com.bit.day12;

public class Ex07ExceptionMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main ����");
		try {
			func01();								// ���⼭ ������ err��
		} catch (NumberFormatException e) {			// ���⼭ ��Ƽ� ���� ó��
			System.out.println("ȸ��");
			System.out.println(e);
			System.out.println(e.toString());
			System.out.println(e.getMessage());						// IO �۾����� ���� �ڿ� �Ҹ� �߻�
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();									// ���� ��� �� �ַ� ���Ǵ� �޼���
			e.printStackTrace();									// ���ڿ� ����� �ý��ۿ� ������� �ʴ´�
			e.printStackTrace();									// �ڿ� �Ҹ� ū IO �۾��� �����ϸ�
			e.printStackTrace();									// �۾��� �������� �ʱ� ������ ȿ����
		}
		System.out.println("main ����");
		
	}
	
	public static void func01() throws NumberFormatException {		// NumberFormatException�� �������� ����� �޼���
		NumberFormatException err = new NumberFormatException();	// ���������� ������ err
		throw err;													// err�� ������
	}

}
