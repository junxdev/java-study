package com.bit.day08; 
 
class Ex04 { 
	static int su2 = 1234;
	int su = 1234;

	public void plus() {
		su++;
	}

	public void func01() {
		System.out.println("func01 su = " + su);
	}
 
	public static void main(String[] args) { 

		Ex04 me = new Ex04(); // 객체 선언

		me.func01(); //1234
		me.plus(); //1235
		me.func01(); //1235
		me.plus(); //1236
		me.func01(); //1236

		me = new Ex04(); //새로운 객체 선언; 1234

		me.plus(); //1235
		me.func01();  //1235
 
	} // main end 
 
} // class end 
