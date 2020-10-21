package com.bit.day25;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex08BufferInOutStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data.bin";
		String path2 = "data2.bin";
		File src = new File(path);
		File target = new File(path2);
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		byte[] buffer = new byte[8];
		try {
			fis = new FileInputStream(path);
			fos = new FileOutputStream(target);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			while(true) {
				int su = bis.read(buffer); // buffer�� �Է��ϰ�
				if(su == -1) {
					break;
				}
				bos.write(buffer, 0, su); // buffer�� �Է��Ѵ�.
			}
			bos.flush(); // buffer�� �������� ������� �ۼ�
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) { // close�� ������ �������� �ϴ� ���� �Ϲ����̴�.
					bis.close();
				}
				if(bos != null) {
					bos.close();
				}
				if(fis != null) {
					fis.close();
				}
				if(fos != null) {
					fos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
