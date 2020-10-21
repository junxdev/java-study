package com.bit.day22;

public class Ex06IOTemporarySave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String prefix = "AABBCCDDEEFF";
		String suffix = ".txt";
		try {
			java.io.File file = java.io.File.createTempFile(prefix, suffix);
			System.out.println(file.getParent());
		} catch(java.io.IOException e) {
			e.printStackTrace();
		}
	}

}
