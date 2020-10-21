package com.bit.day12;

public class Ex02ExceptionHandling {

	public Ex02ExceptionHandling() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 실행 중 발생할 수 있는 에러를 예외 처리
		// 2. 회피할 수 없는 에러를 예외 처리 예: JVM 상 에러
		String msg = "1234";
		Integer su = new Integer(msg);
		msg = "1234d";
//		su = new Integer(msg); 에러 발생
//		for(int i = 0; i < msg.length(); i++) {
//			if(Character.isDigit(msg.charAt(i))) {
//			} else {
//				System.out.println("숫자 외 문자 입력됨");
//				return; // main 종료
//			}
//		}
		try { // 우선 try block 실행
			System.out.println("여기까지는 에러가 없었음 1");
			su = new Integer(msg);
			System.out.println("여기까지는 에러가 없었음 2");
			System.out.println("su = " + su);
		} catch (NumberFormatException e) { // 오류 발생 시 오류에 해당하는 클래스 객체 자동 생성 및 catch block 실행
			System.out.println("오류 확인");
			System.out.println(e);
		}
		
		
		System.out.println("프로그램 실행 여부 확인");
	}

}
