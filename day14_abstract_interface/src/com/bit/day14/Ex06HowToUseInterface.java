package com.bit.day14;

interface Remote {
	void on();
	void off();
	void work();
}
class Tv2 implements Remote {
	public void on() {
		System.out.println("전원 공급");
	}
	public void off() {
		System.out.println("전원 차단");
	}
	public void work() {
		System.out.println("화면 표시");
	}
}
class Radio2 implements Remote {
	public void on() {
		System.out.println("배터리 전원 공급");
	}
	public void off() {
		System.out.println("배터리 전원 차단");
	}
	public void work() {
		System.out.println("전파 송신");
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
