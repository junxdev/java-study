package com.bit.day22;

import java.io.File;

public class Test01ShowDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\javap\\day22";
		java.io.File file = new java.io.File(path);
//		String pathC = "C:\\";
//		java.io.File fileC = new java.io.File(pathC);
//		System.out.println(fileC.getFreeSpace());
		
		java.util.Locale locale = new java.util.Locale("ko", "KR");
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd a hh:mm", locale);
		
		String[] dirs = new String[2 + file.list().length];
		dirs[0] = ".";
		dirs[1] = "..";
		System.arraycopy(file.list(), 0, dirs, 2, file.list().length);
		int countFile = 0;
		int countFileByte = 0;
		
		for(int i = 0; i < dirs.length; i++) {
			java.io.File temp = new File(dirs[i]);
			System.out.print(dateFormat.format(new java.util.Date(temp.lastModified())) + "\t");
			if(temp.isDirectory()) {
				System.out.print("<DIR>");
			}
			System.out.print("\t");
			if(temp.isFile()) {
				countFile++;
				countFileByte += temp.length();
				System.out.print(temp.length());
			}
			System.out.println("\t" + dirs[i]);
		}
		System.out.println("\t\t" + countFile + "개 파일\t\t" + countFileByte + " 바이트");
		System.out.println("\t\t" + (dirs.length - countFile) + "개 파일\t\t" + (file.getFreeSpace()) + " 바이트 남음");
		
	}

}
