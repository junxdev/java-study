package com.bit.flipit0617;

import java.util.ArrayList;
import java.util.List;

class Arr {
	static List<String> arr = new ArrayList<String>();
	
	public Arr(String str) {
		// TODO Auto-generated constructor stub
		arr.add(str);
//		this.arr = arr;
	}
	
}
public class Test {

	static int a = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> arr1 = new ArrayList<String>();
		List<String> arr2 = new ArrayList<String>();
		
		Arr b = new Arr("str1");
		Arr c = new Arr("str2");
//		System.out.println(c.arr.size());
		
		
		ArrayList<String> arr3 = new ArrayList<>();
		arr3.add("1");
		arr3.add("2");
		arr3.add("3");
		arr3.remove(0);
		System.out.println(arr3.get(0));
		
	}

}
