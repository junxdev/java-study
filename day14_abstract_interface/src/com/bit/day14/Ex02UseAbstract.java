package com.bit.day14;

abstract class Machine {
	void on() {
		System.out.println("Turn on the instrument");
	}
	void off() { // 추상이 아니므로 상속 구현이 강제되지 않음
		System.out.println("Turn off the instrument");
	}	
	abstract void work(); // 상속 구현을 생략하지 않도록 오류를 강제하는 메서드
}

class Tv extends Machine {
	void work() {
		System.out.println("TV is working");
	}
}

class Radio extends Machine {
	void work() {
		System.out.println("Radio is working");
	}
}

class Audio extends Machine {

	@Override
	void work() {
		// TODO Auto-generated method stub
		System.out.println("Audio is working");
	}
	
}

public class Ex02UseAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		Machine remote = new Audio();
		remote.on();
		remote.work(); // 오버라이드 강제성이 없어 상속 구현해야 할 기능이 생략될 수 있음
		remote.off();
		
		Machine remote2 = null;
		while(true) {
			System.out.println("1. TV 2. Radio 3. Audio 0. Exit >>> ");
			int input = sc.nextInt();
			if(input == 1) {
				remote2 = new Tv();
			} else if (input == 2) {
				remote2 = new Radio();
			} else if (input == 3) {
				remote2 = new Audio();
			} else if (input == 0) {
				break;
			}
			remote2.on();
			remote2.work();
			remote2.off();
		}
	}

}
