package com.bit.day20;

public class Student01ArrayList {

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
					int number = (int)data.get(i++);
					String name = (String)data.get(i++);
					int kor = (int)data.get(i++);
					int eng = (int)data.get(i++);
					int math = (int)data.get(i++);
					int sum = kor + eng + math;
					double avg = (sum * 100 / 3) / 100.0;
					System.out.println(number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg);
				}
			} else if(input.equals("2")) {
				System.out.print("�й� > ");
				input = sc.nextLine();
				data.add(Integer.parseInt(input));
				System.out.print("�̸� > ");
				input = sc.nextLine();
				data.add(input);
				System.out.print("���� > ");
				input = sc.nextLine();
				data.add(Integer.parseInt(input)); // �Է� ���� ������ �߻��ϸ� �̹� �տ� add�� �����͸� ó���ؾ� �ϴ� ��ȿ���� �۾� �߻�
				System.out.print("���� > ");
				input = sc.nextLine();
				data.add(Integer.parseInt(input));
				System.out.print("���� > ");
				input = sc.nextLine();
				data.add(Integer.parseInt(input));
			} else if(input.equals("3")) {
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
					System.out.print("�̸� > ");
					input = sc.nextLine();
					data.set(++index, input);
					System.out.print("���� > ");
					input = sc.nextLine();
					data.set(++index, input);
					System.out.print("���� > ");
					input = sc.nextLine();
					data.set(++index, input);
					System.out.print("���� > ");
					input = sc.nextLine();
					data.set(++index, input);
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
