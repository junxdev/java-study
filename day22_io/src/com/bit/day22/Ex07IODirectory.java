package com.bit.day22;

public class Ex07IODirectory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "test\\ex";
		java.io.File file = new java.io.File(path);
		
		file.mkdir();
		
		boolean result = file.delete();
		System.out.println(result);
	}

}
