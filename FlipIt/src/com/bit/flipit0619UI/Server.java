package com.bit.flipit0619UI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		int port = 6030;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			while(true) {
				Socket socket = server.accept();
				new ServerProcessor(socket);
				System.out.println(socket.getInetAddress().getHostAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(server != null) {
					server.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
