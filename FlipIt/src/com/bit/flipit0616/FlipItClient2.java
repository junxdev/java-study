package com.bit.flipit0616;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//class checkStart extends Thread {
//		
//	public void run() {
//		while(true) {
//			FlipItClient.userName = FlipItClient.clientUI.getUserName();
//			if(FlipItClient.clientUI.getUserName() != null) {
//				break;
//			}
//		}
//	}
//}

public class FlipItClient2 {
	
	FlipItClientApp clientUI;
	String userName;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String address = "127.0.0.1";
		int port = 6030;
		
		Socket socket = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			socket = new Socket(address, port);
			
			new FlipItClientApp(socket);
			
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
			bw.write(socket.getLocalAddress().getHostAddress() + " has connected!");
			bw.newLine();
			bw.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} finally {
//			try {
//				if(bw != null) {
//					bw.close();
//				}
//				if(osw != null) {
//					osw.close();
//				}
//				if(os != null) {
//					os.close();
//				}
//				if(socket != null) {
//					socket.close();
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

}
