package com.bit.day19;

import java.util.Arrays;
import java.util.Scanner;

class Student {
	int num, kor, eng, math;
}

public class Answer03StudentDynamicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("학생 성적관리 프로그램 ver 0.2.0");
		System.out.println("--------------------------------------------");
		Student[] data = new Student[0];
		Scanner sc = new Scanner(System.in);
		String input;
		while(true) {
			System.out.println("1.보기 2.입력 3.수정 4.삭제 0.종료");
			input = sc.nextLine();
			if(input.equals("0")) {
				break;
			} else if(input.equals("1")) {
				System.out.println("--------------------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
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
				System.out.print("학번 > ");
				student.num = Integer.parseInt(sc.nextLine());
				System.out.print("국어 > ");
				student.kor = Integer.parseInt(sc.nextLine());
				System.out.print("영어 > ");
				student.eng = Integer.parseInt(sc.nextLine());
				System.out.print("수학 > ");
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
				System.out.print("학번 > ");
				student.num = Integer.parseInt(sc.nextLine());
				int i = 0; // 별도로 int 변수 없이 반복문에서 동시 활용
				for(; i < data.length; i++) {
					if(data[i].num == student.num) {
						break; // 해당 학번의 인덱스를 찾고 반복문 종료
					}
				}
				if(i < data.length) {
					System.out.print("국어 > ");
					student.kor = Integer.parseInt(sc.nextLine());
					System.out.print("영어 > ");
					student.eng = Integer.parseInt(sc.nextLine());
					System.out.print("수학 > ");
					student.math = Integer.parseInt(sc.nextLine());
					data[i] = student;
				} else {
					System.out.println("수정할 대상이 없습니다.");
				}
			} else if(input.equals("4")) {
				System.out.print("학번 > ");
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
					System.out.println("삭제할 대상이 없습니다.");
				}
				
			}
		}
		sc.close();
	}

}
