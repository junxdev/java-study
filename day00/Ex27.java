class Ex27 { 
 
	public static void main(String[] args) { 
 
		java.util.Scanner sc = new java.util.Scanner(System.in);

		System.out.print("숫자를 입력하세요 : ");
		int input = sc.nextInt();

		// Q1. 1 ~ 10까지의 합을 구하시오.

		int sum1 = 0;

		for (int i = 1; i < input; i++) {
			sum1 += i;
		}

		System.out.println("1 ~ 10까지의 합 = " + sum1 + '\n'); 


		// Q2. 1 ~ 10까지의 짝수들의 합을 구하시오.
		
		int sum2 = 0;

		for (int i = 2; i <= input; i += 2) {
				sum2 += i;
		}

		System.out.println("1 ~ 10까지의 짝수들의 합 = " + sum2 + '\n'); 


		// Q3. 1 + 3 + 5 + 7 + 9 = 25를 출력하시오.
		
		String str = "";
		int sum3 = 0;
		boolean first = false;

		for (int i = 1; i <= input; i += 2) {

			sum3 += i;
	
			if (first) {
				str += " + " + i;
			} else {
				str += i;
			}

			first = true;
		}

		System.out.println(str + " = " + sum3 + '\n'); 

		// Q4. 1 ~ 50까지 3의 배수를 출력하시오.

		System.out.print("1 ~ 50까지 3의 배수 = ");
		boolean first2 = false;
		for (int i = 3; i < 50; i += 3) {
			if (first2) {
				System.out.print(", ");
			}
			System.out.print(i);
			first2 = true;
		}
		System.out.println('\n');

		// Q5. 2의 1승, 2의 2승, 2의 3승, 2의 4승, 2의 5승을 출력하시오.

		int sum5 = 1;

		for (int i = 1; i < 6; i++) {
			sum5 *= 2;
			System.out.println("2의 " + i + "승은 " + sum5 + "입니다");
		}
 
	} // main end 
 
} // class end 
