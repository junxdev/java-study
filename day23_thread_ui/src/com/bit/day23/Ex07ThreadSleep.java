package com.bit.day23;

public class Ex07ThreadSleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss");
		for(int i = 0; i < 10; i++) {
			java.util.Date date = new java.util.Date();
			String msg = sdf.format(date);
			System.out.println(msg);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
