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
		
		ArrayList list2 = new ArrayList(list1); // 각 배열의 값을 복사하는 깊은 복사
		list2.add(55555); // 따라서 list1에 55555는 입력되지 않음
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		System.out.println("---------------------");
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
	}

}
