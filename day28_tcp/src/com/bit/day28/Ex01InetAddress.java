package com.bit.day28;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex01InetAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "naver.com"; // localhost == 127.0.0.1;
		InetAddress addr01 = null;
		
		try {
			addr01 = InetAddress.getByName(url);
			System.out.println(addr01.getHostName());
			System.out.println(addr01.getHostAddress());
			System.out.println("----------------------------------------");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InetAddress[] all = null;
		try {
			all = addr01.getAllByName(url);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}

}
