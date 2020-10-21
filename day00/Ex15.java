class Ex15 { 
 
	public static void main(String[] args) { 
		
		int input;
		input = 0;

		System.out.println("시작"); 
 

/*		if (input > 0 && input % 2 == 0) {
			System.out.println("짝수이고 양수입니다."); 
		} // if end


		if (input > 0 && input % 2 != 0) {
			System.out.println("홀수이고 양수입니다."); 
		} // if end
		



		if (input < 0 && input % 2 == 0) {
			System.out.println("짝수이고 음수입니다."); 
		} // if end

		if (input < 0 && input % 2 != 0) {
			System.out.println("홀수이고 음수입니다."); 
		} // if end




		if (input == 0) {
			System.out.println("0입니다."); 
		} // if end 
*/

		if (input != 0) {

			if (input > 0) {

				if (input % 2 == 0) {
					System.out.println("짝수이고 양수입니다."); 
				}

				if (input % 2 != 0) {
					System.out.println("홀수이고 양수입니다."); 
				}

			}
		

			if (input < 0) {

				if (input % 2 == 0) {
					System.out.println("짝수이고 음수입니다."); 
				}

				if (input % 2 != 0) {
					System.out.println("홀수이고 음수입니다."); 
				}

			}
		
		} // if end

		if (input == 0) {
			System.out.println("0입니다."); 
		} // if end 

/*		논리연산자는 앞에서부터 실행한다.
		System.out.println(false && true || true);
		System.out.println(false && true);
*/ 		

		System.out.println("종료"); 
 
	} // main end 
 
} // class end 
