package com.bit.tcp02;

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

public class EchoServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 한글 입력 오류 - 문자열 스트링
		// 콘솔 복잡 - 서버실행 메시지 x
		// 종료되지 않음 - null
		
		int port = 8080;
		ServerSocket server = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			server = new ServerSocket(port);
			
			socket = server.accept();
			InetAddress addressUser = socket.getInetAddress();
			String user = addressUser.getHostAddress();
			System.out.println(socket.getLocalAddress());
			System.out.println(socket.getLocalSocketAddress());
			System.out.println(socket.getLocalPort());
			System.out.println(socket.getInetAddress().getCanonicalHostName());
			System.out.println(socket.getInetAddress().getHostAddress());
			System.out.println(socket.getInetAddress().getHostName());
			is = socket.getInputStream();
			os = socket.getOutputStream();
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			bw = new BufferedWriter(osw);

			while(true) {
				String msg = br.readLine();
				if(msg == null) {
					break;
				}
				if(msg.isEmpty()) {
					break;
				}
				bw.write(user + ": " + msg);
				bw.newLine();
				bw.flush();
			}
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
