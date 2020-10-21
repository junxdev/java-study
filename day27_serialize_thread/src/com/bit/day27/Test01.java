package com.bit.day27;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = null;
		String msg = "오류 확인용 스트링 메시지";
		byte[] cbuf = new byte[2];
		try {
			in = new java.io.ByteArrayInputStream(msg.getBytes());
			while(true) {
				int num = in.read(cbuf);
				if(num == -1) {
					break;
				}
				System.out.print(Arrays.toString(cbuf) + " ");
				System.out.println(new String(cbuf, 0, num));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
