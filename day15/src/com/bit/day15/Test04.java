package com.bit.day15;

class Student {
	int number, kor, eng, math;
	String name;
	
	Student(int number) {
		this.number = number;
	}
	
	void readData() {
		System.out.println(number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + ((kor + eng + math) * 100 / 3 / 100.0));
	}
	
	void writeData() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("�̸� > ");
		this.name = sc.nextLine();
		System.out.print("���� > ");
		this.kor = Integer.parseInt(sc.nextLine());
		System.out.print("���� > ");
		this.eng = Integer.parseInt(sc.nextLine());
		System.out.print("���� > ");
		this.math = Integer.parseInt(sc.nextLine());
	}
	
}
public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);

		Student[][] data = new Student[1][];
		int studentCount = 0;
		
		while(true) {
			System.out.print("1.��ȸ 2.�Է� 3.���� 4.���� > ");
			int mainMenu = Integer.parseInt(sc.nextLine());
			
			if(mainMenu == 0) {
				
			} else if(mainMenu == 1) {
				Student student = new Student(studentCount);
				student.writeData();
			} else if(mainMenu == 2) {
				
			} else if(mainMenu == 3) {
				
			} else if(mainMenu == 4) {
				
			} else {
				System.out.println("�ùٸ� �Է��� �ƴմϴ�.");
			}
		}
		
	}

}
