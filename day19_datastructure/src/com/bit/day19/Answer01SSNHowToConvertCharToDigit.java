package com.bit.day19;

public class Answer01SSNHowToConvertCharToDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = null;
		sc = new java.util.Scanner(System.in);
		String msg = null;
		
	
		
		char[] origin = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] target = {'공', '일', '이', '삼', '사', '오', '육', '칠', '팔', '구'}; // 임의로 규칙을 만든다.
		char gender = '#';
		int age;
		
		while(true) {
			System.out.println("주민번호 > ");
			msg = sc.nextLine();
			
			if(msg.length() != 14) {
				System.out.println("입력을 다시 확인하세요");
				continue;
			}
			if(msg.charAt(6) != '-') {
				System.out.println("형식을 다시 확인하세요");
				continue;
			}
			for(int i = 0; i < msg.length(); i++) {
				if(i == 6) {continue;}
				if(!Character.isDigit(msg.charAt(i))) {
	//				for(int j = 0; j < target.length; j++) {
	//					if(msg.charAt(i) == target[j]) {
	//						msg = msg.replace(msg.charAt(i), origin[j]); // 이 방식이면 9번 replace하면 됨
	//						break;
	//					}
	//				}
					for(int j = 0; j < target.length; j++) {
						if(msg.charAt(i) == target[j]) {
							String before = msg.substring(0, i);
							String after = msg.substring(i + 1);
							msg = before + origin[j] + after;
							break;
						}
					}
				}
			}
			boolean boo = false;
			for(int i = 0; i < msg.length(); i++) {
				if(i == 6) {continue;}
				if(!Character.isDigit(msg.charAt(i))) {
					boo = true;
					break;
				}
			}
			if(boo) {
				System.out.println("숫자가 아닌 입력이 있습니다.");
				continue;
			}
			
			int year = Integer.parseInt(msg.substring(0, 2)); // 출생 년도
			
			java.util.Date now = new java.util.Date();
			java.text.DateFormat now2 = java.text.DateFormat.getInstance();
			String result = now2.format(now);
			int nowYear = Integer.parseInt(result.substring(0, 2)); // 현재 년도
			
			gender = msg.charAt(7); // 나이
			if(gender == '1' || gender == '2') {
				age = 1 + ((2000 + nowYear) - (1900 + year));
			} else {
				age = 1 + (nowYear - year);
			}
			
			if(gender == '1' || gender == '3') { // 성별
				gender = '남';
			} else if(gender == '2' || gender == '4') {
				gender = '여';
			}
			break;
		}
		sc.close();
		System.out.println("당신은 " + age + "세 " + gender + "자입니다.");
	}

}
