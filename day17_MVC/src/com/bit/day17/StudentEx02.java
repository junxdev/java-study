package com.bit.day17;

public class StudentEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ArrayList<StudentVO> list = new java.util.ArrayList<>();
		
		// <> : Template
		// ���ø��̶� �ش� ��ü�� ���� Ŭ������ �������� ����
		// ���ø� �ȿ��� Ŭ������ �Է� ����
		// Collection Framework�� �ּҰ��� �̿��ϱ� �빮�� �ּҰ��� �������� �ʴ� �⺻�� �����ʹ� ��� �Ұ�
		// �⺻�� �����͸� ����Ϸ��� Wrapper Ŭ���� Ȱ��
		
		// �⺻ equals �޼���� return this == 0;�̱� ������ �������ϴ� ���� �߿�
		
		// ArrayList�� ũ�Ⱑ ����
		
		StudentVO s = new StudentVO();
		StudentVO s1 = new StudentVO();
		StudentVO s2 = new StudentVO();
		
		System.out.println("list ũ�� : " + list.size());
		list.add(s);
		s.setName("kuni");
		System.out.println("list ũ�� : " + list.size());
		list.add(s1);
		s1.setName("jerry");
		System.out.println("list ũ�� : " + list.size());
		list.add(s2);
		s2.setName("el");
		System.out.println("list ũ�� : " + list.size());
		list.add(s2);
		System.out.println("list ũ�� : " + list.size());
		
		// ������ ȣ���� get
		System.out.println("index 2�� student�� getName(): " + list.get(2).getName());
		System.out.println("index 2�� student�� getName(): " + list.get(3).getName());
		
		System.out.println("index 2�� s2�� indexOf(): " + list.indexOf(s2));
		System.out.println("index 2�� s2�� indexOf(): " + list.lastIndexOf(s2));
		System.out.println("index 2�� s2�� indexOf(): " + list.contains(s1));
		
		list.remove(1);
		System.out.println("list ũ�� : " + list.size());
		list.remove(s2);
		System.out.println("list ũ�� : " + list.size());
		System.out.println("index 2�� s2�� indexOf(): " + list.contains(s1));
		System.out.println("index 2�� s2�� indexOf(): " + list.lastIndexOf(s2));
	}

}
