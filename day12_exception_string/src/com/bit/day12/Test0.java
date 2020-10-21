package com.bit.day12;

public class Test0 {
	
	static String foo(String x) {
		System.out.println(x.charAt(2));
		System.out.println(x.hashCode());
		x = new String("bbb");
		System.out.println(x.charAt(2));
		System.out.println(x.hashCode());
		return x;
	}
	
	static int bar(int a) {
		a = 3;
		return a;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = new String("aaa");
		
		System.out.println(a.charAt(2));
		
		String b = Test0.foo(a);
		
		System.out.println(a.charAt(2));
		System.out.println(b.charAt(2));
		
		int what = 1111;
		bar(what);
		
		System.out.println(what);
		

	}

}
