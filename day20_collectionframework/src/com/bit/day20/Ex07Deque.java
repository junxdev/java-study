package com.bit.day20;

public class Ex07Deque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		java.util.Deque deq = new java.util.LinkedList();
		deq.offerFirst("1��");
		deq.offerFirst("2��");
		deq.offerFirst("3��");
		deq.offerFirst("4��");
		System.out.print(deq.toString() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.println("\n--------------------");
		deq.offerFirst("1��");
		deq.offerFirst("2��");
		deq.offerFirst("3��");
		deq.offerFirst("4��");
		System.out.print(deq.toString() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.println("\n--------------------");
		deq.offerLast("1��");
		deq.offerLast("2��");
		deq.offerLast("3��");
		deq.offerLast("4��");
		System.out.print(deq.toString() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.println("\n--------------------");
		deq.offerLast("1��");
		deq.offerLast("2��");
		deq.offerLast("3��");
		deq.offerLast("4��");
		System.out.print(deq.toString() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.println("\n--------------------");
	}

}
