class Ex23 { 
 
	public static void main(String[] args) { 
 
		// 입력 받기
		
/*		String input1, input2;
		input1 = args[0];
		input2 = args[1];
		
		System.out.println("input1 = " + input1); 
*/
		// 입력 사전 준비
		java.util.Scanner sc
		= new java.util.Scanner(System.in);

		// 입력 받기
		System.out.println("문자열 입력 > ");
		String input3 = sc.nextLine();

		System.out.println("input3 = " + (input3 + 1));

		System.out.println("숫자 입력 > ");
		int input4 = sc.nextInt();

		System.out.println("input4 = " + (input4 + 1));
 
	} // main end 
 
} // class end 
