package com.bit.tcp03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer extends Thread {

	static ArrayList<OutputStream> list
	= new ArrayList<>();
	Socket socket;
	
	public MultiServer(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		InputStream is = null;
		OutputStream os = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			InetAddress userAddress = socket.getInetAddress();
			System.out.println("New user: " + userAddress.getHostAddress());
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			os = socket.getOutputStream();
			list.add(os);
			while(true) {
				String msg = br.readLine();
				if(msg == null) {
					break;
				}
				if(msg.isEmpty()) {
					break;
				}
				for(int i = 0; i < list.size(); i++) {
					OutputStream student = list.get(i);
					osw = new OutputStreamWriter(student);
					bw = new BufferedWriter(osw);
					bw.write(userAddress.getHostAddress() + ": " + msg);
					bw.newLine();
					bw.flush();
				}
//				bw.write(userAddress.getHostAddress() + ": " + msg);
//				bw.newLine();
//				bw.flush();
			}
			System.out.println(userAddress.getHostAddress() + "has left");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
				if(br != null) {
					br.close();
				}
				if(osw != null) {
					osw.close();
				}
				if(isr != null) {
					isr.close();
				}
				if(os != null) {
					os.close();
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 8080;
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(port);
			while(true) {
				Socket socket = server.accept();
				MultiServer thr = new MultiServer(socket);
				thr.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
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
