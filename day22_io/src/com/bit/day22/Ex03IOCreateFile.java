package com.bit.day22;

import java.io.IOException;

public class Ex03IOCreateFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = ".\\test02.txt";
		java.io.File file = new java.io.File(path);
		try {
			if(file.createNewFile()) {
				System.out.println("���� ���� �Ϸ�");
			} else {
				System.out.println("���� ���� ����");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
