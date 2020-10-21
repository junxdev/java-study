package com.bit.day22;

public class Ex01IOPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path1 = "C:\\javap\\day22\\test01.txt";
		java.io.File file1 = new java.io.File(path1);
		
		System.out.println("대상이 존재하는가? " + file1.exists());
		System.out.println("대상이 파일인가? " + file1.isFile());
		System.out.println("대상이 경로인가? " + file1.isDirectory());
		
		String path2 = "C:\\javap\\day22"; // ".\\" 생략
//		path2 = "..\\day22\\test01"; // 위와 같은 의미
		java.io.File file2 = new java.io.File(path2);
		
		System.out.println("대상이 존재하는가? " + file2.exists());
		System.out.println("대상이 파일인가? " + file2.isFile());
		System.out.println("대상이 경로인가? " + file2.isDirectory());
		System.out.println("대상의 이름은? " + file2.getName());
		System.out.println("대상의 위치는? " + file2.getParent());
		System.out.println("대상의 경로는? " + file2.getPath());
		System.out.println("대상의 단순 절대경로는? " + file2.getAbsolutePath());
		try {
		System.out.println("대상의 일반 절대경로는? " + file2.getCanonicalPath());
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		System.out.println("대상의 읽기권한은? " + file2.canWrite());
		System.out.println("대상의 쓰기권한은? " + file2.canRead());
		System.out.println("대상의 실행권한은? " + file2.canExecute());
		System.out.println("대상의 크기는? " + file2.length() + "byte");
		System.out.println(new java.util.Date(file2.lastModified()));
		String[] dirs = file2.list();
		for(int i = 0; i < dirs.length; i++) {
			System.out.println(dirs[i]);
		}
		
	}
}
