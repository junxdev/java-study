package com.bit.day25;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex10FileReaderWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data.bin";
		File file = new File(path);
		String msg = "���ڿ� ��Ʈ���� ����\n���Ͽ� �ۼ��մϴ�.";
		char[] arr = msg.toCharArray();
		
		FileReader fr = null;
		FileWriter fw = null; // ���ڿ� ����� ���� Ŭ����
		
		try {
			fw = new FileWriter(file);
			for(int i = 0; i < msg.length(); i++) {
				fw.write(arr[i]);
			}
			fw.flush();
			fr = new FileReader(file);
			while(true) {
				int su = fr.read();
				if(su == -1) {
					break;
				}
				System.out.print((char)su);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
				if(fw != null) {
					fw.close();
				}
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
	}

}
