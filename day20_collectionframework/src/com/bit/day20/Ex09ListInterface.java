package com.bit.day20;


public class Ex09ListInterface implements Cloneable {
	
	int su = 1234;
	
	public static void main(String[] args) {
//		java.util.List list = new java.util.LinkedList();
//		list = new java.util.ArrayList();
		
		java.util.List list = java.util.Arrays.asList(1, 3, 5, 7, 9);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		Ex09ListInterface me = new Ex09ListInterface();
		try {
			Object obj = me.clone();
			System.out.println(obj);
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}
}
