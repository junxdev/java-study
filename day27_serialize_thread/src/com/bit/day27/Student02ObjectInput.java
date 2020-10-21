package com.bit.day27;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Student02ObjectInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("data1.bin");
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			Student student = (Student)ois.readObject();
			student.show();
			System.out.println("�й� : " + student.num);
			System.out.println("�̸� : " + student.name);
			System.out.println("���� : " + student.kor);
			System.out.println("���� : " + student.eng);
//			System.out.println("���� : " + student.math);
			System.out.println(student);
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
