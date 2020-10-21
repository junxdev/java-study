package com.bit.day23;

public class Ex03ThreadNoInheritance {
	
	
	public static void main(String[] args) {
		
		class Inner extends Thread {
			public void run() {
				System.out.println("thread work");
			}
		}
		
		Inner thr1 = new Inner();
		Inner thr2 = new Inner();
		thr1.start();
		thr2.start();
		
		new Thread() {
			public void run() {
				System.out.println("thread3 work");
			}
		}.start();
		
		Thread thr4 = new Thread() {
			public void run() {
				System.out.println("thread4 work");
			}
		};
		thr4.start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("thread5 work");
			}
		}).start();;
		
		Runnable work = new Runnable() {
			public void run() {
				System.out.println("work work");
			}
		};
		Thread thr6 = new Thread(work);
		thr6.start();
	}
}
