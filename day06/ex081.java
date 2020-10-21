class Ex081 { 
 
	public static void main(String[] args) { 
 
		System.out.println("계산기 ver 0.0.1");
		System.out.println("----------------");

		do {

			// 숫자 입력
			int number1 = selectNumber(1); 
			int number2 = selectNumber(2);

			// 연산 선택
			int operator = selectOperator();

			// 결과 출력
			resultMessage(number1, number2, operator);
 
		} while (playAgain() != 0); // 계산 재실행 또는 종료 선택

	} // main end 

	public static int selectNumber(int i) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print(i + "번째 >> ");
		int r = sc.nextInt();

		return r;
	} // selectNumber end

	public static int selectOperator() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("1.+ 2.- 3.* 4./ >> ");
		int r = sc.nextInt();

		return r;
	} // selectOperator end

	public static void resultMessage(int number1, int number2, int operator) {
		int result = 0;
		if (operator == 1) {
			operator = '+';
			result = number1 + number2;
		} else if (operator == 2) {
			operator = '-';
			result = number1 - number2;
		} else if (operator == 3) {
			operator = '*';
			result = number1 * number2;
		} else {
			operator = '/';
			result = number1 / number2;
			
		}
		String msg = "결과:\t" + number1 + (char)operator + number2 + "=" + result;

		System.out.println(msg);
	} // resultMessage end

	public static int playAgain() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("1.계속 0.종료 >> ");
		int r = sc.nextInt();
		System.out.println();

		return r;
	} // playAgain end

} // class end 
