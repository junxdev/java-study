package com.bit.day21;

import java.util.ArrayList;
import java.util.Vector;

public class Ex02VectorCapacity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector vec1 = new Vector();
		System.out.println(vec1.capacity());
		for(int i = 0; i < 11; i++) {
			vec1.addElement(i);
		}
		System.out.println(vec1.capacity());
		
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		Vector vec2 = new Vector(list);
		System.out.println(vec2.capacity());
		
		Vector vec3 = new Vector(3, 2); // capacity increment를 임의로 제어할 수 있어 서버 등에서 효율적
		System.out.println(vec3.capacity());
		
		for(int i = 0; i < 4; i++) {
			vec3.addElement(i);
		}
		System.out.println(vec3.capacity());
		
	}

}
