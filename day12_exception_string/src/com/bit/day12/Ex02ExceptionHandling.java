package com.bit.day12;

public class Ex02ExceptionHandling {

	public Ex02ExceptionHandling() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ���� �� �߻��� �� �ִ� ������ ���� ó��
		// 2. ȸ���� �� ���� ������ ���� ó�� ��: JVM �� ����
		String msg = "1234";
		Integer su = new Integer(msg);
		msg = "1234d";
//		su = new Integer(msg); ���� �߻�
//		for(int i = 0; i < msg.length(); i++) {
//			if(Character.isDigit(msg.charAt(i))) {
//			} else {
//				System.out.println("���� �� ���� �Էµ�");
//				return; // main ����
//			}
//		}
		try { // �켱 try block ����
			System.out.println("��������� ������ ������ 1");
			su = new Integer(msg);
			System.out.println("��������� ������ ������ 2");
			System.out.println("su = " + su);
		} catch (NumberFormatException e) { // ���� �߻� �� ������ �ش��ϴ� Ŭ���� ��ü �ڵ� ���� �� catch block ����
			System.out.println("���� Ȯ��");
			System.out.println(e);
		}
		
		
		System.out.println("���α׷� ���� ���� Ȯ��");
	}

}
