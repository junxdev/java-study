package com.bit.day20;

import java.util.ArrayList;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ArrayList data = new java.util.ArrayList();
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("1.조회 2.입력 3.수정 4.삭제 0.종료 > ");
			int mainMenu = Integer.parseInt(sc.nextLine());
			
			if(mainMenu == 0) {
				
				System.out.println("프로그램을 종료합니다.");
				break;
				
			} else if(mainMenu == 1) {
				System.out.print("1.전체 조회 2.학번 조회 0.종료> ");
				int readMenu = Integer.parseInt(sc.nextLine());
				if(readMenu == 0) {

					System.out.println("메인메뉴로 이동합니다.");
					
				} else if(readMenu == 1) {
					
					for(int i = 0; i < data.size(); i++) {
						java.util.ArrayList student = (ArrayList)data.get(i);
					}
				} else if(readMenu == 2) {
					
				} else {
					
				}
			} else if(mainMenu == 2) {
				java.util.ArrayList student = new java.util.ArrayList();
				System.out.print("학번 > ");
				student.add(sc.nextLine());
				System.out.print("이름 > ");
				student.add(sc.nextLine());
				System.out.print("국어 > ");
				student.add(sc.nextLine());
				System.out.print("영어 > ");
				student.add(sc.nextLine());
				System.out.print("수학 > ");
				student.add(sc.nextLine());
				data.add(student);
			} else if(mainMenu == 3) {
			} else if(mainMenu == 4) {
			} else {
			}
		}
			
	}

}
