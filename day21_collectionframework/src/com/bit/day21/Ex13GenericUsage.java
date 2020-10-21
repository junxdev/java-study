package com.bit.day21;

class Lec13 {
	void func() {
		System.out.println("work");
	}
}

class Template {
	static <T> Box<T> newInstance(T ball) {
		Box<T> lec = new Box<T>();
		lec.push(ball);
		return lec;
	}
}

public class Ex13GenericUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<BaseBall> lec = Template.<BaseBall>newInstance(new BaseBall());
		lec.pull().play();
	}

}
