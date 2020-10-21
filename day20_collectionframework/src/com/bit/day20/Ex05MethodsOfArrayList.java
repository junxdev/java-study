package com.bit.day20;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex05MethodsOfArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list1 = new ArrayList();
		list1.add(1);
		list1.add(22);
		list1.add(333);
		list1.add(4444);
		
		ArrayList list2 = new ArrayList();
		list2.addAll(list1);
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}	System.out.println("----------------------");

		
		list2.clear();
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}	System.out.println("----------------------");
		
		Object list3 = list1.clone();
		System.out.println(list3.toString());
		System.out.println("----------------------");
		
		ArrayList list4 = (ArrayList)list1.clone(); // clone : 깊은 복사로
		list1.add(55555); // list4에 55555는 추가되지 않는다.
		for(int i = 0; i < list4.size(); i++) {
			System.out.println(list4.get(i));
		}	System.out.println("----------------------");
		
		System.out.println(list1.contains(4444));
		System.out.println(list1.indexOf(22));
		list1.add(22);
		System.out.println(list1.lastIndexOf(22));
		
		System.out.println(list2.isEmpty());
		
		list1.remove(1);
		System.out.println(list1.toString());
		
		list1.add("add");
		System.out.println(list1.toString());
		list1.remove("add");
		list1.add(list3);
		System.out.println(list1.toString());
		
		list1.set(5, "noObject");
		System.out.println(list1.toString());
		
		Object[] arr = list1.toArray();
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int[] arr2 = new int[arr.length - 1];
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = (int)arr[i];
		}
		System.out.println(Arrays.toString(arr2));
	}

}
