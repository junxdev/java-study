package com.bit.day26;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex01FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data1.txt";
		File file = new File(path);
		
		FileWriter fw = null;
		
		Scanner sc = new Scanner(System.in);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			fw = new FileWriter(file);
				while(true) {
					String msg = sc.nextLine() + "\n";
					fw.write(msg);
					if(msg.contains("/exit")) {
						break;
					}		
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
