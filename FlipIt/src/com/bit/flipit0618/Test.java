package com.bit.flipit0618;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		
//		new Socket().get
		
		System.out.println(list.size());
		System.out.println(list.get(0));
		list.remove("A");
		System.out.println(list.size());
		System.out.println(list.get(0));
		
		String a = "123 : ";
		String[] b = a.split(" : ");
		System.out.println(b.length);
		
		int[] c = new int[]{1 , 2, 3, 2, 1};
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter br = null;
		os = System.out; 
		osw = new OutputStreamWriter(os);
		br = new BufferedWriter(osw);
		try {
			br.write(Arrays.toString(c).toCharArray());
			br.newLine();
			br.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(osw != null) osw.close();
				if(os != null) os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("end");
	}

}
