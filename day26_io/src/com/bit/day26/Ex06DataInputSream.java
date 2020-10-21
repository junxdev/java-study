package com.bit.day26;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex06DataInputSream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data2.bin";
		File file = new File(path);
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			byte a = 0;
			short b = 0;
			int c = 0;
			long d = 0;
			float e = 0;
			double f = 0;
			char g = 0;
			boolean h = false;
			String i = null;
			int j = 0;
			int k = 0;
			
			System.out.println(dis.read());
			a = dis.readByte();
			b = dis.readShort();
			c = dis.readInt();
			d = dis.readLong();
			e = dis.readFloat();
			f = dis.readDouble();
			g = dis.readChar();
			h = dis.readBoolean();
			i = dis.readUTF();
			j = dis.readInt();
			k = dis.readInt();
			
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
			System.out.println(e);
			System.out.println(f);
			System.out.println(g);
			System.out.println(h);
			System.out.println(i);
			System.out.println(j);
			System.out.println(k);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if(dis != null) {
					dis.close();
				}
				if(bis != null) {
					bis.close();
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
