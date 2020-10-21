package com.bit.day19;

public class Answer02SSNHowToConvertCharToDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = null;
		sc = new java.util.Scanner(System.in);
		String msg = null;
		
		char[] target = {'��', '��', '��', '��', '��', '��', '��', 'ĥ', '��', '��'}; // ���Ƿ� ��Ģ�� �����.
		int age;
		char gender = '#';
		
		do {
			System.out.println("�ֹι�ȣ > ");
			msg = sc.nextLine();
			
			if(msg.length() != 14) {
				System.out.println("�Է��� �ٽ� Ȯ���ϼ���");
				continue;
			}
			if(msg.charAt(6) != '-') {
				System.out.println("������ �ٽ� Ȯ���ϼ���");
				continue;
			}
			
			int year = 0;
			try { // �ؿܿ��� Ȱ���ϴ� try catch�� Ȱ���� ����ó�� 
				year = Integer.parseInt(msg.substring(0, 2)); // ��� �⵵
			} catch(NumberFormatException e1) { // ���ڰ� �ԷµǸ�
				String temp = msg.substring(0, 2);
				char[] temp2 = new char[2];
				for(int i = 0; i < temp.length(); i++) { // ���� ���ڷ� ��ȯ�ϰ�
					char ch = temp.charAt(i);
					for(int j = 0; j < target.length; j++) {
						if(ch == target[j]) {
							temp2[i] = (char)('0' + j);
						}
					}
				}
				try {
					year = Integer.parseInt(new String(temp2)); // ���ڷ� ��ȯ
				} catch(NumberFormatException e2) {
					System.out.println("�Է��� �ٽ� Ȯ���ϼ���");
					continue;
				}
			}
			
			java.util.Date now = new java.util.Date();
			java.text.DateFormat now2 = java.text.DateFormat.getInstance();
			String result = now2.format(now);
			int nowYear = Integer.parseInt(result.substring(0, 2)); // ���� �⵵
			
			gender = msg.charAt(7); // ����
			if(gender == '1' || gender == '2' || gender == '��' || gender == '��') {
				age = 1 + ((2000 + nowYear) - (1900 + year));
			} else {
				age = 1 + (nowYear - year);
			}
			
			if(gender == '1' || gender == '3'|| gender == '��' || gender == '��') { // ����
				gender = '��';
			} else if(gender == '2' || gender == '4'|| gender == '��' || gender == '��') {
				gender = '��';
			}
			break;
		} while(true);
		sc.close();
		System.out.println("����� " + age + "�� " + gender + "���Դϴ�.");
	}

}
