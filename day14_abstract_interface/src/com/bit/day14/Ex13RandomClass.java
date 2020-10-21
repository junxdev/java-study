package com.bit.day14;

public class Ex13RandomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Random ran = new java.util.Random(new java.util.Random(231L).nextInt());
		System.out.println(Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
		System.out.println(ran.nextInt());
		System.out.println(Double.MIN_VALUE + "~" + Double.MAX_VALUE);
		System.out.println(ran.nextDouble());
		System.out.println(ran.nextInt(3)); // 0, 1, 2
		System.out.println(ran.nextInt(45) + 1); 
	}

}
