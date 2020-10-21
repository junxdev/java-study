package com.bit.day21;

public class Ex07Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Map map1 = new java.util.HashMap<>();
		
		map1.put("key1", "val1");
		map1.put("key2", "val2");
		map1.put("key3", "val3");
		map1.put("key4", "val4");
		map1.put("key1", "val5");
		map1.put(1234, "val2");
		map1.put(true, "val3");
		map1.put(null, "val4");
		
		System.out.println(map1.get(1234));
	}

}
