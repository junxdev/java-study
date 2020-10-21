package com.bit.day14;

class Student{
	int number;
	String name;
	int kor, eng, math;
	
	Student(int number){
		this.number = number;
	}
}

public class AnswerStudent02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("�ѿ� : ");
		int maxNumber = Integer.parseInt(sc.nextLine());
		Student[] data = new Student[maxNumber];
		int cnt = 0;
		while(true) {
			System.out.print("1.��� 2.�Է� 3.���� 4.���� : ");
			String input = sc.nextLine();
			if(input.equals("0")) {
				break;
			} else if(input.equals("1")) {
				System.out.println("----------------------------------------------");
				System.out.println("�й�\t�̸�\t����\t����\t����\t���");
				System.out.println("----------------------------------------------");
				for(int i = 0; i < data.length; i++) {
					Student student = data[i];
					if(student == null) {
						continue;
					}
					System.out.print(student.number + "\t");
					System.out.print(student.name + "\t");
					System.out.print(student.kor + "\t");
					System.out.print(student.eng + "\t");
					System.out.print(student.math + "\t");
					System.out.println(((student.kor + student.eng + student.math) * 100 / 3 / 100.0) + "\t");
				}
			} else if(input.equals("2") && cnt < maxNumber) {
				Student student = new Student(++cnt);
				System.out.print("�̸� : ");
				student.name = sc.nextLine();
				System.out.print("���� : ");
				student.kor = Integer.parseInt(sc.nextLine());
				System.out.print("���� : ");
				student.eng = Integer.parseInt(sc.nextLine());
				System.out.print("���� : ");
				student.math = Integer.parseInt(sc.nextLine());
				data[cnt - 1] = student;
			} else if(input.equals("3")) {
				System.out.print("�й� : ");
				int number_edit = Integer.parseInt(sc.nextLine());
				Student student = new Student(number_edit);
				System.out.print("�̸� : ");
				student.name = sc.nextLine();
				System.out.print("���� : ");
				student.kor = Integer.parseInt(sc.nextLine());
				System.out.print("���� : ");
				student.eng = Integer.parseInt(sc.nextLine());
				System.out.print("���� : ");
				student.math = Integer.parseInt(sc.nextLine());
				
				data[number_edit - 1] = student;
			} else if(input.equals("4")) {
				System.out.print("�й� : ");
				int number_delete = Integer.parseInt(sc.nextLine());
				data[number_delete - 1] = null;
			}
		}
	}

}
