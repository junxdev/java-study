package com.bit.day17;
// Student Ŭ������ �ʵ带 �����ϴ� �κ�
// java.lang.Object �޼ҵ带 �������̵��ϴ� �޼ҵ常 ����
// �̷��� �����͸� ����ϴ� 'Ʋ'�� Value Object or Data Transfer Object Ŭ������� �θ�

// �ܺο��� �� �˾ƾ� �ϴ� �޼��尡 �ƴ϶�� private���� ��ȣ
// ��� �ܺο��� ������ �Ұ����ϱ� ������ �޼��带 Ȱ���ؼ� ���� �а� ���� �� : ĸ��ȭ
public class StudentVO {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int id;
	
	
	// ���� ���� �޼��� : setter
	// ���� �д� �޼��� : getter
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// ��� Ŭ������ ���� �����ε��� �� ������ �������� ���
	public boolean equals(Object o) {
		// 2���� ��ü ��
		// 1. 2���� ��ü�� ���� Ŭ���� ��ü���� Ȯ��
		// 2. 1���� �����Ǿ��ٸ� �ش� Ŭ������ �ʵ� �� Ư�� �ʵ� Ȥ�� ��� �ʵ带 ���ؼ� ������ 2���� ���� ��ü
		
		// 1. �Ű����� o�� null�� �ƴ϶� StudentVO Ŭ������ ��ü���� Ȯ��
		if(o instanceof StudentVO) {
			// �� ������ true��� o�� StudentVO�� ��ü��� �ǹ�
			// ������ Object Ÿ���̱� ������ ����� ����ȯ�� ���� StudentVO�� ��ȯ
			StudentVO s = (StudentVO)o;
			if(id == s.id) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "�й� : " + id + ", �̸� : " + name + ", ���� : " + kor + ", ���� : " + eng
				+ ", ���� : " + math;
	}
	
}
