package com.bit.flipit0617;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientF2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String address = "127.0.0.1";
		int port = 6030;
		Socket socket = null;
		
		try {
			socket = new Socket(address, port);
			if(socket.isConnected()) {
				System.out.println(socket.getLocalSocketAddress());
				new ClientApp(socket);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
