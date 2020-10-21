class Ex03 { 
 	
	// Method
	// Class Method, Static Method (Function..)

	public static void func01() { 
 
		System.out.println("01 기능 실행");
		System.out.println("01 기능 종료\n"); 
 
	} // func01 

	// public static void 메소드 (매개변수;parameter variables;인자,... 선언) {}
	// 소문자로 시작
	// 띄어쓰기 x
	// 호출 시 메소드명 ();
	// 메소드 호출 시 파라미터 규칙(개수, 자료형)과 다르면 오류 발생

	public static void func02() { 

 		int a = 1234;

		System.out.println("02 기능 실행"); 
		System.out.println("a : " + a); 
		System.out.println("02 기능 종료\n"); 
		
 
	} 

	public static void func03(int a) { 
		System.out.println("03 기능 전달 받은 데이터 1 : " + a); 
		a = a + 999;
		func02();
		System.out.println("func02 데이터 2 : " + a); 
 
	} 

	public static void func04(int a, int b) {
		int c = a + b;
		System.out.println(c);
	}

	public static void main(String[] args) {

		int a = 1111;

		System.out.println("프로그램 이름 : " + args[0] + args[1]);
		System.out.println("프로그램 시작 : " + a);
		func01();
		func02();
		func03(a);
		func03(123);
		func04(a, 1);
		System.out.println("프로그램 종료 : " + a);

	} // main 
 
} // class end 
