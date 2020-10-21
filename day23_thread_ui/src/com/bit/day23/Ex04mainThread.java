package com.bit.day23;

public class Ex04mainThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " start");
		Thread thr = new Thread("Thread 1") {
			public void run() {
				System.out.println(getName() + " start");
				for(int i = 'A'; i <= 'Z'; i++) {
					System.out.print((char)i + " ");
				}
				System.out.println(getName() + " end");
			}
		};
		thr.start();
		System.out.println(Thread.currentThread().getName() + " end");
	}

}
