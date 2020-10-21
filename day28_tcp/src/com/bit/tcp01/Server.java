package com.bit.tcp01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 8080;
		Socket socket = null;
		ServerSocket server = null;
		OutputStream os = null;
		InputStream is = null;
		InputStreamReader isr = null;
		try {
			server = new ServerSocket(8080);
			System.out.println(
					"Server : Waiting for connection");
			
			socket = server.accept();
			System.out.println(
					"Server : Connecting");
			
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			os = socket.getOutputStream(); // 초기화
			int su = -1;
			while((su = is.read()) != -1) {
				os.write(su);
				os.flush();
			}
			System.out.println(
					"Server : Sent back message");
				
//			String msg = "Welcome!";
//			os = socket.getOutputStream(); // 초기화
//			os.write(msg.getBytes());
//			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(os != null) {
					os.close();
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
				if(server != null) {
					server.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
