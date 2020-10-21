package com.bit.day26;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Student05ObjectInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("data1.bin");
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			com.bit.day27.Student obj = (com.bit.day27.Student) ois.readObject();
			System.out.println(obj.getVersion());
			System.out.println(obj);
//			int su = -1;
//			while((su = fis.read()) != -1) {
//				System.out.print(Integer.toHexString(su) + " ");
////				System.out.println(su);
//			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
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
