package com.bit.day27;

class Lec08 extends Thread {
	int tot;
	
	public void run() {
		synchronized (this) { // key로 인해 main은 대기
			for(int i = 0; i < 50; i++) {
				System.out.println(i + "를 더합니다.");
				tot += i;
			
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notify(); // wait 중 하나를 runnable로 만든다.
//			notifyAll(); // 모든 wait을 runnable로 만든다.
		}
	}
}

public class Ex08ThreadSyncWait {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lec08 lec = new Lec08();
		lec.start();
		
		synchronized (lec) { // key로 인해 main은 대기
				try {
				lec.wait(200);
				System.out.println("wait over");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("tot : " + lec.tot);
	}

}
