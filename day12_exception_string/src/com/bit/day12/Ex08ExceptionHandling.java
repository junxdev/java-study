package com.bit.day12;

public class Ex08ExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};

		try {
			for(int i = 0; i < 10; i++) {
				System.out.println(arr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {		// i < 10이지만 i가 5일 때 예외 처리
			System.out.println("에러 회피");				// try - catch 범위에 정답은 없으나 상황에 따라 결과가 다른 점을 고려
		}
		
	}

}
