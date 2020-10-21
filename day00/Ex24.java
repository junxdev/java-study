class Ex24 { 
 
	public static void main(String[] args) { 
 
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int kor = 0;
		int eng = 0;
		int math = 0;

		System.out.print("국어 > ");
		kor = sc.nextInt();
		System.out.print("영어 > ");
		eng = sc.nextInt();
		System.out.print("수학 > ");
		math = sc.nextInt();

		int sum; 					// 합계 변수 선언 및 초기화
		sum = kor + eng + math;

		double avg; 					// 평균 변수 선언 및 초기화
		avg = ((sum * 100) / 3) / 100.0; 		// 소수점 둘째자리까지 표현
		
		char grade = 'F'; 				// 학점 변수 선언 및 초기화
		switch (sum / 30) { 				// 학점 계산 switch문
			case 10:
			case 9:
			grade -= 1;
			case 8:
			grade -= 1;
			case 7:
			grade -= 1;
			case 6:		
			grade -= 2;
		}

		String msg = "";
		msg += "\n성적관리 프로그램(ver 0.0.2)";	// msg = msg + "문자열"; 
		msg += "\n------------------------------";		
		msg += "\n국어 " + kor;	
		msg += "\n영어 " + eng;
		msg += "\n수학 " + math;
		msg += "\n------------------------------";
		msg += "\n합계 " + sum;
		msg += "\n------------------------------";
		msg += "\n평균 " + avg;
		msg += "\n------------------------------";
		msg += "\n학점 " + grade + "학점";
		 
 		System.out.println(msg);

	} // main end 
 
} // class end 
