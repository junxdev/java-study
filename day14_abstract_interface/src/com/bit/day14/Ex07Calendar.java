package com.bit.day14;

import java.util.Calendar;

public class Ex07Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		java.util.Calendar cal = new java.util.Calander(); 추상 클래스이므로 객체 생성 불가능
		java.util.Calendar cal = java.util.Calendar.getInstance();
		System.out.println(cal.toString());
		
		System.out.println(cal.get(0)); // 알기 어려운 코드보다
		System.out.print(cal.get(Calendar.YEAR) + "년"); // 명시적인 코드 작성
		System.out.print(1 + cal.get(Calendar.MONTH) + "월"); // 월만 0 ~ 11
		System.out.print(cal.get(Calendar.DATE) + "일");
		char ch = '?';
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1: ch = '일'; break;
		case 2: ch = '월'; break;
		case 3: ch = '화'; break;
		case 4: ch = '수'; break;
		case 5: ch = '목'; break;
		case 6: ch = '금'; break;
		case 7: ch = '토'; break;
		
		default: break;
		}
		System.out.print(ch + "요일");
		System.out.print("\t");
		if(cal.get(Calendar.AM) == 0) {
			System.out.print("AM");
		} else if(cal.get(Calendar.AM) == 1) {
			System.out.print("PM");
		}
		System.out.print(cal.get(Calendar.HOUR) + "시");
		System.out.print(" 또는 " + cal.get(Calendar.HOUR_OF_DAY) + "시");
		System.out.print(cal.get(Calendar.MINUTE) + "분");
		System.out.print(cal.get(Calendar.SECOND) + "초");
		System.out.print(cal.get(Calendar.WEEK_OF_YEAR) + "주차");
		System.out.print(cal.get(Calendar.DAY_OF_YEAR) + "일차");
	}

}
