package com.bit.day23;

public class Ex06ThreadSleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");
	}

}
