package com.bit.day20;

import java.util.ArrayList;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ArrayList data = new java.util.ArrayList();
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("1.��ȸ 2.�Է� 3.���� 4.���� 0.���� > ");
			int mainMenu = Integer.parseInt(sc.nextLine());
			
			if(mainMenu == 0) {
				
				System.out.println("���α׷��� �����մϴ�.");
				break;
				
			} else if(mainMenu == 1) {
				System.out.print("1.��ü ��ȸ 2.�й� ��ȸ 0.����> ");
				int readMenu = Integer.parseInt(sc.nextLine());
				if(readMenu == 0) {

					System.out.println("���θ޴��� �̵��մϴ�.");
					
				} else if(readMenu == 1) {
					
					for(int i = 0; i < data.size(); i++) {
						java.util.ArrayList student = (ArrayList)data.get(i);
					}
				} else if(readMenu == 2) {
					
				} else {
					
				}
			} else if(mainMenu == 2) {
				java.util.ArrayList student = new java.util.ArrayList();
				System.out.print("�й� > ");
				student.add(sc.nextLine());
				System.out.print("�̸� > ");
				student.add(sc.nextLine());
				System.out.print("���� > ");
				student.add(sc.nextLine());
				System.out.print("���� > ");
				student.add(sc.nextLine());
				System.out.print("���� > ");
				student.add(sc.nextLine());
				data.add(student);
			} else if(mainMenu == 3) {
			} else if(mainMenu == 4) {
			} else {
			}
		}
			
	}

}
