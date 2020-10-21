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
			
			System.out.print("1.조회 2.입력 3.수정 4.삭제 0.종료 > ");
			int mainMenu = Integer.parseInt(sc.nextLine());
			
			if(mainMenu == 0) {
				break;
				
			} else if(mainMenu == 1) {
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균\t합계");
				for(int i = 0; i < data.size(); i++) {
					int studentNumber = (int)studentNumberList.next();
					List student = (ArrayList)data.get(studentNumber);
					int sum = (int)student.get(1) + (int)student.get(2) + (int)student.get(3);
					System.out.println(studentNumber + "\t" + student.get(0) + "\t" + student.get(1) + "\t" + student.get(2) + "\t" + student.get(3)
							+ "\t" + sum + "\t" + ((sum * 100 / 3) / 100.0));
				}
				
			} else if(mainMenu == 2) {
				System.out.print("학번 > ");
				int num = Integer.parseInt(sc.nextLine()); 
				List student = new ArrayList();
				System.out.print("이름 > ");
				student.add(sc.nextLine());
				System.out.print("국어 > ");
				student.add(Integer.parseInt(sc.nextLine()));
				System.out.print("영어 > ");
				student.add(Integer.parseInt(sc.nextLine()));
				System.out.print("수학 > ");
				student.add(Integer.parseInt(sc.nextLine())); 
				data.put(num, student);
				
			} else if(mainMenu == 3) {
				System.out.print("수정할 학번 > ");
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
					System.out.print("이름 > ");
					student.add(sc.nextLine());
					System.out.print("국어 > ");
					student.add(Integer.parseInt(sc.nextLine()));
					System.out.print("영어 > ");
					student.add(Integer.parseInt(sc.nextLine()));
					System.out.print("수학 > ");
					student.add(Integer.parseInt(sc.nextLine())); 
					data.put(numberFound, student);
				} else {
					System.out.println("학생을 찾을 수 없습니다.");
				}
				
			} else if(mainMenu == 4) {
				System.out.print("삭제할 학번 > ");
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
					System.out.println("학생을 찾을 수 없습니다.");
				}
				
			} else {
				System.out.println("올바른 값을 입력해주세요.");
				
			}
		} // while end
		System.out.println("프로그램을 종료합니다.");
	} // main end

} // class end
