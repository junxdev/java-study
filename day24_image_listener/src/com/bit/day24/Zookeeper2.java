package com.bit.day24;

abstract class Animal2 {
	abstract public String getFood();
}

class Tiger2 extends Animal2 {
	
	@Override
	public String getFood() {
		// TODO Auto-generated method stub
		return "Apple";
	}
	
}

class Lion2 extends Animal2 {
	
	@Override
	public String getFood() {
		// TODO Auto-generated method stub
		return "Banana";
	}
	
}
public class Zookeeper2 {
	
	public static void test(Object a) {
		System.out.println(a.getClass());	
	}

	static void feed(Animal2 animal) {
		System.out.println(animal.toString());
		System.out.println("feed " + animal.getFood());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Zookeeper2.feed(new Tiger2());
		Zookeeper2.feed(new Lion2());
		
		test(new String("3242"));
		test(1234);
	}

}
