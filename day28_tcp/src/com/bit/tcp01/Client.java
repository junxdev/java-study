package com.bit.tcp01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "127.0.0.1"; // Localhost
		int port = 8080;// ~2000은 이미 약속된 번호
		Socket socket = null;
		InputStream is = null;
		InputStreamReader isr = null;
		OutputStream os = null;
		try {
			socket = new Socket(ip, port);
			System.out.println(
					"Client : Has connected to the server");
			
//			String msg = "I'm here!";
			os = socket.getOutputStream();
			is = socket.getInputStream(); // 초기화
			isr = new InputStreamReader(is);
			os.flush();
			
			int su = -1;
			os.write(System.in.read());
			while((su = isr.read()) != -1) {
				os.write(System.in.read());
				System.out.print((char)su);
				System.out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(os != null) {
					is.close();
				}
				if(isr != null) {
					isr.close();
				}
				if(is != null) {
					is.close();
				}
				if(socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
