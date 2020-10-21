class Ex34 { 
 
	public static void main(String[] args) { 
 
		java.util.Scanner sc = new java.util.Scanner(System.in);

		System.out.println("\n가위바위보 게임 ver 0.0.2");
		System.out.println("---------------------------");

		Boolean play = true;

		int win = 0;
		int draw = 0;
		int lose = 0;

		while (play) {

			System.out.print("\n1.가위 2.바위 3.보 0.종료 >>> "); 
			int input = sc.nextInt() - 1; 
			
			if (input == -1) {

				play = false;

			} else {

				String msg = "당신 : ";
				if (input == 0) {
					msg += "가위";
				} else if (input == 1){
					msg += "바위";
				} else {
					msg += "보";
				}
				
				int com = (int)(Math.random() * 3); // 0 <= com < 3		
		
				msg += ", 컴퓨터 : ";
				if (com == 0) {
					msg += "가위";
				} else if (com == 1) {
					msg += "바위";
				} else {
					msg += "보";
				}	
		
			 	System.out.println(msg);
		
				if (input == com) {
					System.out.println("비겼습니다");
					draw++;
				} else if ((input == 0 && com == 2)||(input == 1 && com == 0) || (input == 2 && com == 1)) {
					System.out.println("이겼습니다");
					win++;
				} else {
					System.out.println("졌습니다");
					lose++;
				}

			}

	 	} // while end

		System.out.print("전적 : " + win + "승 " + draw + "무 " + lose + "패 "); 
		System.out.print("게임 종료"); 

	} // main end 
	 
} // class end 
