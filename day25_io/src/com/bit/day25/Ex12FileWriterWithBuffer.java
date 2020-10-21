package com.bit.day25;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex12FileWriterWithBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data.bin";
		String path2 = "data2.bin";
		File src = new File(path);
		File target = new File(path2);
		
		FileReader fr = null;
		FileWriter fw = null;
		char[] cbuf = new char[5];
		
		try {
			fr = new FileReader(src);
			fw = new FileWriter(target);
			while(true) {
				int su = fr.read(cbuf, 0, cbuf.length);
				if(su == -1) {
					break;
				}
				fw.write(cbuf, 0, su);
//				System.out.print((char)su);
			}
			fw.write("\n한 줄 추가");
			System.out.println("task done");
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
