package com.bit.day17;
// StudentVO를 동적할당하여 배열의 크기와 상관 없이 사용할 수 있는 클래스
public class StudentArrayUtil {

	// 배열 크기를 1 증가시키는 메서드
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
	
	// 해당 객체가 몇번째 인덱스인지 알려주는 equals 메서드
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
