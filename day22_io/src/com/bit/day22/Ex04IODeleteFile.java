package com.bit.day22;

public class Ex04IODeleteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = ".\\test02.txt";
		java.io.File file = new java.io.File(path);
		
		if(file.delete()) {
			System.out.println("���� ���� �Ϸ�");
		} else {
			System.out.println("���� ���� ����");
		}
	}

}
