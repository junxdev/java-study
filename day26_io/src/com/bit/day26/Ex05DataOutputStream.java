package com.bit.day26;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05DataOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data2.bin";
		File file = new File(path);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			dos.write(97);
			dos.writeByte(128);
			dos.writeShort(128);
			dos.writeInt(65);
			dos.writeLong(97L);
			dos.writeFloat(3.14F);
			dos.writeDouble(3.14);
			dos.writeChar('A');
			dos.writeBoolean(true);
			dos.writeUTF("¹®ÀÚ¿­");
			dos.writeInt(99);
			dos.writeInt(100);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) {
					dos.close();
				}
				if(fos != null) {
					fos.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
