package com.bit.day22;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex09FileInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.io.File file = new java.io.File("ex08.bin");
		java.io.FileInputStream fis = null;
		
		
		try {
			fis = new java.io.FileInputStream(file);

			while(true) {
				int su = fis.read();
				if(su == -1) { // at the end of the file, return -1;
					break;
				} else {
					System.out.println((char)(su));
				}
			}
			fis.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
