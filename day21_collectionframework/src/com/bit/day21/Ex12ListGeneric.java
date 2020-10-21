package com.bit.day21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Ex12ListGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> link = new LinkedList<>();
		link.add(1234);
		link.add(2345);
		ArrayList<Number> list = new ArrayList<Number>(link); // ArrayList(Collection<? extends E> c)
		list.toArray();
	}

}
