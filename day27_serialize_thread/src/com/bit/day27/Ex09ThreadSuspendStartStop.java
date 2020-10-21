package com.bit.day27;

class Lec09 extends Thread {
	int tot;
	
	public void run() {
		System.out.println(getName() + " start");
		for(int i = 0; i < 5; i++) {
			System.out.println("plus " + i);
			tot += i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " end");
	}
}

public class Ex09ThreadSuspendStartStop {
	
	public static void toggle(Lec09 lec) {
		if(lec.getState() == Thread.State.NEW) {
			System.out.println("start!");
			lec.start();
		} else if(lec.getState() == Thread.State.RUNNABLE) {
			System.out.println("suspend!");
			lec.suspend();
//			try {
//				System.out.println("sleep!");
//				lec.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		} else if(lec.getState() == Thread.State.TIMED_WAITING) {
			System.out.println("stop!");
			lec.stop();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lec09 lec = new Lec09();
		
		lec.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		toggle(lec);
		toggle(lec);
		toggle(lec);
		
//		lec.start();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		lec.suspend();
//		System.out.println("suspend");
//		try {
//			for(int i = 0; i < 5; i++) {
//				System.out.println("It has been suspended for " + (i + 1) + " seconds");
//				Thread.sleep(1000);
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		lec.resume();
//		System.out.println("resume");
//		try {
//			Thread.sleep(2000);
//			System.out.println("Hi!");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		lec.stop();
//		System.out.println("stop");
		
	}

}
