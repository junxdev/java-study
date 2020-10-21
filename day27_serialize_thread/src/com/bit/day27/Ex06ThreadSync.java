package com.bit.day27;

public class Ex06ThreadSync extends Thread {
	// 다른 Thread가 변경하는 변수가 아닐지 확인!
	static int sum; 
	int begin;
	int end;
	Object key;
//	static Object key = new Object(); 별도로 생성자에 매개변수로 하거나 main Method에서 객체를 생성할 필요 없음
	
	public Ex06ThreadSync(int begin, int end, Object key) {
		this.begin = begin;
		this.end = end;
		this.key = key;
	}
	
//	public void sum(int i) {
//		블럭 동기화 : 최대한 블럭(작업의 양)을 작게 해야 
//		다른 쓰레드 간 대기가 줄어 작업효율 향상
//		synchronized (key) { 
////			sum += i + 1;
//			int result = i + 1;
//			sum = sum + result;
//		}
////		sum += i + 1; >>> sum = sum + (i + 1); 
//		//	위 코드를 실행 중 수행과 대입까지 종료되지 않은 채 
//			다른 쓰레드에 순서를 넘길 경우 동기화 문제 발생
//	}
	
//	public static synchronized void sum(int i) { // 메서드 동기화: 별도의 mutex를 선언하지 못한다.
//		int result = i + 1;
//		sum = sum + result;
//	}

	public void sum(int i) { // 메서드 동기화: 별도의 mutex를 선언하지 못한다.
		int result = i + 1;
		sum = sum + result;
		System.out.print(""); // 여기서 Thread가 종료될 확률이 높다
	}
	
	public void run() {
		for(int i = begin; i < end; i++) {
			sum(i);
		}
	}
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i < 500; i++) {
			sum += i + 1;
		}
		for(int i = 500; i < 1000; i++) {
			sum += i + 1;
		}
		System.out.println("1 ~ 1,000까지 합계 = " + sum);
		
		Object key = new Object();
		
		Ex06ThreadSync me = new Ex06ThreadSync(0, 500, key);
		Ex06ThreadSync you = new Ex06ThreadSync(500, 1000, key);
		me.start();
		you.start();
		try {
			me.join();
			you.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("me + you = " + Ex06ThreadSync.sum);
		System.out.println("종료");
	}
}
