package com.bit.day12;

public class Ex16StringToArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "java DB web framework";
		
		String[] arr = msg.split(" ");
		
		String msg2 = "";
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			msg2 = msg2.concat(arr[i]);
			msg2 = msg2.concat(" ");
		}
		
		System.out.println(msg2);
	}

}
