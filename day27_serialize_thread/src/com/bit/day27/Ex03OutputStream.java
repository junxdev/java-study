package com.bit.day27;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03OutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "���ڿ� �޽����� �ۼ��մϴ�.\n12345\nABCDEFG";
		// try with : jdk 1.8���� ����Ѵ�.
		try ( 
			OutputStream os = new FileOutputStream("test01.txt"); // ��ȣ �ȿ��� ����
			) {
			os.write(msg.getBytes());
			System.out.println("Task complete"); // �ڵ����� close
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
