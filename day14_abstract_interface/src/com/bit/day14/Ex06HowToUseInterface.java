package com.bit.day14;

interface Remote {
	void on();
	void off();
	void work();
}
class Tv2 implements Remote {
	public void on() {
		System.out.println("���� ����");
	}
	public void off() {
		System.out.println("���� ����");
	}
	public void work() {
		System.out.println("ȭ�� ǥ��");
	}
}
class Radio2 implements Remote {
	public void on() {
		System.out.println("���͸� ���� ����");
	}
	public void off() {
		System.out.println("���͸� ���� ����");
	}
	public void work() {
		System.out.println("���� �۽�");
	}
}
public class Ex06HowToUseInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remote remote = null;
		remote = new Tv2();
		remote.on();
		remote.work();
		remote.off();
		remote = new Radio2();
		remote.on();
		remote.work();
		remote.off();
	}

}
