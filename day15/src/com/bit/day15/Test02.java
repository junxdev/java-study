package com.bit.day15;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("�ֹε�Ϲ�ȣ�� ������ ���� �������� �Է����ּ���. 000000-0000000\n> ");
			String civilNumber = sc.nextLine();
			
			if(civilNumber.length() != 14) {
				System.out.println("�ڸ����� ���� �ʽ��ϴ�.");
			} else if (civilNumber.charAt(6) != '-') {
				System.out.println("���Ŀ� ���� �ʽ��ϴ�.");
			} else {
				if(civilNumber.charAt(0) - '0' < 0 || civilNumber.charAt(0) > 9) {
					for(int i = 0; i < civilNumber.length() - 1; i++) {
						civilNumber = civilNumber.replace("��", "0");
						civilNumber = civilNumber.replace("��", "1");
						civilNumber = civilNumber.replace("��", "2");
						civilNumber = civilNumber.replace("��", "3");
						civilNumber = civilNumber.replace("��", "4");
						civilNumber = civilNumber.replace("��", "5");
						civilNumber = civilNumber.replace("��", "6");
						civilNumber = civilNumber.replace("ĥ", "7");
						civilNumber = civilNumber.replace("��", "8");
						civilNumber = civilNumber.replace("��", "9");
					}
				}
				int birth1, birth2, birthYear;
				birth1 = (civilNumber.charAt(0) - '0') * 10;
				birth2 = (civilNumber.charAt(1) - '0');
				
				if((civilNumber.charAt(7) - '0') < 3) {
					birthYear = 1900 + birth1 + birth2;
				} else {
					birthYear = 2000 + birth1 + birth2;
				}
				
				String gender = "����";
				if((civilNumber.charAt(7) - '0') == 1 || (civilNumber.charAt(7) - '0') == 3) {
					gender = "����";
				}
				
				int age = 1;
				java.util.Calendar cal = java.util.Calendar.getInstance();
				age += cal.get(java.util.Calendar.YEAR) - birthYear;
				
				System.out.println("����� " + age + "���� " + gender + "�Դϴ�.");
				break;
			}
		} // while end
	} // main end
} // class end
