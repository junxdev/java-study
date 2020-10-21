package com.bit.day19;

public class Answer02SSNHowToConvertCharToDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = null;
		sc = new java.util.Scanner(System.in);
		String msg = null;
		
		char[] target = {'공', '일', '이', '삼', '사', '오', '육', '칠', '팔', '구'}; // 임의로 규칙을 만든다.
		int age;
		char gender = '#';
		
		do {
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
			
			int year = 0;
			try { // 해외에서 활용하는 try catch를 활용한 예외처리 
				year = Integer.parseInt(msg.substring(0, 2)); // 출생 년도
			} catch(NumberFormatException e1) { // 문자가 입력되면
				String temp = msg.substring(0, 2);
				char[] temp2 = new char[2];
				for(int i = 0; i < temp.length(); i++) { // 숫자 문자로 변환하고
					char ch = temp.charAt(i);
					for(int j = 0; j < target.length; j++) {
						if(ch == target[j]) {
							temp2[i] = (char)('0' + j);
						}
					}
				}
				try {
					year = Integer.parseInt(new String(temp2)); // 숫자로 변환
				} catch(NumberFormatException e2) {
					System.out.println("입력을 다시 확인하세요");
					continue;
				}
			}
			
			java.util.Date now = new java.util.Date();
			java.text.DateFormat now2 = java.text.DateFormat.getInstance();
			String result = now2.format(now);
			int nowYear = Integer.parseInt(result.substring(0, 2)); // 현재 년도
			
			gender = msg.charAt(7); // 나이
			if(gender == '1' || gender == '2' || gender == '일' || gender == '이') {
				age = 1 + ((2000 + nowYear) - (1900 + year));
			} else {
				age = 1 + (nowYear - year);
			}
			
			if(gender == '1' || gender == '3'|| gender == '일' || gender == '삼') { // 성별
				gender = '남';
			} else if(gender == '2' || gender == '4'|| gender == '이' || gender == '사') {
				gender = '여';
			}
			break;
		} while(true);
		sc.close();
		System.out.println("당신은 " + age + "세 " + gender + "자입니다.");
	}

}
