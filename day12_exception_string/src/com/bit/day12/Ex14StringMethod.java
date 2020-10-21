package com.bit.day12;

public class Ex14StringMethod {
	
	public static void main(String[] args) {
		String msg = "JavaWebFramework";
		
		int su = msg.indexOf("web");
		System.out.println(su);
		
		String st1 = msg.replace('z', 'Z');
		System.out.println(st1);
		
		char ch = msg.charAt(9);
		System.out.println(ch);
		
		boolean boo1 = msg.contains("Web");
		System.out.println(boo1);
		
		boolean boo2 = msg.startsWith("Web");
		System.out.println(boo2);
		
		boo2 = msg.startsWith("java");
		System.out.println(boo2);
		
		boo2 = msg.endsWith("work");
		System.out.println(boo2);
		
		String st2 = msg.toLowerCase();
		System.out.println(st2);
		System.out.println(boo2);
		st2 = msg.toUpperCase();
		System.out.println(st2);
		
		String msg2 = " k kk kkk ";
		int leng = msg2.length();
		boolean boo3 = msg2.isEmpty();
		System.out.println(leng);
		System.out.println(boo3);
		
		String st4 = msg2.trim(); // 전후의 공백을 삭제
		System.out.println(st4);
	}

}
