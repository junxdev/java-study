package com.bit.day21;

import java.util.*;

public class Test03Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Map data = new HashMap();
		while(true) {
			TreeSet studentNumberSet = new TreeSet(data.keySet());
			Iterator studentNumberList = studentNumberSet.iterator();
			
			System.out.print("1.��ȸ 2.�Է� 3.���� 4.���� 0.���� > ");
			int mainMenu = Integer.parseInt(sc.nextLine());
			
			if(mainMenu == 0) {
				break;
				
			} else if(mainMenu == 1) {
				System.out.println("�й�\t�̸�\t����\t����\t����\t���\t�հ�");
				for(int i = 0; i < data.size(); i++) {
					int studentNumber = (int)studentNumberList.next();
					List student = (ArrayList)data.get(studentNumber);
					int sum = (int)student.get(1) + (int)student.get(2) + (int)student.get(3);
					System.out.println(studentNumber + "\t" + student.get(0) + "\t" + student.get(1) + "\t" + student.get(2) + "\t" + student.get(3)
							+ "\t" + sum + "\t" + ((sum * 100 / 3) / 100.0));
				}
				
			} else if(mainMenu == 2) {
				System.out.print("�й� > ");
				int num = Integer.parseInt(sc.nextLine()); 
				List student = new ArrayList();
				System.out.print("�̸� > ");
				student.add(sc.nextLine());
				System.out.print("���� > ");
				student.add(Integer.parseInt(sc.nextLine()));
				System.out.print("���� > ");
				student.add(Integer.parseInt(sc.nextLine()));
				System.out.print("���� > ");
				student.add(Integer.parseInt(sc.nextLine())); 
				data.put(num, student);
				
			} else if(mainMenu == 3) {
				System.out.print("������ �й� > ");
				int numberToFind = Integer.parseInt(sc.nextLine()); 
				int numberFound = -1;
				for(int i = 0; i < data.size(); i++) {
					if(numberToFind == (int)studentNumberList.next()) {
						numberFound = numberToFind;
						break;
					}
				}
				if(numberFound != -1) {
					List student = new ArrayList();
					System.out.print("�̸� > ");
					student.add(sc.nextLine());
					System.out.print("���� > ");
					student.add(Integer.parseInt(sc.nextLine()));
					System.out.print("���� > ");
					student.add(Integer.parseInt(sc.nextLine()));
					System.out.print("���� > ");
					student.add(Integer.parseInt(sc.nextLine())); 
					data.put(numberFound, student);
				} else {
					System.out.println("�л��� ã�� �� �����ϴ�.");
				}
				
			} else if(mainMenu == 4) {
				System.out.print("������ �й� > ");
				int numberToFind = Integer.parseInt(sc.nextLine()); 
				int numberFound = -1;
				for(int i = 0; i < data.size(); i++) {
					if(numberToFind == (int)studentNumberList.next()) {
						numberFound = numberToFind;
						break;
					}
				}
				if(numberFound != -1) {
					data.remove(numberFound);
				} else {
					System.out.println("�л��� ã�� �� �����ϴ�.");
				}
				
			} else {
				System.out.println("�ùٸ� ���� �Է����ּ���.");
				
			}
		} // while end
		System.out.println("���α׷��� �����մϴ�.");
	} // main end

} // class end
