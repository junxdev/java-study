package com.bit.day20;

public class Ex08Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		java.util.Stack stack = new java.util.Stack();
		stack.push("1��");
		stack.push("2��");
		stack.push("3��");
		stack.push("4��");
		while(!stack.empty()) {
			System.out.print(stack.peek() + " ");
			stack.pop();
		}
	}

}
