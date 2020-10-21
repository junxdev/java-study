package com.bit.day14;

abstract class Machine {
	void on() {
		System.out.println("Turn on the instrument");
	}
	void off() { // �߻��� �ƴϹǷ� ��� ������ �������� ����
		System.out.println("Turn off the instrument");
	}	
	abstract void work(); // ��� ������ �������� �ʵ��� ������ �����ϴ� �޼���
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
		remote.work(); // �������̵� �������� ���� ��� �����ؾ� �� ����� ������ �� ����
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
