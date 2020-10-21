package com.bit.day07;

class Ex03 {

	public static void main(String[] args) {

		Ex02.func01(); // direct call

		System.out.println("--------------------------");

		Ex02 ex02 = new Ex02();
		ex02.func02();

		System.out.println("--------------------------");

		Ex01.func02(); // direct call
		
		System.out.println("--------------------------");

		Ex01 ex01 = new Ex01();
		ex01.func01();

	}
}