package com.bit.day12;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		�ֹι�ȣ �Է�
		java.io.BufferedReader br;
		br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		
		java.util.StringTokenizer st = null;
		
		System.out.print("�ֹε�Ϲ�ȣ �Է� >>> ");
		try {
			st = new java.util.StringTokenizer(br.readLine());
		} catch (java.io.IOException e) {
			System.out.println("�Է� ���� �߻�");
		} catch (java.lang.NullPointerException e) {
			System.out.println("�Է� ���� �߻�");
		}
		String ssn = "";
		
		while (st.hasMoreTokens()) {
			ssn = st.nextToken();
		}
		
		String gender = "����";
		if (ssn.charAt(ssn.indexOf('-') + 1) == '1' || ssn.charAt(ssn.indexOf('-') + 1) == '3') {
			gender = "����";
		}
		
		int birthYear = (ssn.charAt(0) - '0') * 10 + (ssn.charAt(1) - '0');
		int age = 1;
		if (ssn.charAt(ssn.indexOf('-') + 1) == '1' || ssn.charAt(ssn.indexOf('-') + 1) == '2') {
			age += 20 - birthYear + 100;
		} else {
			age += 20 - birthYear;
		}
		
		System.out.println("����� " + age + " ���� " + gender + "�Դϴ�");
	}

}
