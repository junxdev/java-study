package com.bit.day27;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03OutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "문자열 메시지를 작성합니다.\n12345\nABCDEFG";
		// try with : jdk 1.8부터 허용한다.
		try ( 
			OutputStream os = new FileOutputStream("test01.txt"); // 괄호 안에서 선언
			) {
			os.write(msg.getBytes());
			System.out.println("Task complete"); // 자동으로 close
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
