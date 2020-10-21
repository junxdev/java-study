package com.bit.day23;

public class Ex02ThreadWithoutClass implements Runnable {
	String name;
	
	Ex02ThreadWithoutClass(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Ex02ThreadWithoutClass me = new Ex02ThreadWithoutClass("me");
		Ex02ThreadWithoutClass you = new Ex02ThreadWithoutClass("you");
		Thread thr1 = new Thread(me);
		Thread thr2 = new Thread(you);
		
		thr1.start();
		thr2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name + "Thread start");
		for(int i = 0; i < 20; i++) {
			System.out.println(name + i);
		}
		System.out.println(name + "Thread end");
	}
}
