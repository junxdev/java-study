package com.bit.flipit0616;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//class serverConsole extends Frame {
//	
//	TextArea textArea = null;
//	
//	public serverConsole() {
//		// TODO Auto-generated constructor stub
//		setSize(1000, 600);
//		setLocation(200, 200);
//		setLayout(new BorderLayout());
//		
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				dispose();
//			}
//		});
//		
//		textArea = new TextArea();
//		textArea.setEditable(false);
//		textArea.setBackground(Color.BLACK);
//		textArea.setForeground(Color.WHITE);
//		add(BorderLayout.CENTER, textArea);
//		
//		setVisible(true);
//	}
//}

public class FlipItServer {

//	Socket socket;
//	String userName, firstCard, secondCard;
//	FlipItApp console;
	
//	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		console.textArea.append(socket.getInetAddress() + " has connnected 1");
//		
//		InputStream is = null;
//		InputStreamReader isr = null;
//		BufferedReader br = null;
//		OutputStream os = null;
//		OutputStreamWriter osw = null;
//		BufferedWriter bw = null;
//		
//		try {
//			is = socket.getInputStream();
//			isr = new InputStreamReader(is);
//			br = new BufferedReader(isr);
//			
//			os = socket.getOutputStream();
//			list.add(os);
//			osw = new OutputStreamWriter(os);
//			bw = new BufferedWriter(osw);
//			while(true) {
//				if(list.size() == 2) {
//					console.textArea.append("Two player has connected");
//					break;
//				}
//			}
//			is = socket.getInputStream();
//			isr = new InputStreamReader(is);
//			br = new BufferedReader(isr);
//			while(true) {
//				String userPacket = br.readLine();
//				String[] userDataArray = userPacket.split(" : ");
//				if("Name".equals(userDataArray[0])) {
//					userName = userDataArray[1];
//					console.textArea.append(socket.getInetAddress() + " : " + userName);
//				} else if("FirstCard".equals(userDataArray[0])) {
//					firstCard = userDataArray[1];
//				} else if("SecondCard".equals(userDataArray[0])) {
//					secondCard = userDataArray[1];
//				} else if("Start".equals(userDataArray[0])) {
//					Thread play = new Thread(this);							// 게임 실행
//					play.start();
//				} else if("Exit".equals(userDataArray[0])) {
//					socket.close();
//					console.textArea.append(socket.getInetAddress() + " : Exit");
//				} else {
//					console.textArea.append(socket.getInetAddress() + " : " + userPacket);
//				}
//				
//				for(int i = 0; i < list.size(); i++) {
//					OutputStream user = list.get(i);
//					osw = new OutputStreamWriter(user);
//					bw = new BufferedWriter(osw);
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				if(bw != null) bw.close();
//				if(br != null) br.close();
//				if(osw != null) osw.close();
//				if(isr != null) isr.close();
//				if(os != null) os.close();
//				if(is != null) is.close();
//				if(socket != null) socket.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 6030;
		ServerSocket server = null;
		
		ArrayList<Socket> socketArray = new ArrayList<>();
		
		try {
			 server = new ServerSocket(port);
//			 FlipItApp app = new FlipItApp();
//			 app.appendLog("asdf\n");
			 FlipItApp app = new FlipItApp();
			 Thread appThread = new Thread(app);
			 appThread.start();
			 while(true) {
				 System.out.println("working?");
				 Socket socket = server.accept(); 
				 app.addUser(socket);
				 System.out.println(socket.getInetAddress().getHostAddress());
			 }
//			 FlipItApp app = new FlipItApp();
//			 Socket socket = server.accept(); 
//			 app.addUser(socket);
//			 app.run();
//			 socket = server.accept(); 
//			 app.addUser(socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(server != null) {
					server.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
