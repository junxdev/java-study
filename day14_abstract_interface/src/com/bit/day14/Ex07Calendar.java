package com.bit.day14;

import java.util.Calendar;

public class Ex07Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		java.util.Calendar cal = new java.util.Calander(); �߻� Ŭ�����̹Ƿ� ��ü ���� �Ұ���
		java.util.Calendar cal = java.util.Calendar.getInstance();
		System.out.println(cal.toString());
		
		System.out.println(cal.get(0)); // �˱� ����� �ڵ庸��
		System.out.print(cal.get(Calendar.YEAR) + "��"); // ������� �ڵ� �ۼ�
		System.out.print(1 + cal.get(Calendar.MONTH) + "��"); // ���� 0 ~ 11
		System.out.print(cal.get(Calendar.DATE) + "��");
		char ch = '?';
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1: ch = '��'; break;
		case 2: ch = '��'; break;
		case 3: ch = 'ȭ'; break;
		case 4: ch = '��'; break;
		case 5: ch = '��'; break;
		case 6: ch = '��'; break;
		case 7: ch = '��'; break;
		
		default: break;
		}
		System.out.print(ch + "����");
		System.out.print("\t");
		if(cal.get(Calendar.AM) == 0) {
			System.out.print("AM");
		} else if(cal.get(Calendar.AM) == 1) {
			System.out.print("PM");
		}
		System.out.print(cal.get(Calendar.HOUR) + "��");
		System.out.print(" �Ǵ� " + cal.get(Calendar.HOUR_OF_DAY) + "��");
		System.out.print(cal.get(Calendar.MINUTE) + "��");
		System.out.print(cal.get(Calendar.SECOND) + "��");
		System.out.print(cal.get(Calendar.WEEK_OF_YEAR) + "����");
		System.out.print(cal.get(Calendar.DAY_OF_YEAR) + "����");
	}

}
