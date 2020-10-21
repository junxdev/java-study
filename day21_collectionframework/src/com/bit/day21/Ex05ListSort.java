package com.bit.day21;

import java.util.Comparator;

class Lec05 implements Comparator {
	
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
////		return (Integer)o1 - (Integer)o2; // int로 unwrapping
////		return (int)o1 - (int)o2; // 오름차순
////		return (int)o2 - (int)o1; // 내림차순
////		return -1; // 내림차순
		return 0; // 기본
	}
	
}

public class Ex05ListSort {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.util.List list = new java.util.ArrayList();
		
		list.add(1);
		list.add(55);
		list.add(777);
		list.add(33);
		list.add(9999);
		
		list.sort(new Lec05());
		list.sort(new java.util.Comparator() { // Anonymous Class를 통한 1회 활용

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return -1;
			}
			
		});
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		java.util.List list2 = list.subList(1, 3);
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}

	}

}
