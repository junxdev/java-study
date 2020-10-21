package com.bit.day25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex07FileInOutStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "data.bin";
		String path2 = "data2.bin";
		File file = new File(path);
		File file2 = new File(path2);
		if(file2.exists()) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String msg = "abcdefg\n1234567890\n!@#$%^&*()";
		byte[] arr = msg.getBytes();
		byte[] buffer = new byte[32]; // buffer�� ���� ���� ���� �۾��� ������ ��ģ��.
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(file2);
			while(true) {
				int su = fis.read(buffer);
				if(su == -1) {
					break;
				}
				fos.write(buffer, 0, su); // 0���� total number of bytes��ŭ buffer ���� ���� �д´�.
			}
			System.out.println("Task complete");
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
