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
			System.out.print("1.��ȸ 2.�Է� 3.���� 4.���� 0.���� > ");
			input = sc.nextLine();
			
			if(input.equals("0")) {
			} else if(input.equals("1")) {
				System.out.println("�й�\t�̸�\t����\t����\t����\t�հ�\t���");
				for(int i = 0; i < data.size(); i++) {
					Student student = (Student)data.get(i);
					System.out.println(student.num + "\t" + student.name + "\t" + student.kor + "\t" + 
					student.eng + "\t" + student.math + "\t" + student.tot() + "\t" + student.avg());
				}
				
			} else if(input.equals("2")) {
				Student student = null;
				student = new Student();
				System.out.print("�й� > ");
				student.num = Integer.parseInt(sc.nextLine());
				System.out.print("�̸� > ");
				student.name = sc.nextLine();
				System.out.print("���� > ");
				student.kor = Integer.parseInt(sc.nextLine());
				System.out.print("���� > ");
				student.eng = Integer.parseInt(sc.nextLine());
				System.out.print("���� > ");
				student.math = Integer.parseInt(sc.nextLine());
				data.add(student);
				
			} else if(input.equals("3")) {
				System.out.print("�й� > ");
				int number = Integer.parseInt(sc.nextLine());
				for(int i = 0; i < data.size(); i++) {
					Student student = (Student)data.get(i);
					if(number == student.num) {
						System.out.print("�̸� > ");
						student.name = sc.nextLine();
						System.out.print("���� > ");
						student.kor = Integer.parseInt(sc.nextLine());
						System.out.print("���� > ");
						student.eng = Integer.parseInt(sc.nextLine());
						System.out.print("���� > ");
						student.math = Integer.parseInt(sc.nextLine());
						data.set(i, student);
						break;
					}
				}
			} else if(input.equals("4")) {
				System.out.print("�й� > ");
				int number = Integer.parseInt(sc.nextLine());
				for(int i = 0; i < data.size(); i++) {
					Student student = (Student)data.get(i);
					if(number == student.num) {
						data.remove(number);
						break;
					}
				}
				
			} else {
				System.out.println("�ùٸ� ���ڸ� �Է����ּ���.");
				
			}
		}
	}

}
