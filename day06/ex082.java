class Ex082 { 
 
	public static int inputPrint(String msg) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print(msg);
		int su = sc.nextInt();

		return su;
	}

	public static int func1(int su1, int su2, int su3) {
		
		int result = 0;

		if (su3 == 1) {
			result = su1 + su2;
		} else if (su3 == 2) {
			result = su1 - su2;
		} else if (su3 == 3) {
			result = su1 * su2;
		} else {
			result = su1 / su2;
		}

		return result;
	}
	public static char func2(int su3) {
		
		char result = 'a';

		if (su3 == 1) {
			result = '+';
		} else if (su3 == 2) {
			result = '-';
		} else if (su3 == 3) {
			result = '*';
		} else {
			result = '/';
		}

		return result;
	}

	public static void resultPrint(int su1, int su2, int su3) {
		if (!(su3 == 4 && su1 % su2 != 0)) {
			System.out.println("결과:\t" + su1 + func2(su3) + su2 + "=" + func1(su1, su2, su3));
		} else {
			System.out.println("결과:\t" + su1 + func2(su3) + su2 + "=" + ((su1 * 1.0) / su2));
		}
	}

	public static void main(String[] args) { 
 
		System.out.println("계산기 ver 0.0.1");
		System.out.println("----------------");

		do {
			// 숫자 입력
			int su1 = inputPrint("1번째 >> ");
			int su2 = inputPrint("2번째 >> ");

			// 연산자 선택
			int su3 = inputPrint("1.+ 2.- 3.* 4./ >> ");		
	
			// 결과 출력
			resultPrint(su1, su2, su3);

		} while (inputPrint("1.계속 0.종료 >> ")!=0); // 반복 또는 종료 선택
 
	} // main end 
 
} // class end 
