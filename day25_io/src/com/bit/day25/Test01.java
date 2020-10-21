package com.bit.day25;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		byte[] insrc = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outsrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(insrc);
		output = new ByteArrayOutputStream();
		
		System.out.println("input src = " + Arrays.toString(insrc));
		
		while(input.available() > 0) {
			try {
				input.read(temp);
				output.write(temp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			outsrc = output.toByteArray();
			
			System.out.println("temp = " + Arrays.toString(temp));
			System.out.println("outsrc = " + Arrays.toString(outsrc));
		}
	}
}
