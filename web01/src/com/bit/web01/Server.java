package com.bit.web01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server extends Thread{
	
	Socket socket;
	
	public Server(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		FileInputStream fis = null;
		File file = null;
		try {
			SocketAddress address = socket.getRemoteSocketAddress();
//			System.out.println(address.toString());
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String request = br.readLine();
			System.out.println(address.toString() + " : " + request);
			os = socket.getOutputStream();
			////////////////////////////////////
			// Header : ~ \r\n\r\n
			os.write("HTTP/1.1 200 OK \r\n".getBytes()); // Code 200 : OK
			os.write("Content-type: text/html; charset=utf-8 \r\n\r\n".getBytes()); // Code 200 : OK
			os.write("\r\n".getBytes()); // Code 200 : OK
			// Body : \r\n\r\n ~
//			File file = new File("www/page1.txt");
			String[] urlArray = request.split(" ");
			String url = urlArray[1];
			if(url.equals("/")) {
				url = "/main/main.txt";
			}
			file = new File("www" + url);
			fis = new FileInputStream(file);
			int data = -1;
			while((data = fis.read()) != -1) {
				os.write(data);
			}
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
				if(os != null) os.close();
				if(br != null) br.close();
				if(isr != null) isr.close();
				if(is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int port = 8080;
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(port);
			while(true) {
				Socket socket = server.accept();
				Server thread = new Server(socket);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(server != null) server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
