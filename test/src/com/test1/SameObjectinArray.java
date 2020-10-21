package com.test1;

import java.util.ArrayList;
import java.util.Arrays;

class Person {
	String name;
	public Person(String name) {
		this.name = name;
	}
}
public class SameObjectinArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] x = new Person[4];
		Person o1 = new Person("Jun");
		Person o2 = new Person("Tom");
		Person o3 = new Person("Jessie");
		x[0] = o1;
		x[1] = o2;
		x[2] = o3;
		o1.name = "Park";
		x[3] = o1;
		for(Person i : x) System.out.println(i.name);
		
		ArrayList<Person> y = new ArrayList<>();
		y.add(o1);
		y.add(o2);
		y.add(o3);
		o1.name = "Jun";
		y.add(o1);
		for(int i = 0; i < y.size(); i++) {
			System.out.println(y.get(i).name);
		}
		System.out.println(x[3].name);
	}

}
