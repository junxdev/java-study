package com.bit.day20;

// insert, update, delete 등 작업 시 각 객체의 주소값을 활용 : ArrayList와 달리 처음부터 끝까지의 모든 값을 복사할 필요가 없음
// read 시 객체의 주소값을 찾는 작업의 양이 단점
// 각 방식의 장단점을 고려하여 동적자료구조 선택

public class BitLinkedList {
	
	private class Node {
		Node next;
		Object value;
	}
	
	private Node start;
	private int count;
	
	public void add(Object value) {
		Node node = new Node();
		node.value = value;
//		
//		if(count == 0) {
//			start = node;
//		} else {
//			Node x = start;
//			for(int i = 0; i < count; i++) {
//				x = x.next;
//			}
//			x = node;
//		}
		count++;
		
		if(count == 1) {
			start = node;
		} else {
			Node temp = start;
			while(true) {
				if(temp.next == null) {break;}
				temp = temp.next;
			}
			temp.next = node;
		}
//
//		Node node = new Node();
//		node.value = value;
//		start.next = node;
//		
//		Node node = new Node();
//		node.value = value;
//		start.next.next = node;
//		
//		Node node = new Node();
//		node.value = value;
//		start.next.next.next = node;
	}
	
	public int size() {
		return count;
	}
	
	public Object get(int index) {
		if(!(index < count)) {
			System.out.println("오류");
			return -1;
		}
		Node temp = start;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.value;
	}
}
