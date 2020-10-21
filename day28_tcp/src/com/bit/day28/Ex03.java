package com.bit.day28;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("copy\\index.html");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		String path = "https://www.naver.com/";
		URL url = null;
		URLConnection conn = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		BufferedWriter bw = null;
		OutputStreamWriter osw = null;
		
		try {
			url = new URL(path);
			conn = url.openConnection();
			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			os = new FileOutputStream(file);
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
			String msg;
			while((msg = br.readLine()) != null) {			
				bw.write(msg);
//				System.out.println((char)su);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(os != null) {
					os.close();
				}
//				if(isr != null) {
//					isr.close();
//				}
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
