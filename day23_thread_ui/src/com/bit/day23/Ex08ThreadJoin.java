package com.bit.day23;

public class Ex08ThreadJoin extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start");
		Ex08ThreadJoin me = new Ex08ThreadJoin();
		Ex08ThreadJoin you = new Ex08ThreadJoin();
		me.start();
		you.start();
		
		try {
			me.join();
			you.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");
	}

	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(getName() + " work " + 1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
