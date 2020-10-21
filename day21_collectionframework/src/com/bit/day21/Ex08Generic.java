package com.bit.day21;

class Com {
	void play() {
		System.out.println("He shoot the gun.");
	}
}
class Ball {
	String color = "Black";
	void play() {
		System.out.println(color + " ball rolls");
	}
}

class BaseBall extends Ball {
	String color = "White";
	void play() {
		System.out.println("You can hit this.");
	}
}

class BowlingBall extends Ball {
	String color = "Red";
	void play() {
		System.out.println("You can not hit this. You just can roll it.");
	}
}

class Box<T> {
	private T myBall;
	
	void push(T myBall) {
		this.myBall = myBall;
	}
	
	T pull() {
		return myBall;
	}
}
public class Ex08Generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseBall newBall = new BaseBall();
		BowlingBall newBowlingBall = new BowlingBall();
		Com com = new Com();
		
		Box<BaseBall> box = new Box<BaseBall>(); // Ÿ���� �������ִ� ���׸�
		box.push(newBall);
		
		BaseBall myBall = box.pull(); // ��ü�� ��ȯ �ø��� �ش� ��ü�� �´� ĳ���� �ʿ�
		myBall.play();
		
	}

}
