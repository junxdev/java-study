package com.bit.day20;

import java.util.ArrayList;

public class Ex04CopyArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list1 = new ArrayList();
		list1.add(1);
		list1.add(22);
		list1.add(333);
		list1.add(4444);
		
		ArrayList list2 = new ArrayList(list1); // �� �迭�� ���� �����ϴ� ���� ����
		list2.add(55555); // ���� list1�� 55555�� �Էµ��� ����
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		System.out.println("---------------------");
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
	}

}
