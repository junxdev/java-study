package com.bit.day27;

public class Ex06ThreadSync extends Thread {
	// �ٸ� Thread�� �����ϴ� ������ �ƴ��� Ȯ��!
	static int sum; 
	int begin;
	int end;
	Object key;
//	static Object key = new Object(); ������ �����ڿ� �Ű������� �ϰų� main Method���� ��ü�� ������ �ʿ� ����
	
	public Ex06ThreadSync(int begin, int end, Object key) {
		this.begin = begin;
		this.end = end;
		this.key = key;
	}
	
//	public void sum(int i) {
//		�� ����ȭ : �ִ��� ��(�۾��� ��)�� �۰� �ؾ� 
//		�ٸ� ������ �� ��Ⱑ �پ� �۾�ȿ�� ���
//		synchronized (key) { 
////			sum += i + 1;
//			int result = i + 1;
//			sum = sum + result;
//		}
////		sum += i + 1; >>> sum = sum + (i + 1); 
//		//	�� �ڵ带 ���� �� ����� ���Ա��� ������� ���� ä 
//			�ٸ� �����忡 ������ �ѱ� ��� ����ȭ ���� �߻�
//	}
	
//	public static synchronized void sum(int i) { // �޼��� ����ȭ: ������ mutex�� �������� ���Ѵ�.
//		int result = i + 1;
//		sum = sum + result;
//	}

	public void sum(int i) { // �޼��� ����ȭ: ������ mutex�� �������� ���Ѵ�.
		int result = i + 1;
		sum = sum + result;
		System.out.print(""); // ���⼭ Thread�� ����� Ȯ���� ����
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
		System.out.println("1 ~ 1,000���� �հ� = " + sum);
		
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
		System.out.println("����");
	}
}
