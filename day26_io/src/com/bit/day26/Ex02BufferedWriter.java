package com.bit.day26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex02BufferedWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data1.txt";
		String path2 = "copy.txt";
		
		File source = new File(path);
		File target = new File(path2);
		
		Scanner sc = new Scanner(System.in);
		
		if(!target.exists()) {
			try {
				target.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileReader fr = null;
		FileWriter fw = null;
		char[] cbuffer = new char[5];
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			fr = new FileReader(source);
			fw = new FileWriter(target);
			
			br = new BufferedReader(fr); // ���� ���� �����͸� ���۰� ū ������ ����� �ʿ� ���� 1����Ʈ�� IO�ص� �ȴ�.
			bw = new BufferedWriter(fw); // ����� �����Ͷ�� ���۰� ū ������ ����ϸ� ������ ����ų �� �ִ�.
			
			while(true) {
//				int readData = fr.read(cbuffer, 0, cbuffer.length);
//				if(readData == -1) {
//					break;
//				}
//				fw.write(cbuffer, 0, readData);
//				String msg = new String(cbuffer, 0, readData);
//				System.out.print(msg);
				
//				int readData = br.read();
//				if(readData == -1) {
//					break;
//				}
//				bw.write(readData);
				
				int readData = br.read(cbuffer, 0, cbuffer.length);
				if(readData == -1) {
					break;
				}
				bw.write(cbuffer, 0, readData);
				bw.newLine(); // Win : \r\n, Linux : \n...
				
				
				
			}
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					fw.close();
				}
				if(br != null) {
					fr.close();
				} 
				if(fw != null) {
					fw.close();
				}
				if(fr != null) {
					fr.close();
				} 
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
		}
	}

}
