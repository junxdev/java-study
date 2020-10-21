package com.bit.day19;

import java.util.Arrays;
import java.util.Scanner;

class Student {
	int num, kor, eng, math;
}

public class Answer03StudentDynamicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�л� �������� ���α׷� ver 0.2.0");
		System.out.println("--------------------------------------------");
		Student[] data = new Student[0];
		Scanner sc = new Scanner(System.in);
		String input;
		while(true) {
			System.out.println("1.���� 2.�Է� 3.���� 4.���� 0.����");
			input = sc.nextLine();
			if(input.equals("0")) {
				break;
			} else if(input.equals("1")) {
				System.out.println("--------------------------------------------");
				System.out.println("�й�\t����\t����\t����");
				System.out.println("--------------------------------------------");
				for(int i = 0; i < data.length; i++) {
					Student student = data[i];
					System.out.print(student.num);
					System.out.print("\t");
					System.out.print(student.kor);
					System.out.print("\t");
					System.out.print(student.eng);
					System.out.print("\t");
					System.out.print(student.math);
					System.out.print("\n");
				}
			} else if(input.equals("2")) {
				Student student = new Student();
				System.out.print("�й� > ");
				student.num = Integer.parseInt(sc.nextLine());
				System.out.print("���� > ");
				student.kor = Integer.parseInt(sc.nextLine());
				System.out.print("���� > ");
				student.eng = Integer.parseInt(sc.nextLine());
				System.out.print("���� > ");
				student.math = Integer.parseInt(sc.nextLine());
				data = Arrays.copyOf(data, data.length + 1);
				data[data.length - 1] = student;
				
//				Way 1
//				Student[] temp = new Student[data.length + 1];
//				System.arraycopy(data, 0, temp, 0, data.length);
//				temp[data.length] = student;
//				data = temp;
				
//				Way 2
//				Student[] temp = new Student[data.length + 1];
//				for(int i = 0; i < data.length; i++) {
//					temp[i] = data[i];
//				}
//				data = temp;
//				data[data.length - 1] = student;
			} else if(input.equals("3")) {
				Student student = new Student();
				System.out.print("�й� > ");
				student.num = Integer.parseInt(sc.nextLine());
				int i = 0; // ������ int ���� ���� �ݺ������� ���� Ȱ��
				for(; i < data.length; i++) {
					if(data[i].num == student.num) {
						break; // �ش� �й��� �ε����� ã�� �ݺ��� ����
					}
				}
				if(i < data.length) {
					System.out.print("���� > ");
					student.kor = Integer.parseInt(sc.nextLine());
					System.out.print("���� > ");
					student.eng = Integer.parseInt(sc.nextLine());
					System.out.print("���� > ");
					student.math = Integer.parseInt(sc.nextLine());
					data[i] = student;
				} else {
					System.out.println("������ ����� �����ϴ�.");
				}
			} else if(input.equals("4")) {
				System.out.print("�й� > ");
				int num = Integer.parseInt(sc.nextLine());
				int i = 0;
				for(; i < data.length; i++) {
					if(data[i].num == num) {
						break;
					}
				}
				if(i < data.length) {
					Student[] temp = new Student[data.length - 1];
					
					System.arraycopy(data, 0, temp, 0, i);
					System.arraycopy(data, i + 1, temp, i, temp.length - i);
										
//					Way 1
//					for(int j = 0; j < i; j++) {
//						temp[j] = data[j];
//					}
//					for(int j = i; j < temp.length; j++) {
//						temp[j] = data[j + 1];
//					}

					data = temp;
				} else {
					System.out.println("������ ����� �����ϴ�.");
				}
				
			}
		}
		sc.close();
	}

}
