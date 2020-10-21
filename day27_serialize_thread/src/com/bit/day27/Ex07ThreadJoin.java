package com.bit.day27;

public class Ex07ThreadJoin extends Thread {
	Ex07ThreadJoin ex07;
	
	public void setEx07(Ex07ThreadJoin me) {
		ex07 = me;
	}
	
	public void run() {
		System.out.println(getName() + " start");
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(ex07 != null) {
			try {
				ex07.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " end");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start");
		Ex07ThreadJoin me = new Ex07ThreadJoin();
		Ex07ThreadJoin you = new Ex07ThreadJoin();
		me.setEx07(you);
		you.setEx07(me);
		me.start();
		you.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			me.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		me.interrupt(); // catch block으로 이동
		System.out.println("main end");
	}

}
