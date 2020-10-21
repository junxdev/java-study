package com.bit.day22;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex08FileOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.io.File file = new java.io.File("ex08.bin");
		java.io.FileOutputStream fos = null;
		
		try {
			fos = new java.io.FileOutputStream(file);
			fos.write('A');
			fos.write('c');
			fos.write('e');
			
			String msg = "hello";
			byte[] msgToByte = msg.getBytes();
			for(int i = 0; i < msgToByte.length; i++) {
				fos.write(msgToByte[i]);
			}
			
			fos.close();
			System.out.println("작성 완료");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
