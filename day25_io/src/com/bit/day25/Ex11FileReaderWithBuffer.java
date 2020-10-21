package com.bit.day25;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex11FileReaderWithBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data.bin";
		File file = new File(path);
		
		FileReader fr = null;
		char[] cbuf = new char[5];
		
		try {
			fr = new FileReader(file);
			while(true) {
				int su = fr.read(cbuf);
				if(su == -1) {
					break;
				}
				for(int i = 0; i < su; i++) {
					System.out.println(cbuf[i]);
				}
//				System.out.print((char)su);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
