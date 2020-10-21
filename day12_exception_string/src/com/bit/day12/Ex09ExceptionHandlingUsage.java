package com.bit.day12;

public class Ex09ExceptionHandlingUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lotto = new int[6];
		
		int count = 0;
		try {
			while(true) {
				lotto[count++] = (int)(Math.random() * 45) + 1;
			}
		} catch (ArrayIndexOutOfBoundsException e) {					// 해외: 시나리오 상 오류면 오류를 그대로 두고 예외 처리
		}																// 국내: 예외 처리를 최대한 회피하는 방향으로 코드 작성
		
		for(int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}
	}

}
