package com.bit.day27;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ex05IOWithScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = null;
		try {
			File file = new File("test01.txt");
			is = new FileInputStream(file);
			Scanner sc = new Scanner(is);
			System.out.println(sc.nextLine());
			System.out.println(sc.nextLine());
			System.out.println(sc.nextLine());
			System.out.println(sc.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
