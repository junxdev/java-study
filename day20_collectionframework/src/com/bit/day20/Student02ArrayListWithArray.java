package com.bit.day20;

public class Student02ArrayListWithArray {

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
				for(int i = 0; i < data.size();) {
					String[] student = (String[])data.get(i);
					int kor = Integer.parseInt(student[2]);
					int eng = Integer.parseInt(student[3]);
					int math = Integer.parseInt(student[4]);
					int sum = kor + eng + math;
					double avg = (sum * 100 / 3) / 100.0;
					System.out.println(student[0] + "\t" + student[1] + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg);
				}
			} else if(input.equals("2")) {
				String[] student = new String[5]; // ��ü ������ ���� ���� �������̳� �� �л��� ������ ���� ���� �����Ƿ� �迭 Ȱ��
				System.out.print("�й� > ");
				student[0] = sc.nextLine(); // �پ��� �ڷ����� Ȱ���Ϸ��� Object[] Ȱ��
				System.out.print("�̸� > ");
				student[1] = sc.nextLine();
				System.out.print("���� > ");
				student[2] = sc.nextLine();
				System.out.print("���� > ");
				student[3] = sc.nextLine();
				System.out.print("���� > ");
				student[4] = sc.nextLine();
				data.add(student);
			} else if(input.equals("3")) {
				System.out.print("�й� > ");
				String number = sc.nextLine();
				int index = -1;
				for(int i = 0; i < data.size(); i++) {
					if(number == ((String[])data.get(i))[0]) {
						index = i;
						break;
					}
				}
				
				if(index > -1) {
					String[] student = (String[])data.get(index);
					System.out.print("�̸� > ");
					student[1] = sc.nextLine();
					System.out.print("���� > ");
					student[2] = sc.nextLine();
					System.out.print("���� > ");
					student[3] = sc.nextLine();
					System.out.print("���� > ");
					student[4] = sc.nextLine();
					data.set(index, student);
				} else {
					System.out.println("ã�� ����� �����ϴ�.");
				}
				
			} else if(input.equals("4")) {
				System.out.print("�й� > ");
				int number = Integer.parseInt(sc.nextLine());
				int index = -1;
				for(int i = 0; i < data.size(); i += 5) {
					if(number == (int)data.get(i)) {
						index = i;
						break;
					}
				}
				
				if(index > -1) {
					for(int i = 0; i < 5; i++) {
						data.remove(index);
					}
				} else {
					System.out.println("ã�� ����� �����ϴ�.");
				}
				
			} else {
				System.out.println("�ùٸ� ���ڸ� �Է����ּ���.");
				
			}
		}
	}

}
