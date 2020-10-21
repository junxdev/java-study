package com.bit.day14;

public class Ex16HowToCopyArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 3, 5, 7};
		
		System.out.println(arr1); //참조변수 값
		System.out.println(java.util.Arrays.toString(arr1));
		
		// 배열 복사 방법
		int[] arr2 = new int[2];
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = arr1[i + 1];
		}
		System.out.println(java.util.Arrays.toString(arr2));
		
		int[] arr3 = new int[2];
		System.arraycopy(arr1, 1, arr3, 0, arr3.length);
		System.out.println(java.util.Arrays.toString(arr3));
		
		int[] arr4 = java.util.Arrays.copyOfRange(arr1, 1, 3);
		System.out.println(java.util.Arrays.toString(arr4));
		
		int[] rans = {41, 2, 23, 10, 11, 28};
		java.util.Arrays.sort(rans);
		System.out.println(java.util.Arrays.toString(rans));
		System.out.println(java.util.Arrays.binarySearch(rans, 10)); // sort 필수
		
	}

}
