package com.bit.tcp02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String ip = "127.0.0.1";
		int port = 8080;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			socket = new Socket(ip, port);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			bw = new BufferedWriter(osw);
			
			while(true) {
				bw.write(sc.nextLine());
				bw.newLine();
				bw.flush();
				String msg = br.readLine();
				if(msg == null) {
					break;
				}
				if(msg.isEmpty()) {
					break;
				}
				System.out.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println(socket.getInetAddress().toString().replace("/", "") + " Επΐε");
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

}
