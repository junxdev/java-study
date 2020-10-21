package com.bit.day19;

public class BitArray implements BitStack, BitQueue {
	Object[] arr; // �ڷḦ �Է��� �� �ִ� ���� : �ڷ����� ���� ���� �� �ִ� �ڷᰡ ���ѵǴ� �Ѱ�, �پ��� �ڷ��� �ڷᱸ���� ���� Object ������ Ȱ��
	
	BitArray() {
		arr = new Object[0]; // ��ü ���� ������ �ʱ�ȭ
	}
	
	public void add(Object a) { // �迭�� ũ�⸦ Ȯ���ϰ� �ڷḦ �Է��ϴ� �޼���
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
