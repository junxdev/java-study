package com.bit.day19;

class ObjectList {
	Object[] arr; // �ڷḦ �Է��� �� �ִ� ���� : �ڷ����� ���� ���� �� �ִ� �ڷᰡ ���ѵǴ� �Ѱ�, �پ��� �ڷ��� �ڷᱸ���� ���� Object ������ Ȱ��
	
	ObjectList() {
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
}

public class Ex04ObjectList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// �ڷᱸ�� ��ü ����
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
