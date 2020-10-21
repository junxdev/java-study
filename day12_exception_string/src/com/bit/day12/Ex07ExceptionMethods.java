package com.bit.day12;

public class Ex07ExceptionMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main 시작");
		try {
			func01();								// 여기서 던져진 err을
		} catch (NumberFormatException e) {			// 여기서 잡아서 예외 처리
			System.out.println("회피");
			System.out.println(e);
			System.out.println(e.toString());
			System.out.println(e.getMessage());						// IO 작업으로 인한 자원 소모 발생
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();									// 에러 출력 시 주로 사용되는 메서드
			e.printStackTrace();									// 문자열 출력을 시스템에 명령하지 않는다
			e.printStackTrace();									// 자원 소모가 큰 IO 작업을 생략하며
			e.printStackTrace();									// 작업을 방해하지 않기 때문에 효율적
		}
		System.out.println("main 종료");
		
	}
	
	public static void func01() throws NumberFormatException {		// NumberFormatException을 던지도록 허용한 메서드
		NumberFormatException err = new NumberFormatException();	// 인위적으로 생성한 err
		throw err;													// err을 던지고
	}

}
