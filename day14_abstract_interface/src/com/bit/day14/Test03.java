package com.bit.day14;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("�� �л� �� : ");
		int maxNumber = sc.nextInt();
		int numberCount = 0;
		
		int[][] student = null;
		student = new int[maxNumber][];
		
		while(true) {
			System.out.print("1.��ȸ 2.�Է� 3.���� 4.���� 0.���� > ");
			int mainSelect = sc.nextInt();
			
			if(mainSelect == 0) {
				break;
			} else if(mainSelect == 1) {
				System.out.println("�й�\t����\t����\t����\t���");
				System.out.println("--------------------------------------------");
				for(int i = 0; i < maxNumber; i++) {
					if(student[i] == null) {
						continue;
					}
					System.out.print(student[i][0] + "\t");
					System.out.print(student[i][1] + "\t");
					System.out.print(student[i][2] + "\t");
					System.out.print(student[i][3] + "\t");
					System.out.print(((student[i][1] + student[i][2] + student[i][3]) * 100 / 3 / 100.0) + "\n");
				}
			} else if(mainSelect == 2) {
				if(numberCount < maxNumber) {
					int[] studentTemp = new int[4];
					studentTemp[0] = numberCount + 1;
					System.out.print("���� > ");
					studentTemp[1] = sc.nextInt();
					System.out.print("���� > ");
					studentTemp[2] = sc.nextInt();
					System.out.print("���� > ");
					studentTemp[3] = sc.nextInt();
					student[numberCount++] = studentTemp;
				} else {
					System.out.println("������ �ʰ��߽��ϴ�.");
				}
			} else if(mainSelect == 3) {
				System.out.print("������ �й� > ");
				int numberDelete = sc.nextInt();
				if(numberDelete < 1 || numberDelete > maxNumber) {
					System.out.println("�߸��� �Է��Դϴ�.");
					continue;
				}
				if(student[numberDelete - 1] != null) {
					int[] studentTemp = new int[4];
					studentTemp[0] = numberDelete;
					System.out.print("���� > ");
					studentTemp[1] = sc.nextInt();
					System.out.print("���� > ");
					studentTemp[2] = sc.nextInt();
					System.out.print("���� > ");
					studentTemp[3] = sc.nextInt();
					student[numberDelete - 1] = studentTemp;
				} else {
					System.out.println("�л��� ã�� �� �����ϴ�.");
				}
			} else if(mainSelect == 4) {
				System.out.print("������ �й� > ");
				int numberDelete = sc.nextInt();
				if(numberDelete < 1 || numberDelete > maxNumber) {
					System.out.println("�߸��� �Է��Դϴ�.");
					continue;
				}
				if(student[numberDelete - 1] != null) {
					student[numberDelete - 1] = null;
				} else {
					System.out.println("�л��� ã�� �� �����ϴ�.");
				}
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
		
	}

}
