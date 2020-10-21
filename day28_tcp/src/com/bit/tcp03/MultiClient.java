package com.bit.tcp03;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class MultiClient extends Frame implements ActionListener {
	
	TextField tf;
	Socket socket;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw); // static main Thread에서 접근하기 위해 참조변수 me 추가
			bw.write(tf.getText());
			bw.newLine();
			bw.flush();
			tf.setText("");
			tf.setText("");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
	
	public MultiClient(Socket socket) {
		this.socket = socket;
		tf = new TextField();
		tf.addActionListener(this);
		add(tf);
		setSize(400, 80);
		setLocation(300, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "127.0.0.1";
		int port = 8080;
		Socket socket = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			socket = new Socket(ip, port);
			MultiClient me = new MultiClient(socket);
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			while(true) {
//				bw.write(sc.nextLine());
//				bw.newLine();
//				bw.flush();
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
			System.out.println(socket.getInetAddress().toString().replace("/", "") + " 퇴장");
		} finally {
			try {
				if(br != null) {
					br.close();
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
