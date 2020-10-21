package com.bit.day17;

import java.util.Scanner;

// UI
// 이것이 웹 출력이라면 웹페이지
public class StudentViewer {
	
	public StudentVO setInformation(Scanner scanner) {
		StudentVO s = new StudentVO();
		System.out.print("이름 : ");
		s.setName(scanner.nextLine());
		System.out.print("국어 : ");
		s.setKor(scanner.nextInt());;
		System.out.print("영어 : ");
		s.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		s.setMath(scanner.nextInt());
		return s;
	}
	
	public StudentVO setInformation(Scanner scanner, int i) {
		StudentVO s = new StudentVO();
		s.setId(i);
		System.out.print("이름 : ");
		s.setName(scanner.nextLine());
		System.out.print("국어 : ");
		s.setKor(scanner.nextInt());;
		System.out.print("영어 : ");
		s.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		s.setMath(scanner.nextInt());
		return s;
	}
}

// Model, View, Controller = MVC Pattern