package com.bit.day19;

public class BitArray implements BitStack, BitQueue {
	Object[] arr; // 자료를 입력할 수 있는 변수 : 자료형에 따라 넣을 수 있는 자료가 제한되는 한계, 다양한 자료형 자료구조를 위해 Object 다형성 활용
	
	BitArray() {
		arr = new Object[0]; // 객체 생성 시점에 초기화
	}
	
	public void add(Object a) { // 배열의 크기를 확장하고 자료를 입력하는 메서드
		Object[] temp = new Object[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		temp[temp.length - 1] = a;
		arr = temp;;
	}
	
	public int size() {
		return arr.length;
	}
	
	public Object get(int idx) {
		return arr[idx];
	}
	
	public void remove(int idx) {
		if(arr.length > 0 ) {
			Object[] temp = new Object[arr.length - 1];
			for(int i = 0; i < idx; i++) {
				temp[i] = arr[i];
			}
			for(int i = idx; i < temp.length; i++) {
				temp[i] = arr[i + 1];
			}
			arr = temp;
		}
	}
	
	public Object pull() {
		Object obj = arr[0];
		remove(0);
		return obj;
	}
	
	public void push(Object obj) {
		add(obj);
	}
	
	public Object pop() {
		Object obj = arr[arr.length - 1];
		remove(arr.length - 1);
		return obj;
	}
}
