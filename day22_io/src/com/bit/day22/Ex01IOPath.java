package com.bit.day22;

public class Ex01IOPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path1 = "C:\\javap\\day22\\test01.txt";
		java.io.File file1 = new java.io.File(path1);
		
		System.out.println("����� �����ϴ°�? " + file1.exists());
		System.out.println("����� �����ΰ�? " + file1.isFile());
		System.out.println("����� ����ΰ�? " + file1.isDirectory());
		
		String path2 = "C:\\javap\\day22"; // ".\\" ����
//		path2 = "..\\day22\\test01"; // ���� ���� �ǹ�
		java.io.File file2 = new java.io.File(path2);
		
		System.out.println("����� �����ϴ°�? " + file2.exists());
		System.out.println("����� �����ΰ�? " + file2.isFile());
		System.out.println("����� ����ΰ�? " + file2.isDirectory());
		System.out.println("����� �̸���? " + file2.getName());
		System.out.println("����� ��ġ��? " + file2.getParent());
		System.out.println("����� ��δ�? " + file2.getPath());
		System.out.println("����� �ܼ� �����δ�? " + file2.getAbsolutePath());
		try {
		System.out.println("����� �Ϲ� �����δ�? " + file2.getCanonicalPath());
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		System.out.println("����� �б������? " + file2.canWrite());
		System.out.println("����� ���������? " + file2.canRead());
		System.out.println("����� ���������? " + file2.canExecute());
		System.out.println("����� ũ���? " + file2.length() + "byte");
		System.out.println(new java.util.Date(file2.lastModified()));
		String[] dirs = file2.list();
		for(int i = 0; i < dirs.length; i++) {
			System.out.println(dirs[i]);
		}
		
	}
}
