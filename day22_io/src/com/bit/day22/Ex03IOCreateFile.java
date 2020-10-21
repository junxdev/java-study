package com.bit.day22;

import java.io.IOException;

public class Ex03IOCreateFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = ".\\test02.txt";
		java.io.File file = new java.io.File(path);
		try {
			if(file.createNewFile()) {
				System.out.println("颇老 积己 肯丰");
			} else {
				System.out.println("颇老 积己 角菩");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
