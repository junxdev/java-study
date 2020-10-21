package com.bit.game;

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

class User {
	OutputStream os = null;
	String userID = null;
	String userName = null;
	int userScore = 0;
	String[] flippedCards = null;
	boolean play = false;
	
	User(Socket socket, String userName, String userID) {
		try {
			this.os = socket.getOutputStream();
			this.userName = userName;
			this.userID = userID;
			flippedCards = new String[2];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ServerProcessor extends Frame implements ActionListener  {
	
//	static List<OutputStream> userList = null;
//	static List<String> userIDList = null;
//	static List<Integer> userScoreList = null; 
	static List<User> userList = new ArrayList<User>(); 
	static List<String> pairList = new ArrayList<String>();
	
	Socket socket = null;
//	String packet = null;

	Receiver receiver = null;
	Operator operator = null;
	
	User user = null;
//	String userID = null;
//	String userName = null;
	
	int cardPanelRows = 4;
	int cardPanelColumns = 4;
	String[] cardDeck = null;
	String cardData = null;
	int timeCount = 0;
	
	static boolean gameOver = false;
	boolean gameSet = false;
	boolean countdownBreak = false;
	boolean threadTurn = false;
	
	TextArea log = null;
	TextField textField = null;
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
	
//	public ServerProcessor(Socket socket, List users, List userIDs) {
	public ServerProcessor(Socket socket) {
//	public ServerProcessor(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
//		userList = new ArrayList<>();
//		userIDList = new ArrayList<>();
//		this.userList = users;
//		this.userIDList = userIDs;
		
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
		
		textField = new TextField();
		add(BorderLayout.PAGE_END, textField);
		sendButton = new Button("send");
		sendButton.addActionListener(this);
		add(BorderLayout.LINE_END, sendButton);
		setVisible(true);
		
		receiver = new Receiver(socket);
		receiver.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(sendButton.equals(e.getSource())) {
			String msg = textField.getText();
			sendToUser("Server : " + msg);
			textField.setText("");
		}
	}
	
//	public ServerProcessor(Socket socket, List users, ServerConsole serverConsole) {
//		// TODO Auto-generated constructor stub
//		this.socket = socket;
//		this.users = users;
//		this.serverConsole = serverConsole;
//		new Receiver(socket).start();
//	}
	
	public void addUser(Socket socket, String userName, String userID) {
//		try {
//			this.userName = userName;
//			userIDList.add(userID);
//			this.userID = userID;
//			userList.add(socket.getOutputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		user = new User(socket, userName, userID);
//		user.userName = userName;
//		user.userID = userID;
		userList.add(user);
	}
	
	public void removeUser() {
//		try {
//			userList.remove(userID);
//			userList.remove(socket.getOutputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		userList.remove(user);
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
			for(int i = 0; i < userList.size(); i++) {
				os = userList.get(i).os;
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
			os = userList.get(i).os;
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
	
	class Operator extends Thread {
		
		public synchronized void createDeck(int a, int b) {
			cardDeck = new String[a * b];
			for(int i = 0; i < cardDeck.length; i++) {
				cardDeck[i] = "" + ((i / 2) + 1); 
			}
		}
		
		public void waitOpposite(int count) {
			printLog("Waiting for game for " + (count + 1) + "s");
			sendToUser(0, "waitOpposite() : " + (count + 1));
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
			sendToUser("setOppositeName() : " + user.userID + "@" + user.userName);
		}
		
//		public void countdown(int count) {
//			
//		}
		
//		public void inGameCountdown(int count) {
//			int methodCount = count;
//		}
		
		public void pairCheck() {
			try {
				if(user.flippedCards[0].equals(user.flippedCards[1])) {								
					user.userScore += Integer.parseInt(cardData);
					pairList.add(cardData);
					sendToUser("pairCheck() : " + cardData + " : " + user.userID + " : "  + user.userScore);
				}
			} catch(NullPointerException e) {
//				System.out.println("null");
			}
			user.flippedCards = new String[2];			
		}

		
		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			createDeck(cardPanelRows, cardPanelColumns);
			printLog("run 1");
			timeCount = 0;
			synchronized (userList) {
				printLog("run 2");
				if(userList.size() < 2) {
					printLog("run 3");
					while(userList.size() < 2) {
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						shuffle();
						waitOpposite(timeCount);
						timeCount++;
					}
				} else if(userList.size() == 2) {
					printLog("run 4");
					User tempUser = null;
					for(int i = 0; i < userList.size(); i++) {
						if(userList.get(i) == user) continue;
						tempUser = userList.get(i);
					}
					while(!tempUser.play) {
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(user == null) {
							continue;
						} else {
							if(!user.userID.equals(userList.get(0).userID)) {
								continue;
							}
							shuffle();
							waitOpposite(timeCount);
							timeCount++;
						}
					}
				}
			}
			setOppositeName();
			timeCount = 0;
			countdownBreak = false;
			printLog("run 2");
			while(!countdownBreak) {
				try {
				if(user.userID == userList.get(0).userID) {
					if(timeCount == 0) {
						shuffle();
						sendToUser("FlipBack : ");
					}
					sendToUser("countdown() : " + (5 - timeCount));
					Thread.sleep(1000);
					timeCount++;
					if(timeCount == 5) {
						sendToUser("ShowAnswer : ");
						Thread.sleep(200);
					}
				}
				Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			printLog("Start");
			threadTurn = false;
			if(userList.get(0) == user) {
				threadTurn = true;
			}
			pairList.clear();
			gameOver = false;
			while(true) {
				timeCount = 0;
				if(!threadTurn) {
					try {
						sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
				}
				for(int i = 0; i < userList.size(); i++) {
					if(userList.get(i) == user) {
						sendToUser("Turn : " + userList.get(i).userID);
					}
				}
				while(timeCount < 5) {
					if(gameOver) break;
					sendToUser("InGameCountdown : " + user.userID + " : " + (5 - timeCount));
					
					try {
						if(user.flippedCards[1] != null) {						// 조건1 : 두번째 카드까지 선택하면
							sleep(100);
							break;
						}
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
					timeCount++;
				}
				pairCheck();
				sendToUser("threadTurn : " + user.userID);
				if(pairList.size() == (cardPanelRows * cardPanelColumns) / 2) {
					sendToUser("Interrupt : " + user.userID);
					gameOver = true;
				}
				if(gameOver) break;
				threadTurn = !threadTurn;
			}
			printLog("gameover");
			if(userList.get(0) == user) {
				if(userList.get(0).userScore > userList.get(1).userScore) {
					sendToUser(0, "Win : ");
					sendToUser(1, "Lose : ");
				} else if(userList.get(0).userScore < userList.get(1).userScore) {
					sendToUser(0, "Lose : ");
					sendToUser(1, "Win : ");
				} else {
					sendToUser("Draw : ");
				}
			}
			user.play = false;
			printLog("at the end");
			
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
					addUser(socket, data[1], data[2]);
					user.play = true;
					operator = new Operator();
					operator.start();
					setTitle("Server by " + user.userID + "@" + user.userName);
					sendToUser("inGame : Welcome! " + user.userName);
					printLog(socket.getRemoteSocketAddress() + "@" + user.userName + " has joined. "
							+ "Current user number is " + userList.size());
				} else if("restartButton".equals(data[0])) {
					user.userScore = 0;
					operator = new Operator();
					operator.start();
					user.play = true;
				} else if("exitButton".equals(data[0])) {
					printLog("exitButton clicked");
					printLog(socket.getInetAddress().getHostAddress() + " : " + data[1] + " has left");
					sendToUser("Terminate : " + user.userName);
					removeUser();
					break;
				} else if("countdownBreak".equals(data[0])) {
					countdownBreak = true;
//					printLog("countdownBreak work");
				} else if("flippedCard".equals(data[0])) {
					for(int i = 0; i < userList.size(); i++) {
						if(userList.get(i) == user) {
							continue;
						}
						sendToUser(i, "flippedCardIndex : " + data[1]);
					}
					if(user.flippedCards[0] == null) {
						user.flippedCards[0] = data[2];
					} else {
						user.flippedCards[1] = data[2];
						cardData = data[2];
						operator.interrupt();
					}
				} else if("threadTurn".equals(data[0])) {
					threadTurn = !threadTurn;
					operator.interrupt();
				} else if("Interrupt".equals(data[0])) {
					operator.interrupt();
				} else if("Gone".equals(data[0])) {
					user.play = false;
					operator.stop();
				}
			}
//			dispose();
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
//		List<OutputStream> users = new ArrayList<>();
//		List<String> userIDs = new ArrayList<>();
//		List<User> userList = new ArrayList<>();
//		ServerProcessor.ServerConsole serverConsole = null;
		try {
			server = new ServerSocket(port);
//			serverConsole = new ServerProcessor().new ServerConsole();
			while(true) {
				Socket socket = server.accept();
//				new ServerProcessor(socket);
				new ServerProcessor(socket);
//				new ServerProcessor(socket, users, userIDs);
//				new ServerProcessor(socket, users, serverConsole);
				System.out.println(socket.getInetAddress().getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
