package com.bit.day20;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ArrayList data = new java.util.ArrayList();
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		while(true) {
			
			System.out.print("1.���� 2.�Է� 3.���� 4.���� 0.���� > ");
			int mainMenu = Integer.parseInt(sc.nextLine());
			
			if(mainMenu == 0) {
				
				System.out.println("���α׷��� �����մϴ�.");
				break;
				
			} else if(mainMenu == 1) {
				
				System.out.println("�й�\t�̸�\t����\t����\t����\t�հ�\t���");
				
				for(int i = 0; i < data.size(); i++) {
					String student = (String)data.get(i);
					int kor = Integer.parseInt(student.substring(student.lastIndexOf("\t", student.lastIndexOf("\t", student.lastIndexOf("\t", student.lastIndexOf("\t")) - 1) - 1) + 1, student.lastIndexOf("\t", student.lastIndexOf("\t", student.lastIndexOf("\t")) - 1)));
					int eng = Integer.parseInt(student.substring(student.lastIndexOf("\t", student.lastIndexOf("\t", student.lastIndexOf("\t")) - 1) + 1, student.lastIndexOf("\t", student.lastIndexOf("\t"))));
					int math = Integer.parseInt(student.substring(student.lastIndexOf("\t", student.lastIndexOf("\t") - 1) + 1, student.lastIndexOf("\t")));
					int sum = kor + eng + math;
					double avg = (sum * 100 / 3) / 100.0;
					System.out.println(student + sum + "\t" + avg);
				}
				
			} else if(mainMenu == 2) {
				
				String student = "";
				System.out.print("�й� > ");
				student += sc.nextLine() + "\t";
				System.out.print("�̸� > ");
				student += sc.nextLine() + "\t";
				System.out.print("���� > ");
				student += sc.nextLine() + "\t";
				System.out.print("���� > ");
				student += sc.nextLine() + "\t";
				System.out.print("���� > ");
				student += sc.nextLine() + "\t";
				data.add(student);
				
			} else if(mainMenu == 3) {
				System.out.print("������ �й� > ");
				String numberToEdit = sc.nextLine();
				int number;
				boolean edit = false;
				
				for(number = 0; number < data.size(); number++) {
					String temp = (String)data.get(number);
					if(numberToEdit.equals(temp.substring(0, temp.indexOf("\t", 0)))) {
						edit = true;
						break;
					}
				}
				
				if(edit) {
					String student = "";
					System.out.print("�й� > ");
					student += sc.nextLine() + "\t";
					System.out.print("�̸� > ");
					student += sc.nextLine() + "\t";
					System.out.print("���� > ");
					student += sc.nextLine() + "\t";
					System.out.print("���� > ");
					student += sc.nextLine() + "\t";
					System.out.print("���� > ");
					student += sc.nextLine() + "\t";
					data.set(number, student);
				} else {
					System.out.println("ã�� ����� �����ϴ�.");
				}
				
			} else if(mainMenu == 4) {
				System.out.print("������ �й� > ");
				String numberToEdit = sc.nextLine();
				int number;
				boolean edit = false;
				
				for(number = 0; number < data.size(); number++) {
					String temp = (String)data.get(number);
					if(numberToEdit.equals(temp.substring(0, temp.indexOf("\t", 0)))) {
						edit = true;
						break;
					}
				}
				
				if(edit) {
					data.remove(number);
				} else {
					System.out.println("ã�� ����� �����ϴ�.");
				}
				
			} else {
				System.out.println("�ùٸ� ���ڸ� �Է����ּ���.");
			}
		}
	}

}
