package com.test1;

import java.util.ArrayList;
import java.util.Iterator;

abstract class who {
	String name = "Jun";
	
	public abstract void dance(int i);
}

interface where {
	String place = "parking lot";
	public void build(String place);
 }

class Parent {
	String name = "parent";
	
	public void birthday() {
		System.out.println("born in 1960");
	}
	
	public void birthday(double year) {
		System.out.println("born in " + year);
	}
}

class Son extends Parent {
	String name = "son";
	
	public void birthday() {
		System.out.println("born in 1980");
	}
}

class Daughter extends Parent implements where{
	String place = "school";
	
	public void birthday(int year) {
		System.out.println("born in " + year);
	}

	@Override
	public void build(String place) {
		// TODO Auto-generated method stub
		
	}
}

class GrandSon extends Son {
	String name = "grandson";
}

class GrandGrandSon extends GrandSon {
	String name = "grandgrandson";
}

class Family<T extends Son> {
	ArrayList<T> list = new ArrayList<T>();
	T driver;
	
	void add(T person) {
		list.add(person);
	}
	
	T get(int index) {
		return list.get(index);
	}
	
	void setDriver(T person) {
		driver = person;
	}
	
	public String toString() {
		return list.toString();
	}
}

class Neighbor<T> extends Family {
	
	void add(T person) {
		list.add(person);
	}
//	
//	void add(Parent person) {
//		System.out.println("Overrided");
//	}
	
}

public class Test_Generics {
	
	static void dance(Family<? super Son> family) {
		Iterator<? super Son> ite = family.list.iterator();
		String dance = "";
		while(ite.hasNext()) {
			String person = ite.next().getClass().getSimpleName();
//			person = person.substring(person.lastIndexOf((int)'.') + 1);
			dance += person;
			if(ite.hasNext()) dance += ", ";
		}
		dance += " are dancing in the floor!";
		System.out.println(dance);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Family<Son> family = new Neighbor();
//		family = 
		family.add(new Son());
		family.add(new GrandSon());
//		family.add(new Parent());
		System.out.println(family.toString());
		dance(family);
		
		Family<? super Son> b = new Family();
		b.add(new Son());
		Family<Son> a = null;
		a = (Family<Son>)b;
		
		Parent parent = new Son();
		System.out.println(parent.name);
		
		System.out.println(new Daughter().name);
		System.out.println(new Daughter().place);
	}

}
