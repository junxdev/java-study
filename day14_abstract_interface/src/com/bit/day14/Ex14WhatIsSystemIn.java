package com.bit.day14;

public class Ex14WhatIsSystemIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.io.InputStream inn = System.in;
		
		java.util.Scanner sc = new java.util.Scanner(inn);
		System.out.print("system in > ");
		System.out.println(sc.nextLine());
		System.out.print("system in > ");
		System.out.println(sc.next());
		System.out.print("system in > ");
		System.out.println(sc.nextInt());
		
		String msg = "first line\nsecond line \nthird line";
		sc = new java.util.Scanner(msg);
		System.out.println(sc.nextLine()); //first line
		System.out.println(sc.nextLine()); //second line
		System.out.println(sc.nextLine()); //third line
		sc = new java.util.Scanner(msg);
		System.out.println(sc.next()); //first
		System.out.println(sc.next()); //line
		System.out.println(sc.next()); //second
	}

}
