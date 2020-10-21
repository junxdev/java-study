class Ex33 { 
 
	public static void main(String[] args) { 

		java.util.Scanner sc = new java.util.Scanner(System.in);

		System.out.println("\n가위바위보 게임 ver 0.0.2");
		System.out.println("---------------------------");
 
		int count_play = 0;

		String user = "";
		String bot = "";
		String result = "";

		int win = 0;
		int draw = 0;
		int lose = 0;
		int select_user = 1;

		while (count_play < 5 && select_user != 0) {

			// 사람 선택
			System.out.print("\n1.가위 2.바위 3.보 0.종료 >>> ");
			select_user = sc.nextInt();

			// 컴퓨터 선택
			int select_bot = 3;
			while (select_bot > 2) {
			select_bot = (int)(Math.random() * 10);
			}

			// 가위 바위 보 비교
			if (select_user != 0) {
				if (select_user == 1) {
					user = "가위";
					if (select_bot == 0) {
						bot = "가위";
						result = "비";
						draw++;
					} else if (select_bot == 1) {
						bot = "바위";
						result = "컴퓨터가 이";
						lose++;
					} else {
						bot = "보";
						result = "당신이 이";
						win++;
					}
				} else if (select_user == 2) {
					user = "바위";
					if (select_bot == 0) {
						bot = "가위";
						result = "당신이 이";
						win++;
					} else if (select_bot == 1) {
						bot = "바위";
						result = "비";
						draw++;
					} else {
						bot = "보";
						result = "컴퓨터가 이";
						lose++;
					}
				} else if (select_user == 3) {
					user = "보";
					if (select_bot == 0) {
						bot = "가위";
						result = "컴퓨터가 이";
						lose++;
					} else if (select_bot == 1) {
						bot = "바위";
						result = "당신이 이";
						win++;
					} else {
						bot = "보";
						result = "비";
						draw++;
					}
				} else {
					count_play += 5;
				} // 가위 바위 보 비교 종료

				System.out.println("당신 : " + user + " , 컴퓨터 : " + bot);
				System.out.println(result + "겼습니다");
			
				count_play++;

			} // 사용자 0 입력 조회 종료

 		} // while end

		System.out.println(count_play + "게임 전적 : " + win + "승 " + draw + "무 " + lose + "패 ");
		System.out.println("게임을 종료합니다");

	} // main end 
 
} // class end 

		
//			String[] arr = {"가위", "바위", "보"};
//			System.out.println("당신 : " + arr[select_user - 1] + " , 컴퓨터 : " + arr[select_bot - 1]);

/*			switch (select_user) {
				case 0 : 
					play_time += 5;
					break;
				case 1 :
					switch (select_bot) {
					case 1 :
						System.out.println("가위 가위 : 무");
						draw++;
						break;
					case 2 :
						System.out.println("가위 바위 : 패");
						lose++;
						break;
					case 3 :
						System.out.println("가위 보 : 승");
						win++;
						break;
					}
					break;
				case 2 :
					switch (select_bot) {
					case 1 :
						System.out.println("바위 가위 : 승");
						win++;
						break;
					case 2 :
						System.out.println("바위 바위 : 무");
						draw++;
						break;
					case 3 :
						System.out.println("바위 보 : 패");
						lose++;
						break;
					}
					break;
				case 3 :
					switch (select_bot) {
					case 1 :
						System.out.println("보 가위 : 패");
						lose++;
						break;
					case 2 :
						System.out.println("보 바위 : 승");
						win++;
						break;
					case 3 :
						System.out.println("보 보 : 무");
						draw++;
						break;
					}
					break;
				default :
					System.out.println("올바른 숫자를 입력하세요");
					continue;
			}
*/		

