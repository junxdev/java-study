package com.bit.flipit0616;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
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
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class FlipItClientApp extends Frame implements ActionListener, Runnable{

	String userName = null;
	int score = 0;
	int cardPanelRows = 0;
	int cardPanelColumns = 0;
	int timeCount = 0;
	
	Card[] cardDeck = null;
	Card flippedCard = null;
	Card[] flippedCards = new Card[2];
	
	Panel titleScreen = null;
	Panel inGameScreen = null;
	
	// titleScreen Components
	Button startButton = null;
	TextField insertName = null; 
	
	// inGameScreen Components
	Label firstUserScore = null;
	Label timer = null;
	Panel cardPanel = null;
	TextArea console = new TextArea();
	Button restartButton = null;
	Button exitButton = null;
	
	Socket socket;
	
	public FlipItClientApp(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		
		setSize(1000, 600);
		setLocation((1920 - this.getWidth()) / 2, (1080 - this.getHeight()) / 2);
		setFont(new Font(Font.DIALOG, Font.BOLD, 10));
		titleScreen = new Panel();
		add(titleScreen);

		insertName = new TextField("Fill in your name");
		insertName.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				insertName.setText("");
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		titleScreen.add(insertName);
		
		startButton = new Button("Start");
		startButton.addActionListener(this);
		titleScreen.add(startButton);
		
		inGameScreen = new Panel();
		inGameScreen.setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		cardPanelRows = 4;
		cardPanelColumns = 4;
		
		Panel statusPanel = new Panel(new GridLayout(1, 3));
		statusPanel.setPreferredSize(new Dimension(1000, 50));
		inGameScreen.add(BorderLayout.PAGE_START, statusPanel);
		
		firstUserScore = new Label(userName + " : 0");
		statusPanel.add(firstUserScore);
		timer = new Label((5 - (timeCount / 10)) + "s left");
		statusPanel.add(timer);
		Label score2 = new Label("user2 : 0");
		statusPanel.add(score2);
		
		cardPanel = new Panel(new GridLayout(cardPanelRows, cardPanelColumns));
		inGameScreen.add(BorderLayout.CENTER, cardPanel);
		
		cardDeck = new Card[cardPanelRows * cardPanelColumns];
		
		for(int i = 0; i < cardDeck.length; i++) {
			Card card = new Card(i / 2);
			card.setFont(new Font(Font.SERIF, Font.BOLD, 30));
			card.setText("back");
			
			card.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flippedCard = (Card)e.getSource(); 
					flippedCard.setEnabled(false);
					flippedCard.setText("" + flippedCard.value);
					if(flippedCards[0] == null) {
						flippedCards[0] = flippedCard;
					} else {
						flippedCards[1] = flippedCard;
					}
				}
			});
			cardDeck[i] = card;										
		}
		
		Panel controlPanel = new Panel(new GridLayout(3, 1));
		controlPanel.setPreferredSize(new Dimension(250, 500));
		
		inGameScreen.add(BorderLayout.LINE_END, controlPanel);
		
		console.setEditable(false);
		controlPanel.add(console);
		restartButton = new Button("Play Again");
		restartButton.setEnabled(false);
		restartButton.addActionListener(this);
		controlPanel.add(restartButton);
		exitButton = new Button("Leave");
//				exitButton.setEnabled(false);
		exitButton.addActionListener(this);
		controlPanel.add(exitButton);

		setVisible(true);
	}
	
	public void sendName() {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			bw.write("Name : " + userName);
			System.out.println(userName);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} finally {
//			try {
//				if(bw != null) {
//					bw.close();
//				}
//				if(osw != null) {
//					osw.close();
//				}
//				if(os != null) {
//					os.close();
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(startButton.equals(e.getSource())) {
			userName = insertName.getText();
			System.out.println("userName : " + userName);
			send("1234");
			Thread play = new Thread(this);
			play.start();
			remove(titleScreen);									
			add(inGameScreen);										
			revalidate();
		}
		if(restartButton.equals(e.getSource())) {					// 재시작 버튼을 클릭하면
			
		}
		if(exitButton.equals(e.getSource())) {						// 종료 버튼을 클릭하면
			dispose();												// 프레임 종료
		}
	}


	public void showAnswer() {										// 0.5초간 카드의 앞면을 보여주는 메서드
		for(int i = 0; i < cardDeck.length; i++) {
			cardDeck[i].setText("" + cardDeck[i].value);			// 모든 카드를 앞면으로
			cardPanel.add(cardDeck[i]);								// 놓고
		}
		revalidate();
		try {
			Thread.sleep(500);										// 0.5초를 기다린다
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void flip() {											// 짝을 맞추지 못한 카드를 뒷면으로 놓는 메서드
		for(int i = 0; i < cardDeck.length; i++) {
//			if(cardDeck[i].paired == true) {						// 짝을 맞춘 카드는
//				cardDeck[i].setText("" + cardDeck[i].value);		// 앞면으로,
//			} 
			if(cardDeck[i].paired == false) {						// 짝을 맞추지 못한 카드는
				cardDeck[i].setText("back");						// 뒷면으로
				cardDeck[i].setEnabled(true);						// 다시 선택할 수 있도록
			}
			cardPanel.add(cardDeck[i]);								// 놓는다
		}
		timeCount = 0;												// 매 턴의 시간을 초기화한다
		revalidate();
	}
	public void send(String string) {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			bw.write(string);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} finally {
//			try {
//				if(bw != null) {
//					bw.close();
//				}
//				if(osw != null) {
//					osw.close();
//				}
//				if(os != null) {
//					os.close();
//				}
//			} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		send("1234");
		System.out.println("client run");
		
	}
}
