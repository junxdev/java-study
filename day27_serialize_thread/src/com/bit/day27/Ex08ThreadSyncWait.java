package com.bit.day27;

class Lec08 extends Thread {
	int tot;
	
	public void run() {
		synchronized (this) { // key�� ���� main�� ���
			for(int i = 0; i < 50; i++) {
				System.out.println(i + "�� ���մϴ�.");
				tot += i;
			
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notify(); // wait �� �ϳ��� runnable�� �����.
//			notifyAll(); // ��� wait�� runnable�� �����.
		}
	}
}

public class Ex08ThreadSyncWait {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lec08 lec = new Lec08();
		lec.start();
		
		synchronized (lec) { // key�� ���� main�� ���
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
