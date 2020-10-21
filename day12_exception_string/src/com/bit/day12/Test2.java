package com.bit.day12;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.io.BufferedReader br;
		br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		
		java.io.BufferedWriter bw;
		bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));

		java.io.BufferedWriter b2;
		b2 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
		
		Test2 a = new Test2();
		String mat = "work?";
		try {
			bw.write(br.readLine());
			br.close();
			bw.newLine();
			bw.toString();
			bw.write("done");
			bw.flush();
			bw.close();
		} catch (java.io.IOException e) {
			System.out.println("IOException");
		}
		
		System.out.println(mat);
		Object x = new Object();
		x.toString();
		
		
	}

}
