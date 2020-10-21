class Ex21 { 
 
	public static void main(String[] args) { 
 
		// 성적관리 프로그램 ver 0.0.2

		int kor, eng, math; // 과목별 변수 선언 및 초기화
		kor = 60;
		eng = 60;
		math = 59;

		int sum; // 합계 변수 선언 및 초기화
		double avg; // 평균 변수 선언 및 초기화
		sum = kor + eng + math;
		avg = ((sum * 100) / 3) / 100.0; // 소수점 둘째자리까지 표현
		
		char grade = 'F'; // 학점 변수 선언 및 초기화
		switch ((int)avg / 10) { // 학점 계산 switch문
			case 6:
			grade = 'D';
			break;
			case 7:
			grade = 'C';
			break;
			case 8:
			grade = 'B';
			break;
			case 9:
			grade = 'A';
			break;
			case 10:
			grade = 'A';
			break;
		}

		System.out.println("성적관리 프로그램(ver 0.0.2)"); 
		System.out.println("------------------------------");
		System.out.println("국어 " + kor);  
		System.out.println("영어 " + eng);  
		System.out.println("수학 " + math);  
		System.out.println("------------------------------");
		System.out.println("합계 " + sum);  
		System.out.println("------------------------------");
		System.out.println("평균 " + avg);  
		System.out.println("------------------------------");
		System.out.println("학점 " + grade + "학점");

		// print end  
 
	} // main end 
 
} // class end 
