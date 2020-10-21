package com.bit.day15;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("주민등록번호를 다음과 같은 형식으로 입력해주세요. 000000-0000000\n> ");
			String civilNumber = sc.nextLine();
			
			if(civilNumber.length() != 14) {
				System.out.println("자릿수가 맞지 않습니다.");
			} else if (civilNumber.charAt(6) != '-') {
				System.out.println("형식에 맞지 않습니다.");
			} else {
				if(civilNumber.charAt(0) - '0' < 0 || civilNumber.charAt(0) > 9) {
					for(int i = 0; i < civilNumber.length() - 1; i++) {
						civilNumber = civilNumber.replace("영", "0");
						civilNumber = civilNumber.replace("일", "1");
						civilNumber = civilNumber.replace("이", "2");
						civilNumber = civilNumber.replace("삼", "3");
						civilNumber = civilNumber.replace("사", "4");
						civilNumber = civilNumber.replace("오", "5");
						civilNumber = civilNumber.replace("육", "6");
						civilNumber = civilNumber.replace("칠", "7");
						civilNumber = civilNumber.replace("팔", "8");
						civilNumber = civilNumber.replace("구", "9");
					}
				}
				int birth1, birth2, birthYear;
				birth1 = (civilNumber.charAt(0) - '0') * 10;
				birth2 = (civilNumber.charAt(1) - '0');
				
				if((civilNumber.charAt(7) - '0') < 3) {
					birthYear = 1900 + birth1 + birth2;
				} else {
					birthYear = 2000 + birth1 + birth2;
				}
				
				String gender = "여자";
				if((civilNumber.charAt(7) - '0') == 1 || (civilNumber.charAt(7) - '0') == 3) {
					gender = "남자";
				}
				
				int age = 1;
				java.util.Calendar cal = java.util.Calendar.getInstance();
				age += cal.get(java.util.Calendar.YEAR) - birthYear;
				
				System.out.println("당신은 " + age + "세의 " + gender + "입니다.");
				break;
			}
		} // while end
	} // main end
} // class end
