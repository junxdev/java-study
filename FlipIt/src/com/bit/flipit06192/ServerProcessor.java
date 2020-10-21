package com.bit.flipit06192;

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
	String token = null;
	
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
	
//		static List<OutputStream> userList = null;
//		static List<String> userIDList = null;
//		static List<Integer> userScoreList = null; 
	static List<User> userList = new ArrayList<User>(); 
	static List<String> pairList = new ArrayList<String>();
	static List<String> tokenList = new ArrayList<String>();
	
	Socket socket = null;
//		String packet = null;

	Receiver receiver = null;
	Operator operator = null;
	Countdown countdown = null;
	
	
	User user = null;
//		String userID = null;
//		String userName = null;
	
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
	
	public ServerProcessor(Socket socket) {
		this.socket = socket;
		
		setSize(600, 600);
		setLocation(200, 200);
		setTitle("Server");
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
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
		if(sendButton.equals(e.getSource())) {
			String msg = textField.getText();
			sendToUser("Server : " + msg);
			textField.setText("");
		}
	}
	
	public void addUser(Socket socket, String userName, String userID) {
		user = new User(socket, userName, userID);
		userList.add(user);
	}
	
	public void removeUser() {
		userList.remove(user);
	}
	
	public void printLog(String string) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			log.append("[" + dateFormat.format(new Date()) + "] " + string + "!\n");
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
				osw = new OutputStreamWriter(os);
				bw = new BufferedWriter(osw);
				
				bw.write(string);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendToUser(User user, String string) {
		printLog("Sent / " + string);
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			for(int i = 0; i < userList.size(); i++) {
				if(user == userList.get(i)) {
					os = userList.get(i).os;
					osw = new OutputStreamWriter(os);
					bw = new BufferedWriter(osw);
					
					bw.write(string);
					bw.newLine();
					bw.flush();
					break;
				}
			}
		} catch (IOException e) {
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
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
			bw.write(string);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void insertToken() {
		user.token = user.userID + "@" + user.userName;
		tokenList.add(user.token);
	}
	
	
	public void createDeck(int a, int b) {
		cardDeck = new String[a * b];
		for(int i = 0; i < cardDeck.length; i++) {
			cardDeck[i] = "" + ((i / 2) + 1); 
		}
	}
	
	public void waitOpposite(int count) {
		printLog("Waiting for game for " + (count + 1) + "s");
		sendToUser(user, "waitOpposite() : " + (count + 1));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void shuffle() {		
		Random random = new Random();
		for(int i = 0; i < 100; i++) {
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

	class Operator extends Thread {
		
		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			createDeck(cardPanelRows, cardPanelColumns);
//			printLog("run 1");
			timeCount = 0;
			countdown = new Countdown();
			countdown.start();
			try {
				countdown.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace();
			}
			printLog("countdown.getState() : " + countdown.getState());
			setOppositeName();
			timeCount = 0;
			countdownBreak = false;
//			printLog("run 2");
			while(!countdownBreak) {
				try {
				if((user.userID + "@" + user.userName).equals(tokenList.get(0))) {
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
						sendToUser("FlipBack : ");
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
			user.flippedCards = new String[2];
			gameOver = false;
			while(true) {
				timeCount = 0;
				if(!threadTurn) {
					try {
						sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
//							e.printStackTrace();
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
//							e.printStackTrace();
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
			tokenList.remove(user.token);
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
				sendToUser("PlayAgain : ");
			}
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
					insertToken();
					operator = new Operator();
					operator.start();
					setTitle("Server by " + user.userID + "@" + user.userName);
					sendToUser("inGame : Welcome! " + user.userName);
					printLog(socket.getRemoteSocketAddress() + "@" + user.userName + " has joined. "
							+ "Current user number is " + userList.size());
				} else if("restartButton".equals(data[0])) {
					user.userScore = 0;
					insertToken();
					operator = new Operator();
					operator.start();
				} else if("exitButton".equals(data[0])) {
					printLog("exitButton clicked");
					if(user != null) {
						tokenList.remove(user.token);
						sendToUser("Terminate : " + user.userName);
						removeUser();
						operator.stop();
					}
					printLog(socket.getInetAddress().getHostAddress() + " : " + data[1] + " has left");
					dispose();
					break;
				} else if("countdownBreak".equals(data[0])) {
					countdownBreak = true;
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
					if(countdown.getState() == Thread.State.TERMINATED) {
						printLog("Game stopped : Player has left");
						tokenList.remove(user.token);
//						printLog("tokenList Size" + tokenList.size());
						sendToUser("PlayAgain : ");
						operator.stop();
					}
//					printLog("tokenList Size" + tokenList.size());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(isr != null) isr.close();
				if(is != null) is.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class Countdown extends Thread {
		
		public void run() {
			synchronized (tokenList) {
				printLog("run 2");
				while(tokenList.size() < 2) {
//					try {
//						Thread.sleep(5);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					waitOpposite(timeCount);
					timeCount++;
				}
			}
		}
	}
	
	class Receiver extends Thread {
		
		Socket socket; 
		
		public Receiver(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			printLog("New user just has connected");
			receive();
		}
	}

}

