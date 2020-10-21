package com.bit.day25;

import java.io.IOException;
import java.io.OutputStream;

public class Ex05OutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputStream out = System.out;
		try {
			out.write(176);
			out.write(161);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
