package com.bit.day26;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Ex04PrintStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data1.txt";
		File file = new File(path);
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		Scanner sc = new Scanner(System.in);
		PrintStream ps = null;
		
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			ps = new PrintStream(bos);
			while(true) {
				String msg = sc.nextLine();
				if(msg.isEmpty()) {
					break;
				}
				byte[] by = msg.getBytes(); // outputstream subclass�� byte�� �����
//				fos.write(by);
//				fos.write("\r\n".getBytes());
//				System.out.println(Arrays.toString(by));
//				bos.write(by);
//				bos.newLine(); // ���ڿ��� �ƴ� byte�� ó���ϱ� ������ newLine �޼��尡 ����
				ps.println(by);
//				System.out.write(by);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {
					bos.close();
				}
				if(ps != null) {
					ps.close();
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
