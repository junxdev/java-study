package com.bit.flipit0617;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

class ServerProcessor extends Frame implements ActionListener  {
	
	List<OutputStream> users = null;
	List<String> userIDs = null;
	
	Socket socket = null;
//	String packet = null;

	String userID = null;
	String userName = null;
	
	int cardPanelRows = 4;
	int cardPanelColumns = 4;
	String[] cardDeck = null;
	String cardData = null;
	int timeCount = 0;
	
	TextArea log = null;
	TextField tf = null;
	Button sendButton = null;
	
//	ServerConsole serverConsole = null;
	
//	public class ServerConsole extends Frame implements ActionListener {
//		
//		public ServerConsole() {
//			// TODO Auto-generated constructor stub
//
//			setSize(600, 600);
//			setLocation(200, 200);
//			setTitle("Server");
//			setLayout(new BorderLayout());
//			
//			addWindowListener(new WindowAdapter() {
//				@Override
//				public void windowClosing(WindowEvent e) {
//					// TODO Auto-generated method stub
//					dispose();
//				}
//			});
//			
//			log = new TextArea();
//			add(BorderLayout.CENTER, log);
//			
//			tf = new TextField();
//			add(BorderLayout.PAGE_END, tf);
//			sendButton = new Button("send");
//			sendButton.addActionListener(this);
//			add(BorderLayout.LINE_END, sendButton);
//			setVisible(true);
//		}
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			if(sendButton.equals(e.getSource())) {
//				String msg = tf.getText();
//				sendToUsers("Server : " + msg);
//				tf.setText("");
//			}
//		}
//	}
	
//	public ServerProcessor() {
//		
//	}
	
	public ServerProcessor(Socket socket, List users, List userIDs) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.users = users;
		this.userIDs = userIDs;
		
		setSize(600, 600);
		setLocation(200, 200);
		setTitle("Server");
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		log = new TextArea();
		add(BorderLayout.CENTER, log);
		
		tf = new TextField();
		add(BorderLayout.PAGE_END, tf);
		sendButton = new Button("send");
		sendButton.addActionListener(this);
		add(BorderLayout.LINE_END, sendButton);
		setVisible(true);
		
		
		new Receiver(socket).start();
		new Operator().start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(sendButton.equals(e.getSource())) {
			String msg = tf.getText();
			sendToUser("Server : " + msg);
			tf.setText("");
		}
	}
	
//	public ServerProcessor(Socket socket, List users, ServerConsole serverConsole) {
//		// TODO Auto-generated constructor stub
//		this.socket = socket;
//		this.users = users;
//		this.serverConsole = serverConsole;
//		new Receiver(socket).start();
//	}
	
	public void addUser(String userName, String userID) {
		try {
			this.userName = userName;
			userIDs.add(userID);
			this.userID = userID;
			users.add(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeUser(Socket socket) {
		try {
			users.remove(userID);
			users.remove(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printLog(String string) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		synchronized (dateFormat) {
			log.append("[" + dateFormat.format(new Date()) + "] " + string + "!\n");
//		}
		revalidate();
	}
	
	public void sendToUser(String string) {
		printLog("Sent / " + string);
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			for(int i = 0; i < users.size(); i++) {
				os = users.get(i);
//				os = socket.getOutputStream();
				osw = new OutputStreamWriter(os);
				bw = new BufferedWriter(osw);
				
				bw.write(string);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendToUser(int i, String string) {
		printLog("Sent / " + string);
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			os = users.get(i);
//			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
			bw.write(string);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
				String packet = br.readLine();
				String[] data = packet.split(" : ");
				if("startButton".equals(data[0])) {
					printLog("startButton clicked");
					addUser(data[1], data[2]);
					setTitle("Server by " + userID);
					sendToUser("inGame : Welcome! " + userName);
					printLog(socket.getRemoteSocketAddress() + "@" + userName + " has joined. "
							+ "Current user number is " + users.size());
				} else if("exitButton".equals(data[0])) {
					printLog("exitButton clicked");
					printLog(socket.getInetAddress().getHostAddress() + " : " + data[1] + " has left");
					sendToUser("Terminate : " + userName + " has left");
					removeUser(socket);
					break;
				} 
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
	
	class Operator extends Thread {
		
		public synchronized void createDeck(int a, int b) {
			cardDeck = new String[a * b];
			for(int i = 0; i < cardDeck.length; i++) {
				cardDeck[i] = "" + ((i / 2) + 1); 
			}
		}
		
		public void waitOpposite(int count) {
			printLog("Waiting for game for " + count + "s");
			sendToUser(0, "waitOpposite() : " + count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void shuffle() {											// 카드 16장의 위치와 정답 여부를 초기화하고 섞는 메서드	
			Random random = new Random();
			for(int i = 0; i < 100; i++) {								// 0번 카드와 임의의 카드의 위치를 1000번 바꾼다
				int randomIndex = random.nextInt
						(cardPanelRows * cardPanelColumns - 1) + 1;
				String randomCard = cardDeck[0];
				cardDeck[0] = cardDeck[randomIndex];
				cardDeck[randomIndex] = randomCard;
			}
			cardData = "";
			for(int i = 0; i < cardDeck.length; i++) {
				cardData += cardDeck[i];
			}
			printLog(cardData);
			sendToUser("shuffle() : " + cardData);
		}
		
		public void setOppositeName() {
			sendToUser("setOppositeName() : " + userID + "@" + userName);
		}
		
		public void countdown(int count) {
			while(count < 5) {
				if(userID != userIDs.get(0)) {
					sendToUser("countdown() : " + userID + "@" + count);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count++;
				}
			}
		}
		
		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			createDeck(cardPanelRows, cardPanelColumns);
			timeCount = 0;
			while(userIDs.size() < 2) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(userName != null) {
					if(userIDs.size() == 0) continue;
					if(!userID.equals(userIDs.get(0))) {
						continue;
					}
					shuffle();
					waitOpposite(timeCount);
					timeCount++;
				}
			}
			setOppositeName();
			shuffle();
			sendToUser("Flip : ");
			timeCount = 0;
			countdown(timeCount);
			printLog("Start");
			boolean turn = false;
			while(true) {
				
				if(turn) {
					sendToUser(0, "yourTurn() : ");
					sendToUser(1, "notYourTurn() : ");
				} else {
					sendToUser(0, "notYourTurn() : ");
					sendToUser(1, "yourTurn() : ");
					
				}
				turn = !turn;
			}
		}
	}
	
	class Receiver extends Thread {
		
		Socket socket; 
		
		public Receiver(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			printLog("New user just has connected");
			receive();
		}
	}

}

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 6030;
		ServerSocket server = null;
		List<OutputStream> users = new ArrayList<>();
		List<String> userIDs = new ArrayList<>();
//		ServerProcessor.ServerConsole serverConsole = null;
		try {
			server = new ServerSocket(port);
//			serverConsole = new ServerProcessor().new ServerConsole();
			while(true) {
				Socket socket = server.accept();
				new ServerProcessor(socket, users, userIDs);
//				new ServerProcessor(socket, users, serverConsole);
				System.out.println(socket.getInetAddress().getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
