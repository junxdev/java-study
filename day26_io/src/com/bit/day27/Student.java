package com.bit.day27;

import java.io.Serializable;

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L; // write�� ������ read�� ������ �����ؾ� �Ѵ�.
	
	public static int num; // "��ü" ����ȭ�� ����� ����ʵ��̴�.
	protected int kor;
	transient int eng; // transient > �⺻��
	private int math;
	transient String name; // ��ü ����ȭ���� �����ϹǷ� IO �۾��� �̷������ �ʴ´�.
	
	public Student(int num, String name, int kor, int eng, int math) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void show() {
		System.out.println(num + "�� " + name + " : ���� " + kor + " ���� " + eng + " ���� " + math);
	}

	public String toString() {
		return num + "�� " + name + " : ���� " + kor + " ���� " + eng + " ���� " + math;
	}
	
	public long getVersion() {
		return serialVersionUID;
	}
}

