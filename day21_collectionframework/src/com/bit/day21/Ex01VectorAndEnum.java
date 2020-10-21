package com.bit.day21;

public class Ex01VectorAndEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Vector vec01 = new java.util.Vector();
		vec01.addElement("1번");
		vec01.addElement("2번");
		vec01.addElement("3번");
		vec01.addElement("4번");
		
		vec01.insertElementAt("2.5번째", 2);
		vec01.removeElementAt(4);
		
		vec01.removeElement("3번");
		
		java.util.Enumeration em = vec01.elements();

		while(em.hasMoreElements()) {
			System.out.println(em.nextElement()); // Enumeration에서 하나씩 제거하며 인출
		}
		System.out.println(em.hasMoreElements());
		
		java.util.Enumeration em2 = vec01.elements();
		while(em2.hasMoreElements()) {
			System.out.println(em2.nextElement());
		}
	}

}
