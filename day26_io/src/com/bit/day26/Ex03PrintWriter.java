package com.bit.day26;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex03PrintWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String path = "data1.txt";
		File file = new File(path);
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			
			while(true) {
				String msg = sc.nextLine();
				if(msg.isEmpty()) {
					break;
				}
//				bw.write(msg);
//				bw.newLine();
				pw.println(msg); // filter stream(decoration filter) writer : println 등 다양한 기능
			}
//			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pw != null) {
					pw.close();
				}
				if(bw != null) {
					bw.close();
				}
				if(fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
