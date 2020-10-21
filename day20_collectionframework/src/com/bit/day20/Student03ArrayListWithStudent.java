package com.bit.day20;

public class Student03ArrayListWithStudent {
	
	private static class Student {
		int num;
		String name;
		int kor, eng, math;
		
		int tot() {
			return kor + eng + math;
		}
		
		int avg() {
			return (tot() * 100 / 3) / 100;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ArrayList data = new java.util.ArrayList();
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String input;
		
		while(true) {
			System.out.print("1.조회 2.입력 3.수정 4.삭제 0.종료 > ");
			input = sc.nextLine();
			
			if(input.equals("0")) {
			} else if(input.equals("1")) {
				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
				for(int i = 0; i < data.size(); i++) {
					Student student = (Student)data.get(i);
					System.out.println(student.num + "\t" + student.name + "\t" + student.kor + "\t" + 
					student.eng + "\t" + student.math + "\t" + student.tot() + "\t" + student.avg());
				}
				
			} else if(input.equals("2")) {
				Student student = null;
				student = new Student();
				System.out.print("학번 > ");
				student.num = Integer.parseInt(sc.nextLine());
				System.out.print("이름 > ");
				student.name = sc.nextLine();
				System.out.print("국어 > ");
				student.kor = Integer.parseInt(sc.nextLine());
				System.out.print("영어 > ");
				student.eng = Integer.parseInt(sc.nextLine());
				System.out.print("수학 > ");
				student.math = Integer.parseInt(sc.nextLine());
				data.add(student);
				
			} else if(input.equals("3")) {
				System.out.print("학번 > ");
				int number = Integer.parseInt(sc.nextLine());
				for(int i = 0; i < data.size(); i++) {
					Student student = (Student)data.get(i);
					if(number == student.num) {
						System.out.print("이름 > ");
						student.name = sc.nextLine();
						System.out.print("국어 > ");
						student.kor = Integer.parseInt(sc.nextLine());
						System.out.print("영어 > ");
						student.eng = Integer.parseInt(sc.nextLine());
						System.out.print("수학 > ");
						student.math = Integer.parseInt(sc.nextLine());
						data.set(i, student);
						break;
					}
				}
			} else if(input.equals("4")) {
				System.out.print("학번 > ");
				int number = Integer.parseInt(sc.nextLine());
				for(int i = 0; i < data.size(); i++) {
					Student student = (Student)data.get(i);
					if(number == student.num) {
						data.remove(number);
						break;
					}
				}
				
			} else {
				System.out.println("올바른 숫자를 입력해주세요.");
				
			}
		}
	}

}
