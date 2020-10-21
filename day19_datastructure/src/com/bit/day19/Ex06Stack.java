package com.bit.day19;

public class Ex06Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitStack stack = new BitArray();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
