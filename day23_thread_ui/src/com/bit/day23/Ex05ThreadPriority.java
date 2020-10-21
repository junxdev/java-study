package com.bit.day23;

public class Ex05ThreadPriority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable work = new Runnable() {
			public void run() {
				Thread me = Thread.currentThread();
				System.out.println(me.getName() + " start");
				for(int i = 0; i <= 50; i++) {
					System.out.println(me.getName() + i + " work");
				}
				System.out.println(me.getName() + " end");
			}
		};
		
		Thread thr1 = new Thread(work, "1st");
		Thread thr2 = new Thread(work, "2nd");
		Thread thr3 = new Thread(work, "3rd");
		
		thr1.setPriority(Thread.MIN_PRIORITY);
		thr2.setPriority(Thread.NORM_PRIORITY);
		thr3.setPriority(Thread.MAX_PRIORITY);
		
		thr1.start();
		thr2.start();
		thr3.start();
	}

}
