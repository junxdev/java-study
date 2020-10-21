package com.bit.day21;

import java.util.*;

class Student {
	int number, korean, english, math;
	String name;
}

public class Test04Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Map<Integer , Student> data = new HashMap();
		
		while(true) {
			TreeSet keySet = new TreeSet(data.keySet());
			Iterator numberSet = keySet.iterator();

			System.out.print("1.조회 2.입력 3.수정 4.삭제 0.종료 > ");
			String mainMenu = sc.nextLine();
			if(mainMenu.equals("0")) {
				break;
			} else if(mainMenu.equals("1")) {
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균\t합계");
				for(int i = 0; i < data.size(); i++) {
					int number = (int)numberSet.next();
					Student student = (Student)data.get(number);
					int total = student.korean + student.english + student.math;
					System.out.println(student.number + "\t" + student.name + "\t" + student.korean + "\t" + student.english + "\t" + student.math
							+ "\t" + total + "\t" + ((total * 100 / 3) / 100.0));
				}
			} else if(mainMenu.equals("2")) {
				Student student = new Student();
				System.out.print("학번 > ");
				student.number = Integer.parseInt(sc.nextLine());
				System.out.print("이름 > ");
				student.name = sc.nextLine();
				System.out.print("국어 > ");
				student.korean = Integer.parseInt(sc.nextLine());
				System.out.print("영어 > ");
				student.english = Integer.parseInt(sc.nextLine());
				System.out.print("수학 > ");
				student.math = Integer.parseInt(sc.nextLine());
				data.put(student.number, student);
			} else if(mainMenu.equals("3")) {
				System.out.print("학번 > ");
				int numberToFind = Integer.parseInt(sc.nextLine());
				if(keySet.contains(numberToFind)) {
					Student student = new Student();
					System.out.print("학번 > ");
					student.number = Integer.parseInt(sc.nextLine());
					System.out.print("이름 > ");
					student.name = sc.nextLine();
					System.out.print("국어 > ");
					student.korean = Integer.parseInt(sc.nextLine());
					System.out.print("영어 > ");
					student.english = Integer.parseInt(sc.nextLine());
					System.out.print("수학 > ");
					student.math = Integer.parseInt(sc.nextLine());
					data.put(student.number, student);
				} else {
					System.out.println("찾는 대상이 없습니다.");
				}
			} else if(mainMenu.equals("4")) {
				System.out.print("학번 > ");
				int numberToFind = Integer.parseInt(sc.nextLine());
				if(keySet.contains(numberToFind)) {
					data.remove(numberToFind);
				} else {
					System.out.println("찾는 대상이 없습니다.");
				}
			} else {
				System.out.println("프로그램을 종료합니다.");
			}
		}
	}

}
