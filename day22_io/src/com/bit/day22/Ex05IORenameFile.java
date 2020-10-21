package com.bit.day22;

public class Ex05IORenameFile {

	public static void main(String[] args) {
		String path = ".\\test02.txt";
		java.io.File file = new java.io.File(path);
		
		String rename = ".\\test03.txt";
		java.io.File file2 = new java.io.File(rename);
		
		file.renameTo(file2);
	}
}
