package com.bit.day11;

public class Lec01 {

	// public > protected >= default > private
	//	protected: default와 같으나 상속을 통한 접근만 허용
	
	protected void func01() {
		System.out.println("Lec01 func01() runs");
	}
	
	protected Lec01() {}
	
	protected int su;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
