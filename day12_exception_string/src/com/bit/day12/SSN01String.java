package com.bit.day12;

public class SSN01String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String msg = null;
		
		while (true) {
			System.out.print("�ֹι�ȣ �Է�: ");
			msg = sc.nextLine();
			if (msg.length() != 14) {
				System.out.println("�ڸ����� �ٽ� Ȯ���ϼ���");
				continue;
			} else if (msg.charAt(6) != '-') {
				System.out.println("�Է������� �ٽ� Ȯ���ϼ���(000000-0000000)");
				continue;
			}
			
			boolean digitCheck = false;
			for (int i = 0; i < msg.length(); i++) {
				if (i == 6) {
					continue;
				}
				if (!(msg.charAt(i) >= '0' && msg.charAt(i) <= '9')) {
					digitCheck = true;
				}
			}
			if(digitCheck) {continue;}
			
			char year1 = msg.charAt(0);						
			char year2 = msg.charAt(1);						
			int year = (year1 - '0') * 10 + (year2 - '0');
			char gender = msg.charAt(7); 					
			
			if (gender == '3' || gender == '4') {
				System.out.print("����� " + (2020 - (2020 + year) + 1) + "�� ");
			} else if (gender == '1' || gender == '2') {
				System.out.print("����� " + (2020 - (1900 + year) + 1) + "�� ");
			}
			
			if (gender == '1' || gender == '3') {
				System.out.println("�����Դϴ�");
			} else if (gender == '2' || gender == '4') {
				System.out.println("�����Դϴ�");
			}
			break;
		}
	}

}
