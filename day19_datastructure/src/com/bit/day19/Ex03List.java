package com.bit.day19;

class List {
	int[] arr; // �ڷḦ �Է��� �� �ִ� ���� : �ڷ����� ���� ���� �� �ִ� �ڷᰡ ���ѵǴ� �Ѱ�, �پ��� �ڷ��� �ڷᱸ���� ���� Object ������ Ȱ��
	
	List() {
		arr = new int[0]; // ��ü ���� ������ �ʱ�ȭ
	}
	
	public void add(int a) { // �迭�� ũ�⸦ Ȯ���ϰ� �ڷḦ �Է��ϴ� �޼���
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
		// �ڷᱸ�� ��ü ����
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
