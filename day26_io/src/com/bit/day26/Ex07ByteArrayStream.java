package com.bit.day26;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Ex07ByteArrayStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data4.bin";
		File file = new File(path);
		FileInputStream fis = null;
		ByteArrayOutputStream baos = null;
		ByteArrayInputStream bais = null;
		
		try {
			fis = new FileInputStream(file);
			baos = new ByteArrayOutputStream();
			
			while(true) {
				int su = fis.read();
				if(su == -1) {
					break;
				}
				baos.write(su);
			}
			byte[] result = baos.toByteArray();
			
			System.out.println(Arrays.toString(result));
			System.out.println(new String(result));
			
			bais = new ByteArrayInputStream(result);
			while(true) {
				int su = bais.read();
				if(su == -1) {
					break;
				}
				System.out.print((byte)su + ", ");
			}
		} catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bais != null) {
					bais.close();
				}
				if(baos != null) {
					baos.close();
				}
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
