package com.bit.day27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Ex04InputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			is = new FileInputStream("test01.txt");
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			osw = new OutputStreamWriter(System.out);
			bw = new BufferedWriter(osw);
			pw = new PrintWriter(bw);
			
			String msg = null;
			while((msg = br.readLine()) != null) {
				pw.println(msg);
			}
			
//			String msg = null;
//			while((msg = br.readLine()) != null) {
//				bw.write(msg);
//				bw.write("\n");
//			}
			
//			String msg = null;
//			while((msg = br.readLine()) != null) {
//				osw.write(msg);
//				osw.write("\n");
//			}
			
//			String msg = null;
//			while((msg = br.readLine()) != null) {
//				System.out.println(msg);
//			}
			
			char[] cbuf = new char[3];
			
//			int su = -1;
//			while((su = isr.read(cbuf)) != -1) {
//				System.out.println(new String(cbuf, 0, su));
//			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
				if(osw != null) {
					osw.close();
				}
				if(isr != null) {
					isr.close();
				}
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
