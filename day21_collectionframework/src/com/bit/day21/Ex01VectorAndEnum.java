package com.bit.day21;

public class Ex01VectorAndEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Vector vec01 = new java.util.Vector();
		vec01.addElement("1��");
		vec01.addElement("2��");
		vec01.addElement("3��");
		vec01.addElement("4��");
		
		vec01.insertElementAt("2.5��°", 2);
		vec01.removeElementAt(4);
		
		vec01.removeElement("3��");
		
		java.util.Enumeration em = vec01.elements();

		while(em.hasMoreElements()) {
			System.out.println(em.nextElement()); // Enumeration���� �ϳ��� �����ϸ� ����
		}
		System.out.println(em.hasMoreElements());
		
		java.util.Enumeration em2 = vec01.elements();
		while(em2.hasMoreElements()) {
			System.out.println(em2.nextElement());
		}
	}

}
