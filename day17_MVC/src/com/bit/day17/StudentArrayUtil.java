package com.bit.day17;
// StudentVO�� �����Ҵ��Ͽ� �迭�� ũ��� ��� ���� ����� �� �ִ� Ŭ����
public class StudentArrayUtil {

	// �迭 ũ�⸦ 1 ������Ű�� �޼���
	private static StudentVO[] expand(StudentVO[] arr) {
		StudentVO[] temp = new StudentVO[arr.length];
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = new StudentVO[temp.length + 1];
		for(int i = 0; i < temp.length; i++) {
			arr[i] = temp[i];
		}
		return arr;
	}
	
	public static StudentVO[] add(StudentVO[] arr, StudentVO s) {
		arr = expand(arr);
		arr[arr.length - 1] = s;
		return arr;
	}
	
	// �ش� ��ü�� ���° �ε������� �˷��ִ� equals �޼���
	public static int indexOf(StudentVO[] arr, StudentVO s) {
		for(int i = 0; i < arr.length; i++) {
			if(s.equals(arr[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public static StudentVO[] remove(StudentVO[] arr, StudentVO s) {
		if(indexOf(arr, s) != -1) {
			int index = indexOf(arr, s); 
			StudentVO[] temp = new StudentVO[arr.length];
			for(int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			arr = new StudentVO[arr.length - 1];
			for(int i = 0; i < arr.length; i++) {
				if(i < index) {
					arr[i] = temp[i];
				} else if (i > index) {
					arr[i - 1] = temp[i];
				}
			}
		}
		return arr;
	}
}
