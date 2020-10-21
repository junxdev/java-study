package com.bit.day27;

public class Ex10ThreadByIf extends Thread {
	boolean end = false;
	boolean running;
	int cnt;
//	
//	public void run() {
//		System.out.println("check");
//		while(!end) {
//			cnt++;
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if(running) {
//				if("Thread-0".equals(getName())) {
//					if(cnt < 20) {
//						Thread.yield(); // Runnable 상태로 복귀
//					}
//				}
//				System.out.println(getName() + " 출력 " + cnt);
//			}
//		}
//	}
	
	public void run() {
		while(!end) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(running) {
				System.out.println(getName() + " 출력 " + cnt++);
			} else {
				Thread.yield();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex10ThreadByIf me = new Ex10ThreadByIf();
		Ex10ThreadByIf you = new Ex10ThreadByIf();
		me.start();
		you.start();
		try {
			System.out.println("대기 1");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		me.running = false;
		you.running = true;
		try {
			System.out.println("대기 2");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		you.end = true;
		me.running = true;
		try {
			System.out.println("대기 3");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		me.end = true;
	}

}
