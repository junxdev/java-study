package com.bit.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 80;
		ServerSocket serv = null;
		Socket sock = null;
		OutputStream os = null;
		PrintStream ps = null;
		
		try {
			serv = new ServerSocket(port);
			sock = serv.accept();
			os = sock.getOutputStream();
			ps = new PrintStream(os);
			
			ps.println("HTTP/1.1 200 OK \r\n");
			
			ps.println("<p>print ok</p>");
			ps.println("<h1>print ok</h1>");
			ps.println("<h2>print ok</h2>");
			ps.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(os != null) os.close();
				if(sock != null) sock.close();
				if(serv != null) serv.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
