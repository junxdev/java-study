class Ex08 { 
 
	public static void main(String[] args) { 
 
		System.out.println("계산기 ver 0.0.1");
		System.out.println("----------------");

		int play = 1;

		while (play != 0) {
			// 숫자 입력
		
			java.util.Scanner sc = new java.util.Scanner(System.in);
		
			System.out.print("\n1번째 >> ");
			int first = sc.nextInt();
			System.out.print("\n2번째 >> ");
			int second = sc.nextInt();

			// 연산 선택
			
			System.out.print("\n1.+ 2.- 3.* 4./ >> ");
			int user = sc.nextInt();		
	
			// 결과 출력

			String msg = "결과:\t" + first;
			int result = 0;
			if (user == 1) {
				msg += "+";
				result = first + second;
			} else if (user == 2) {
				msg += "-";
				result = first - second;
			} else if (user == 3) {
				msg += "*";
				result = first * second;
			} else {
				msg += "/";
				result = first / second;
			}
			msg += second + "=" + result;

			System.out.println("\n" + msg);
		
			// 반복 또는 종료 선택

			System.out.print("\n1.계속 0.종료 >> ");
			play = sc.nextInt();

		} // while end
 
	} // main end 

//	public static void input() {
 
} // class end 
