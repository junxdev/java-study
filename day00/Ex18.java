class Ex18 { 
 
	public static void main(String[] args) { 

 		// 성적관리 프로그램 ver 0.0.1

		int kor, eng, math; // 과목별 변수 선언 및 초기화
		kor = 95;
		eng = 82;
		math = 71;
		
		double sum, mean, avg; // 합계 평균 변수 선언 및 초기화
		sum = kor + eng + math;
		mean = sum / 3;

		
		double x, y, z; // 소수점 둘째자리까지 표현
		x = mean * 100;
		y = (int)x;
		z = y * 0.01;

		mean = z;

		avg = sum * 100 / 3 / 100.0; // 간단하게 하는 방법


		
		
		double a, b, c, d; // 소수점 둘째자리 올림 버림 수식
		a = sum / 3 * 1000; // 81666.666
		b = (int)a; // 81666
		c = (double)(b - (y * 10));

		if (c < 5) { 
			d = b - (b - y * 10);
		} else {
			d = b - (b - y * 10) + 10;
		}
		System.out.println((double)d * 0.001);

		

		char grade; // 학점 선언 및 미만 조건 설정
		if (mean < 60) {
			grade = 'F';
		} else if (mean < 70) {
			grade = 'D';
		} else if (mean < 80) {
			grade = 'C';
		} else if (mean < 90) {
			grade = 'B';
		} else {
			grade = 'A';
		} // if end
		
		System.out.println("성적관리 프로그램(ver 0.0.1)"); 
		System.out.println("------------------------------");
		System.out.println("국어 " + kor);  
		System.out.println("영어 " + eng);  
		System.out.println("수학 " + math);  
		System.out.println("------------------------------");
		System.out.println("합계 " + sum);  
		System.out.println("------------------------------");
		System.out.println("평균 " + mean);  
		System.out.println("------------------------------");
		System.out.println("학점 " + grade + "학점");

		// print end  



/*		char grade; // 학점 선언 및 이상 조건 설정
		if (mean >= 90) {
			grade = 'A';
		} else if (mean >= 80) {
			grade = 'B';
		} else if (mean >= 70) {
			grade = 'C';
		} else if (mean >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
*/
 
	} // main end 
 
} // class end 
