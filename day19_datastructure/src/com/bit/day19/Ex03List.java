package com.bit.day19;

class List {
	int[] arr; // 자료를 입력할 수 있는 변수 : 자료형에 따라 넣을 수 있는 자료가 제한되는 한계, 다양한 자료형 자료구조를 위해 Object 다형성 활용
	
	List() {
		arr = new int[0]; // 객체 생성 시점에 초기화
	}
	
	public void add(int a) { // 배열의 크기를 확장하고 자료를 입력하는 메서드
		int[] temp = new int[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		temp[temp.length - 1] = a;
		arr = temp;;
	}
	
	public int size() {
		return arr.length;
	}
	
	public int get(int idx) {
		return arr[idx];
	}
}

public class Ex03List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자료구조 객체 생성
		List list = new List();
		list.add(1000);
		list.add(2000);
		list.add(4000);
		list.add(7000);
		list.add(8000);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
