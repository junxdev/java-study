package com.bit.day19;

public class Ex05Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitQueue queue = new BitArray();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
	}

}
