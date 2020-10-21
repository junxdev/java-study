class Ex19 { 
 
	public static void main(String[] args) { 
 
		// 정수

		byte su1;
		short su2 = 127; // byte, short 자료형은 byte, short 상수로 자동 저장
		int su3 = 127 ; // 2147483647까지 integer 자료형
		// long su4 = (long)2147483648; // int 상수 > long 강제 형변환
		long su5 = 2147483648L; // long 상수로 저장 명령. 단, 이후 연산 시 int 자동 형변환
		long su6 = 2147483647; // int 상수
		
		byte su7 = 1;
		su1 = (byte)(su7 + 2); //int 상수 > byte 강제 변환

		System.out.println(su1);  

		// 실수
		float su11 = (float)3.14; // double 상수 > float 강제 형변환
		float su111 = 3.14F; // float 상수로 저장 명령. 단, 이후 연산 시 double 자동 형변환
		double su12 = 3.14;

		//문자
		char ch1;
		ch1 = 'A';
		System.out.println("ch1 = " + ch1); 
		System.out.println("ch1 = " + (int)ch1); 
		System.out.println("65 = " + (char)65); 
		System.out.println("66 = " + (char)66); 
		System.out.println("67 = " + (char)67); 

		//문자열
		String msg;
		msg = "문자열";
		System.out.println(msg); 

		//제어 조건문
		int su21;
		int su22 = 2;

		if (true) {
			su21 = 1234;
		} // 상수 영역에서 먼저 처리되어 su21 변수가 초기화된다.

		if (5 > 3) {
			su21 = 1234;
		} // 상수 영역에서 먼저 처리되어 su21 변수가 초기화된다.

		if (su22 % 2 == 0) {
			su21 = 1234;
		} // su21 변수가 초기화되지 않아 컴파일 오류가 발생한다.

		
		if (su22 % 2 == 0) {
			su21 = 1234;
		} else { 
			su21 = 4321;
		}// else문에서 su21 변수가 초기화된다.

		System.out.println("su21 = " + su21);

		int su = 2;

		if (su == 0) {
			System.out.println("0입니다");
		} else if (su < 2) {
			System.out.println("1입니다");
		} else if (su < 3) {
			System.out.println("2입니다");
		} // 조건에 맞으면 if문 종료		
 
	} // main end 
 
} // class end 
