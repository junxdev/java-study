package com.bit.day20;

// �̷� �� ���� ������� ������
// �����δ� ArrayList�� �� ȿ������ ���� ������

public class Ex03SpeedComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ArrayList list = new java.util.ArrayList();
		java.util.LinkedList list2 = new java.util.LinkedList();
		
		long before = System.currentTimeMillis();
		for(int i = 0; i < 9999999; i++) {
			list.add(i);
		}
		long after = System.currentTimeMillis();
		
		System.out.println("ArrayList add : " + (after - before));
		
		before = System.currentTimeMillis();
		for(int i = 0; i < 9999999; i++) {
			list2.add(i);
		}
		after = System.currentTimeMillis();
		
		System.out.println("LinkedList add : " + (after - before));
		
		before = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			list.get(i);
		}
		after = System.currentTimeMillis();
		
		System.out.println("ArrayList get : " + (after - before));
		
		before = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			list2.get(i);
		}
		after = System.currentTimeMillis();
		
		System.out.println("LinkedList get : " + (after - before));
	}

}
