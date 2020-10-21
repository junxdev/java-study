package com.bit.flipit0616;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import java.util.Random;

import javax.swing.JButton;


class Card extends JButton {
	int value; // 카드 식별자
	boolean paired; // 짝을 맞추면 true
	
	Card(int value) {
//		super("back");
		this.value = value;
	}
}

class User {
	public User(Socket socket) {
		// TODO Auto-generated constructor stub
	}
	Socket socket;
	int score = 0;
	String userName = null;
	Card firstCard, secondCard;
}

public class FlipItApp extends Frame implements Runnable{
	String userName = null;
	int cardPanelRows = 0;
	int cardPanelColumns = 0;
	int timeCount = 0;
	
	Card[] cardDeck = null;				// 총 16장의 카드 묶음
	Card flippedCard = null;			// 선택한 카드 1장
	Card[] flippedCards = new Card[2];	// 매 턴마다 선택한 카드 총 2장
	
	TextArea textArea = null;
	
	User firstUser = null;
	User secondUser = null;
	
	public FlipItApp() {
		// TODO Auto-generated constructor stub
		setSize(1000, 600);
		setLocation(200, 200);
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		add(BorderLayout.CENTER, textArea);
		
		setVisible(true);
	}
	
	public void addUser(Socket socket) {
		if(firstUser == null) {
			firstUser = new User(socket);
			return;
		} 
		secondUser = new User(socket);
		
	}
	
	public void shuffle() {											// 카드 16장의 위치와 정답 여부를 초기화하고 섞는 메서드	
		Random random = new Random();
		for(int i = 0; i < 1000; i++) {								// 0번 카드와 임의의 카드의 위치를 1000번 바꾼다
			int randomIndex = random.nextInt
					(cardPanelRows * cardPanelColumns - 1) + 1;
			Card randomCard = cardDeck[0];
			cardDeck[0] = cardDeck[randomIndex];
			cardDeck[randomIndex] = randomCard;
		}
		for(int i = 0; i < cardDeck.length; i++) {
			cardDeck[i].setText("back");							// 섞은 카드를 뒷면으로
			cardDeck[i].paired = false;								// 놓는다
			cardDeck[i].setEnabled(false);							// 게임을 시작하기 전까지 선택하지 못하도록 한다
		}
	}
	
//	public void pairCheck() {										// 선택한 카드 두 장이 짝이 맞는지 확인하는 메서드
//		boolean gotPaired = false;
//		try {
//			if(flippedCards[0].value == flippedCards[1].value) {	// 카드 두 장의 숫자(식별자)가 같으면
//				for(int i = 0; i < cardDeck.length; i++) {
//					if(cardDeck[i].value == flippedCards[0].value) {// 그 숫자를 가진 카드 두 장을 찾아서
//						cardDeck[i].paired = true;					// 맞춘 카드로 표시하고
//						cardDeck[i].setEnabled(false);				// 이후에 선택할 수 없게 만든다
//						gotPaired = true;
//					}
//				}
//			}
//		} catch(NullPointerException e) {
////			System.out.println("null");
//		}
//		if(gotPaired) {												// 짝을 맞추면
//			score += flippedCards[0].value;							// 해당 카드의 숫자만큼 점수가 증가한다
//			textArea.append("You got " + flippedCards[0].value + " points! * Total score : " + score + "\n");
//		}
//		flippedCards = new Card[2];									// 다른 카드를 선택할 준비(초기화)
//	}
//	
//	public boolean gameOver() {										// 모든 카드의 짝을 맞췄는지 확인하는 메서드
//		for(int i = 0; i < cardDeck.length; i++) {
//			if(cardDeck[i].paired == false) {						// 모든 카드의 짝을 맞추지 못했다
//				return false;										// false를 반환(게임이 끝나지 않았다)
//			}
//		}															// 맞췄다면
////		restartButton.setEnabled(true);								// 재시작 버튼을 활성화하고
////		exitButton.setEnabled(true);
//		return true;												// true를 반환(게임이 끝남)
//	}
//	
//	public void reset() {											// 게임이 끝난 후 새로 게임을 시작할 때 초기화
//		score = 0;
////		console.setText("New Game!\n");
////		restartButton.setEnabled(false);							// 재시작 버튼을 비활성화
////		exitButton.setEnabled(false);
//	}
//	
	public void appendLog(String string) {
		textArea.append(string);
	}
	
	public void parseData(User user) {
		
		if(user == null) {
			return;
		}

		String userPacket = receive(user);
		String[] userDataArray = userPacket.split(" : ");
		if("Name".equals(userDataArray[0])) {
			userName = userDataArray[1];
			user.userName = userName;
			appendLog(user.socket.getInetAddress() + " : " + userName);
		} else if("FirstCard".equals(userDataArray[0])) {
//				user.firstCard = userDataArray[1];
		} else if("SecondCard".equals(userDataArray[0])) {
//				user.secondCard = userDataArray[1];
		} else if("Start".equals(userDataArray[0])) {
			Thread play = new Thread(this);							// 게임 실행
			play.start();
		} else if("Exit".equals(userDataArray[0])) {
			try {
				user.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			appendLog(user.socket.getInetAddress() + " : Exit\n");
			
		}  
	}
	
	public void listen(User user) {
		System.out.println("listen");
		System.out.println(user.socket.getInetAddress().getHostAddress());
		
	}
	
	public String receive(User user) {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String msg = "ex";
		try {
			is = user.socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			msg = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} finally {
//			try {
//				if(br != null) br.close();
//				if(isr != null) isr.close();
//				if(is != null) is.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

		return msg;
	}
	
	public void play() {	
		int waitCount = 0;
		while(true) {
			try {
				if(firstUser == null) {
					System.out.println("play() 2");
					appendLog("No connection : " + ++waitCount + "s\n");
					Thread.sleep(1000);
				} else if(secondUser == null) {
					System.out.println("play() 3");
					appendLog(firstUser.userName + " is waiting : " + ++waitCount + "s\n");
					Thread.sleep(1000);
					listen(firstUser);
					System.out.println(firstUser.toString());
				} else {
					System.out.println("play() 4");
					appendLog("Two players have connected\n");
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
		while(true) {
			System.out.println("came down");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		play();
	}
	
}
