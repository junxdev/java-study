package com.bit.flipit0618;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
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
import java.net.UnknownHostException;

class ClientWindow extends Frame implements ActionListener {
	
	Socket socket = null;
	String msg = null;
	TextArea ta;
	TextField tf;
	Button sendButton1;
	Button sendButton2;
	
	public ClientWindow(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		new receiver(socket).start();
		
		setSize(600, 600);
		setLocation(200, 200);
		setTitle("Client");
		setLayout(new BorderLayout());
		
		ta = new TextArea();
		add(BorderLayout.CENTER, ta);
		
		tf = new TextField();
		add(BorderLayout.PAGE_END, tf);
		sendButton1 = new Button("send");
		sendButton1.addActionListener(this);
		add(BorderLayout.LINE_END, sendButton1);
		sendButton2 = new Button("return");
		sendButton2.addActionListener(this);
		add(BorderLayout.LINE_START, sendButton2);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(sendButton1.equals(e.getSource())) {
			String msg = tf.getText();
			send("Send : " + msg);
		} else if(sendButton2.equals(e.getSource())) {
			String msg = tf.getText();
			send("Return : " + socket.getLocalPort());
		}
	}
	
	public void send(String string) {
		System.out.println("send action");
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
			bw.write(string);
			bw.newLine();
			bw.flush();
			tf.setText("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	class receiver extends Thread {
		
		Socket socket; 
		
		public receiver(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
		}

		public void receive() {
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			
			try {
				is = socket.getInputStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				while(true) {
					String msg = br.readLine();
					if("Terminate".equals(msg)) {
						dispose();
						break;
					}
					ta.append(msg + "\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(br != null) br.close();
					if(isr != null) isr.close();
					if(is != null) is.close();
					if(socket != null) socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			receive();
		}
	}
}
	


public class Client1 {
	
	
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
