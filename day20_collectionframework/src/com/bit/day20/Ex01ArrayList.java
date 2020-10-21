package com.bit.day20;

public class Ex01ArrayList {

	public static void main(String[] args) {
		BitArrayList list = new BitArrayList();
		list.add('a');
		list.add("22");
		list.add(333);
		list.add("string");
		list.add(true);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		java.util.ArrayList list2 = new java.util.ArrayList<>();
		
		list2.add('a');
		list2.add("22");
		list2.add(333);
		list2.add("string");
		list2.add(true);
		
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		System.out.println(list2.get(2));
		System.out.println(list2.get(3));
		System.out.println(list2.get(4));
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
	}
}
