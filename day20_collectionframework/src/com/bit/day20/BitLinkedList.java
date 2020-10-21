package com.bit.day20;

// insert, update, delete �� �۾� �� �� ��ü�� �ּҰ��� Ȱ�� : ArrayList�� �޸� ó������ �������� ��� ���� ������ �ʿ䰡 ����
// read �� ��ü�� �ּҰ��� ã�� �۾��� ���� ����
// �� ����� ������� ����Ͽ� �����ڷᱸ�� ����

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
			System.out.println("����");
			return -1;
		}
		Node temp = start;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.value;
	}
}
