package com.bit.day25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex09FileStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data.bin";
		File file = new File(path);
		byte[] buffer = new byte[5];
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			fis = new FileInputStream(file);
			fos.write("문자열을 출력합니다".getBytes());
			//
			while(true) {
				int su = fis.read(buffer);
				if(su == -1) {
					break;
				}
				System.out.println(new String(buffer, 0, su));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
