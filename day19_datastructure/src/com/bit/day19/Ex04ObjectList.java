package com.bit.day19;

class ObjectList {
	Object[] arr; // 자료를 입력할 수 있는 변수 : 자료형에 따라 넣을 수 있는 자료가 제한되는 한계, 다양한 자료형 자료구조를 위해 Object 다형성 활용
	
	ObjectList() {
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
}

public class Ex04ObjectList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// 자료구조 객체 생성
				ObjectList list = new ObjectList();
				list.add(1000);
				list.add('A');
				list.add("KKK");
				list.add(5.5);
				list.add(true);
				
				for(int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
	}

}
