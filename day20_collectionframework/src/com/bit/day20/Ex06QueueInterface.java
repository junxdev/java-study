package com.bit.day20;

import java.util.LinkedList;

public class Ex06QueueInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// LinkedList�� Queue Interface�� ���
		// ����� Ȱ���� ���
		java.util.Queue list = new LinkedList();
		
		list.offer("1��"); // list.add
		list.offer("2��");
		list.offer("3��");
		list.offer("4��");
		
//		for(int i = 0; i < 4; i++) {
//			String msg = (String)list.peek();
//			System.out.println(msg);
//			list.poll();
//		}
		
//		do {
//			String msg = (String)list.peek();
//			System.out.println(msg);
//		} while(list.poll() != null);
		
		while(list.peek() != null) { // list.element
			String msg = (String)list.poll(); // list.remove
			System.out.println(msg);
		}
		
	}

}
