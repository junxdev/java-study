package com.bit.day17;
// 3세대 언어: VO, Controller, Viewer를 한 클래스에 담음 
// 2세대 언어: main 메서드에서 절차적 변수 생성, 제어, 출력 실행
import java.util.*;

public class StudentEx01 {
	
	String name;
	int korean;
	int english;
	int math;
	
	public int calculateSum() {
		return korean + english + math;
	}
	
	public double calculateAverage() {
		return calculateSum() / 3.0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentEx01 s = new StudentEx01();
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 : ");
		s.name = scanner.nextLine();
		System.out.print("국어 : ");
		s.korean = scanner.nextInt();
		System.out.print("영어 : ");
		s.english = scanner.nextInt();
		System.out.print("수학 : ");
		s.math = scanner.nextInt();
		System.out.printf("이름 : %s\t국어 : %d\t영어 : %d\t수학 : %d\t총점 : %d\t평균 : %.2f", s.name, s.korean, s.english, s.math, s.calculateSum(), s.calculateAverage());
		scanner.close();
	}

}
