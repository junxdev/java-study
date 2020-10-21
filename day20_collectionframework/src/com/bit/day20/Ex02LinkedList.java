package com.bit.day20;

public class Ex02LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitLinkedList list = new BitLinkedList();
		list.add('a');
		list.add(22);
		list.add("세번째");
		list.add(4444);
		list.add(true);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		java.util.LinkedList list2 = new java.util.LinkedList();
		
		list2.add('a');
		list2.add(22);
		list2.add("세번째");
		list2.add(4444);
		list2.add(true);
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
	}

}
