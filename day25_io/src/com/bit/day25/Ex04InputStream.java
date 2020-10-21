package com.bit.day25;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ex04InputStream {
	Notepad01UI in;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inn = System.in; 
		try {
			System.out.println(inn.read()); // 가 = new byte[]{(byte)176, (byte)161} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] by = {(byte)176, (byte)161};
		System.out.println(new String(by));
		
		// 위 과정이 Scanner에 포함된 내용으로 Scanner는 util과 IO를 편리하게 만든 클래스다.
		
		File file = new File("data.bin");
		try {
			Scanner sc = new Scanner(file);
			System.out.println(sc.nextLine());
			System.out.println(sc.nextLine());
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
