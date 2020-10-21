package com.bit.day12;

import java.util.Calendar;

public class SSN03CharArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = null;
		sc = new java.util.Scanner(System.in);
		
		String input = null;
		System.out.print("주민번호 입력 : ");
//		input = sc.nextLine();
		input = "199242-2345643";
//		System.out.println(input.charAt(4));
		
		char[] ju1 = new char[6];
		char[] ju2 = new char[7];
		try {
			for(int i = 0; i < ju1.length; i++) {
				ju1[i] = (char)('0' + Integer.parseInt("" + input.charAt(i)));
			}
			if (input.charAt(6) != '-') {
				Exception err = new Exception();
				throw err;
			}
			for(int i = 0; i < ju2.length; i++) {
				ju2[i] = (char)('0' + Integer.parseInt("" + input.charAt(ju1.length + 1 + i)));
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("주민번호를 다시 확인하여 입력하세요");
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요");
		} catch (Exception e) {
			System.out.println("000000-0000000로 입력하세요");
		}
		
		int year = (ju1[0] - '0') * 10 + (ju1[1] - '0');
		if(ju2[0] == '1' || ju2[0] == '2') {
			year += 1900;
		} else {
			year += 2000;
		}
		java.util.Calendar cal = java.util.Calendar.getInstance();

		if(ju2[0] == '1' || ju2[0] == '3') {
			System.out.println("당신은 " + (cal.get(Calendar.YEAR) - year + 1) + "세의 남자입니다.");
		} else {
			System.out.println("당신은 " + (cal.get(Calendar.YEAR) - year + 1) + "세의 여자입니다.");
		}
		

	}

}
