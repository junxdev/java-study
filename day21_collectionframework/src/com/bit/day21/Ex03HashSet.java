package com.bit.day21;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Ex03HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet set01 = new HashSet();
		
		set01.add(9);
		set01.add(11111);
		set01.add(4444);
		set01.add(1);
		
		java.util.Iterator ite = set01.iterator(); // Vector - Enumeration, HashSet - Iterator
		System.out.println(ite.next());
		System.out.println(ite.next());
		System.out.println(ite.next());
		System.out.println(ite.next());
		System.out.println(ite.hasNext());
		
		TreeSet set02 = new TreeSet();
		set02.add(1);
		set02.add(2);
		set02.add(1);
		set02.add(2);
		Iterator<Integer> ite2 = set02.iterator();
		System.out.println(ite2.next());
		System.out.println(ite2.next());
		System.out.println(ite2.hasNext());
		
		
	}

}
