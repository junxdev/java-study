package com.bit.day17;

import java.util.Scanner;

// UI
// �̰��� �� ����̶�� ��������
public class StudentViewer {
	
	public StudentVO setInformation(Scanner scanner) {
		StudentVO s = new StudentVO();
		System.out.print("�̸� : ");
		s.setName(scanner.nextLine());
		System.out.print("���� : ");
		s.setKor(scanner.nextInt());;
		System.out.print("���� : ");
		s.setEng(scanner.nextInt());
		System.out.print("���� : ");
		s.setMath(scanner.nextInt());
		return s;
	}
	
	public StudentVO setInformation(Scanner scanner, int i) {
		StudentVO s = new StudentVO();
		s.setId(i);
		System.out.print("�̸� : ");
		s.setName(scanner.nextLine());
		System.out.print("���� : ");
		s.setKor(scanner.nextInt());;
		System.out.print("���� : ");
		s.setEng(scanner.nextInt());
		System.out.print("���� : ");
		s.setMath(scanner.nextInt());
		return s;
	}
}

// Model, View, Controller = MVC Pattern