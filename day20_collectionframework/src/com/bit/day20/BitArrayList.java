package com.bit.day20;

public class BitArrayList {
	// read ȿ����
	// insert, update, delete �� ��ȿ����

	private Object[] arr;
	
	public BitArrayList() {
		arr = new Object[0];
	}
	
	public void add(Object number) {
		Object[] temp = new Object[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
		arr[arr.length - 1] = number;
	}
	
	public Object get(int number) {
		return arr[number];
	}
	
	public int size() {
		return arr.length;
	}
}
