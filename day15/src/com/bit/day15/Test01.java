package com.bit.day15;

import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("�� �л� ��: ");
		int maxNumber = Integer.parseInt(sc.nextLine());
		
		String[] data;
		data = new String[maxNumber];
		
		int numberCount = 0;
		
		while(true) {
			System.out.print("1.��ȸ 2.�Է� 3.���� 4.���� 0.���� > ");
			String mainMenu = sc.nextLine();
			
			if(mainMenu.equals("0")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else if(mainMenu.equals("1")) {
				System.out.println("�й�\t�̸�\t����\t����\t����\t���");
				System.out.println("---------------------------------------------");
				for(int i = 0; i < data.length; i++) {
					if(data[i] == null) {
						continue;
					}
					System.out.println(data[i]);
				}
			} else if(mainMenu.equals("2")) {
				if(numberCount < maxNumber) {
					String studentTemp = "";
					System.out.print("�̸� > ");
					String name = sc.nextLine();
					System.out.print("���� > ");
					int kor = Integer.parseInt(sc.nextLine());
					System.out.print("���� > ");
					int eng = Integer.parseInt(sc.nextLine());
					System.out.print("���� > ");
					int math = Integer.parseInt(sc.nextLine());
					double avg = (kor + eng + math) * 100 / 3 / 100.0;
					studentTemp = (numberCount + 1) + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + avg;
					
					data[numberCount] = studentTemp;
					numberCount++;
				} else if(numberCount >= maxNumber) {
					System.out.print("���� ������ " + maxNumber + "���Դϴ�.\n�л��� �߰��Ͻðڽ��ϱ�? 1.�߰� 2.��� >");
					if(Integer.parseInt(sc.nextLine()) == 1) {
						maxNumber++;
						
						System.out.println("�л��� �߰��մϴ�.");	String studentTemp = "";
						System.out.print("�̸� > ");
						String name = sc.nextLine();
						System.out.print("���� > ");
						int kor = Integer.parseInt(sc.nextLine());
						System.out.print("���� > ");
						int eng = Integer.parseInt(sc.nextLine());
						System.out.print("���� > ");
						int math = Integer.parseInt(sc.nextLine());
						double avg = (kor + eng + math) * 100 / 3 / 100.0;
						studentTemp = (numberCount + 1) + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + avg;
						
						String[] dataTemp =  new String[maxNumber];
						for(int i = 0; i < data.length; i++) {
							dataTemp[i] = data[i];
						}
						dataTemp[maxNumber - 1] = studentTemp;
						data = dataTemp;
						
						numberCount++;
					} else {
						System.out.println("�л��� �߰����� �ʽ��ϴ�.");
						continue;
					}
				}
			} else if(mainMenu.equals("3")) {
				System.out.print("�����Ϸ��� �й��� �Է��ϼ��� > ");
				int numberEdit = Integer.parseInt(sc.nextLine());
				try {
					if(data[numberEdit - 1] != null) {
						String studentTemp = "";
						System.out.print("�̸� > ");
						String name = sc.nextLine();
						System.out.print("���� > ");
						int kor = Integer.parseInt(sc.nextLine());
						System.out.print("���� > ");
						int eng = Integer.parseInt(sc.nextLine());
						System.out.print("���� > ");
						int math = Integer.parseInt(sc.nextLine());
						double avg = (kor + eng + math) * 100 / 3 / 100.0;
						studentTemp = numberEdit + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + avg;
						
						data[numberEdit - 1] = studentTemp;
					} else {
						System.out.println("�й� " + numberEdit + " �л��� �����ϴ�.");
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("�й� " + numberEdit + " �л��� �����ϴ�.");
				}
			} else if(mainMenu.equals("4")) {
				System.out.print("�����Ϸ��� �й��� �Է��ϼ��� > ");
				int numberDelete = Integer.parseInt(sc.nextLine());
				try {
					if(data[numberDelete - 1] != null) {
						data[numberDelete - 1] = null;
					} else {
						System.out.println("�й� " + numberDelete + " �л��� �����ϴ�.");
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("�й� " + numberDelete + " �л��� �����ϴ�.");
				}
			} else {
				System.out.println(mainMenu + " �߸��� �Է��Դϴ�. �ٽ� �������ּ���.");
			}
		}
	}

}
