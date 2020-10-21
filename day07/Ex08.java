package com.bit.day07;

class Ex08 {

	public static void main(String[] args) {

		System.out.println("main start");

		for(int i = 0; i < 10; i++) {

			if(i%2 != 0) {continue;}
			// if(i > 2) {break;}
			//if(i > 2) {return;}
			System.out.println("반복" + (i));
		}

		System.out.println("main end");

	}

}