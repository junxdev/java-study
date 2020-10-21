package com.bit.day24;

class Animal {
	String name;
	String food = "orange";
	
	void setName(String name) {
		this.name = name;
	}
	
	void getFeed(Animal animal) {
		System.out.println("Eat " + animal.food);
	}
}

class Tiger extends Animal implements Predator{
	String food = "apple";
	
	Tiger() {
		super.food = food;
	}

	@Override
	public String getFood() {
		// TODO Auto-generated method stub
		return "apple";
	}
}

class Lion extends Animal implements Predator{
	String food = "banana";

	Lion() {
		super.food = food;
	}
	
	@Override
	public String getFood() {
		return "banana";
	}
}

interface Predator {
	final String food = "orange";
	public String getFood();
}

public class Zookeeper {

	public void feed(Animal animal) {
		System.out.println("Feed " + animal.food);
	}
	public void feedAgain(Predator predator) {
		System.out.println("Feed " + predator.getFood());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Animal().getFeed(new Tiger());
		new Animal().getFeed(new Lion());
		
		new Zookeeper().feed(new Tiger());
		new Zookeeper().feed(new Lion());
		
		new Zookeeper().feedAgain(new Tiger());
		new Zookeeper().feedAgain(new Lion());
		
	}

}
