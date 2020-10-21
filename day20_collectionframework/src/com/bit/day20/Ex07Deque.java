package com.bit.day20;

public class Ex07Deque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		java.util.Deque deq = new java.util.LinkedList();
		deq.offerFirst("1번");
		deq.offerFirst("2번");
		deq.offerFirst("3번");
		deq.offerFirst("4번");
		System.out.print(deq.toString() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.println("\n--------------------");
		deq.offerFirst("1번");
		deq.offerFirst("2번");
		deq.offerFirst("3번");
		deq.offerFirst("4번");
		System.out.print(deq.toString() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.println("\n--------------------");
		deq.offerLast("1번");
		deq.offerLast("2번");
		deq.offerLast("3번");
		deq.offerLast("4번");
		System.out.print(deq.toString() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.print(deq.pollLast() + " ");
		System.out.println("\n--------------------");
		deq.offerLast("1번");
		deq.offerLast("2번");
		deq.offerLast("3번");
		deq.offerLast("4번");
		System.out.print(deq.toString() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.print(deq.pollFirst() + " ");
		System.out.println("\n--------------------");
	}

}
