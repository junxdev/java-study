package com.bit.day19;

public class Answer01SSNHowToConvertCharToDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = null;
		sc = new java.util.Scanner(System.in);
		String msg = null;
		
	
		
		char[] origin = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] target = {'��', '��', '��', '��', '��', '��', '��', 'ĥ', '��', '��'}; // ���Ƿ� ��Ģ�� �����.
		char gender = '#';
		int age;
		
		while(true) {
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
			for(int i = 0; i < msg.length(); i++) {
				if(i == 6) {continue;}
				if(!Character.isDigit(msg.charAt(i))) {
	//				for(int j = 0; j < target.length; j++) {
	//					if(msg.charAt(i) == target[j]) {
	//						msg = msg.replace(msg.charAt(i), origin[j]); // �� ����̸� 9�� replace�ϸ� ��
	//						break;
	//					}
	//				}
					for(int j = 0; j < target.length; j++) {
						if(msg.charAt(i) == target[j]) {
							String before = msg.substring(0, i);
							String after = msg.substring(i + 1);
							msg = before + origin[j] + after;
							break;
						}
					}
				}
			}
			boolean boo = false;
			for(int i = 0; i < msg.length(); i++) {
				if(i == 6) {continue;}
				if(!Character.isDigit(msg.charAt(i))) {
					boo = true;
					break;
				}
			}
			if(boo) {
				System.out.println("���ڰ� �ƴ� �Է��� �ֽ��ϴ�.");
				continue;
			}
			
			int year = Integer.parseInt(msg.substring(0, 2)); // ��� �⵵
			
			java.util.Date now = new java.util.Date();
			java.text.DateFormat now2 = java.text.DateFormat.getInstance();
			String result = now2.format(now);
			int nowYear = Integer.parseInt(result.substring(0, 2)); // ���� �⵵
			
			gender = msg.charAt(7); // ����
			if(gender == '1' || gender == '2') {
				age = 1 + ((2000 + nowYear) - (1900 + year));
			} else {
				age = 1 + (nowYear - year);
			}
			
			if(gender == '1' || gender == '3') { // ����
				gender = '��';
			} else if(gender == '2' || gender == '4') {
				gender = '��';
			}
			break;
		}
		sc.close();
		System.out.println("����� " + age + "�� " + gender + "���Դϴ�.");
	}

}
