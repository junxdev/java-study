package com.bit.day17;
// 3���� ���: VO, Controller, Viewer�� �� Ŭ������ ���� 
// 2���� ���: main �޼��忡�� ������ ���� ����, ����, ��� ����
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
		System.out.print("�̸� : ");
		s.name = scanner.nextLine();
		System.out.print("���� : ");
		s.korean = scanner.nextInt();
		System.out.print("���� : ");
		s.english = scanner.nextInt();
		System.out.print("���� : ");
		s.math = scanner.nextInt();
		System.out.printf("�̸� : %s\t���� : %d\t���� : %d\t���� : %d\t���� : %d\t��� : %.2f", s.name, s.korean, s.english, s.math, s.calculateSum(), s.calculateAverage());
		scanner.close();
	}

}
