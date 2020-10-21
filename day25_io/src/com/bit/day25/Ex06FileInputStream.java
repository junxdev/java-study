package com.bit.day25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex06FileInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data.bin";
		File file = new File(path);
		FileInputStream fis = null;
//		byte[] by = new byte[(int)file.length()];
		List<Byte> list = new ArrayList<Byte>();
		
		byte[] buffer =new byte[2];
		if(file.exists()) {
			try {
				fis = new FileInputStream(file);
				while(true) {
//				for(int i = 0; i > file.length(); i++) { // 파일의 크기를 알고 있다는 전제 하에
//					int su = fis.read();
//					if(su == -1) {
//						break;
//					}
//					list.add((byte)su);
					int su = fis.read(buffer); // buffer
					if(su == -1) {
						System.out.println("!!!" + su);
						break;
					}
					System.out.print(su + "\t");
					System.out.println(new String(buffer));
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			Object[] obj = list.toArray();
			byte[] by = new byte[obj.length];
			for(int i = 0; i < by.length; i++) {
				by[i] = (byte)obj[i];
			}
			
		}
	}

}
