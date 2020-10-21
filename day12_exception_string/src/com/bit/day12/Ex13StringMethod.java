package com.bit.day12;

public class Ex13StringMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg1 = "Java";
		String msg2 = "Web";
		String msg3 = msg1.concat(msg2);
		System.out.println(msg3);
		String msg4 = msg3.substring(msg1.length());
		msg4 = "JavaWebSpring";
		String msg5 = msg4.substring(4);
		System.out.println(msg5);
		String msg6 = msg4.substring(4, 7);
		System.out.println(msg6);
		String msg7 = msg4.substring(0, 4);
		System.out.println(msg7);
		String msg8 = msg4.substring(4, msg4.length());
		System.out.println(msg8);
		
		String msg9 = msg4.replace("Web", msg1);
		System.out.println(msg9);
		String msg10 = msg4.replace("Web", "");
		System.out.println(msg10);
		String msg11 = msg4.replace("W", "w");
		System.out.println(msg11);
		String msg12 = msg4.replace("Java", "");
		System.out.println(msg12);
		
		char ch = msg4.charAt(0);
		System.out.println(ch);
		
		int idx = msg4.indexOf('a');
		System.out.println(idx);
		idx = msg4.indexOf('a', 2);
		System.out.println(idx);
		idx = msg4.indexOf("Spr", 2);
		System.out.println(idx);
		
		String msg13 = msg4.substring(msg4.indexOf("Web") + "Web".length());
		System.out.println(msg13);
		
		String msg14 = msg4.substring(0 + msg4.indexOf("Web"));
		System.out.println(msg13 + "DB" + msg14);

		msg13 = msg4.substring(msg4.indexOf("Java") + "Java".length());
		System.out.println(msg13);
		
		String msg15 = msg4.replace("a", "A");
		System.out.println(msg15);
		
		String msg16 = msg4.substring(msg4.indexOf('a') + 1);
		String msg17 = msg4.substring(0, msg4.indexOf('a'));
		System.out.println(msg17 + 'A' + msg16);

	}

}
