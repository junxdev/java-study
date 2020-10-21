package com.bit.day12;

public class Ex06WhereExceptionHappens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main 시작");
		for(int i = 0; i < 6; i++) {
			try {
				func01(i);
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				System.out.println("에러 회피");				
			}
		}
		System.out.println("main 종료");
	}
	
	public static void func01(int a) throws ArrayIndexOutOfBoundsException {
		System.out.println("에러 확인 지점 1");
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println("에러 확인 지점 2");
		System.out.println(arr[a]);
		System.out.println("에러 확인 지점 3");
	}

}
