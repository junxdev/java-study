package com.bit.flipit0617;

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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;

class Card extends JButton {
	String value; // ī�� �ĺ���
	boolean paired; // ¦�� ���߸� true
	Card(String value) {
		super("back");
		this.value = value;
	}
}

public class ClientApp extends Frame implements ActionListener {
	
	Socket socket = null;
	String packet = null;

	String userID = null;
	String userName = null;
	String oppositeName = null;
	int userScore = 0;
	int oppositeScore = 0;
	
	int cardPanelRows = 0;
	int cardPanelColumns = 0;
	String timeCount = null;
	
	Card[] cardDeck = null;				// �� 16���� ī�� ����
	Card flippedCard = null;			// ������ ī�� 1��
	Card[] flippedCards = new Card[2];	// �� �ϸ��� ������ ī�� �� 2��
	
	Panel titleScreen = null;
	Panel inGameScreen = null;
	
	// titleScreen Components
	Button startButton = null;
	TextField insertName = null; 
	
	// inGameScreen Components
	Label userBoard = null;
	Label timer = null;
	Label oppositeUserBoard = null;
	Panel cardPanel = null;
	TextArea console = new TextArea();
	Button restartButton = null;
	Button exitButton = null;
	
	public ClientApp(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		new Receiver(socket).start();
		
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
				insertName.setText(""); // Ű���� �Է� �� �⺻ �ؽ�Ʈ(Placeholder)�� ����
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
		
		userBoard = new Label();
		statusPanel.add(userBoard);
		timer = new Label("5");
		statusPanel.add(timer);
		oppositeUserBoard = new Label("Looking for new user...");
		statusPanel.add(oppositeUserBoard);
		
		cardPanel = new Panel(new GridLayout(cardPanelRows, cardPanelColumns));
		inGameScreen.add(BorderLayout.CENTER, cardPanel);			// â�� ũ�⸦ �����ϸ� cardPanel�� ũ�⸸ ����(BorderLayout.CENTER)
		
		cardDeck = new Card[cardPanelRows * cardPanelColumns];
		
		for(int i = 0; i < cardDeck.length; i++) {
			Card card = new Card("" + (i / 2)); 							// ī�� ���� : 0, 0, 1, 1, ... 6, 6, 7, 7 �� 2�־� 8��
			card.setFont(new Font(Font.SERIF, Font.BOLD, 30));
			
			card.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flippedCard = (Card)e.getSource(); 				// Ŭ���� ī�带 ����Ű�� ��������
					flippedCard.setEnabled(false); 					// Ŭ���� ī��� �ٽ� Ŭ������ ���Ѵ�
					flippedCard.setText("" + flippedCard.value); 	// Ŭ���� ī���� �ĺ��ڸ� �����ش�
					if(flippedCards[0] == null) { 					// ù��° Ŭ���̸�
						flippedCards[0] = flippedCard;				// Ŭ���� ī�带 ù��° ������ ī��� ����
					} else { 										// �ι�° Ŭ���̸�
						flippedCards[1] = flippedCard; 				// Ŭ���� ī�带 �ι�° ������ ī��� ����
					}
				}
			});
			cardDeck[i] = card;										// ������ ī�带 ī�� ������ �Է�
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
//		exitButton.setEnabled(false);
		exitButton.addActionListener(this);
		controlPanel.add(exitButton);

		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(startButton.equals(e.getSource())) {
			startButton.setEnabled(false);
			userName = insertName.getText();
			userID = new Random().nextInt(1000) + "";
			sendToServer("startButton : " + userName + " : " + userID);
		}
		if(restartButton.equals(e.getSource())) {	
			sendToServer("restartButton : " + packet);
		}
		if(exitButton.equals(e.getSource())) {	
			sendToServer("exitButton : " + socket.getLocalPort());
		}
	}
	
	public void printLog(String string) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		console.append("[" + dateFormat.format(new Date()) + "] " + string + "\n");
	}
	
	public void sendToServer(String string) {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void flip() {											// ¦�� ������ ���� ī�带 �޸����� ���� �޼���
		for(int i = 0; i < cardDeck.length; i++) {
			if(cardDeck[i].paired == false) {						// ¦�� ������ ���� ī���
				cardDeck[i].setText("back");						// �ٽ� ������ �� �ֵ���
			}
			cardPanel.add(cardDeck[i]);								// ���´�
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
				packet = br.readLine();
				System.out.println(packet);
				String[] data = packet.split(" : ");
				String message = null;
				if("Server".equals(data[0])) {
					message = "Server : " + data[1];
				} else if("inGame".equals(data[0])) {
					remove(titleScreen);		
					add(inGameScreen);
					userBoard.setText(userName + " : " + userScore);
					message = data[1];
				} else if("Terminate".equals(data[0])) {
					dispose();
					break;
				} else if("waitOpposite()".equals(data[0])) {
					message = "Please wait. Looking for opposite for " + data[1] + "s";
				} else if("shuffle()".equals(data[0])) {
					String tempCard = null;
					for(int i = 0; i < cardDeck.length; i++) {
						tempCard = "" + data[1].charAt(i);
						cardDeck[i].value = tempCard;
						cardDeck[i].setText(tempCard);
						cardDeck[i].paired = false; 
						cardPanel.add(cardDeck[i]);
						cardDeck[i].setEnabled(true);
					}
					continue;
				} else if("setOppositeName()".equals(data[0])) {
					if(!data[1].contains(userID)){
						oppositeName = data[1].substring(data[1].indexOf('@') + 1);
						oppositeUserBoard.setText(oppositeName + " : " + oppositeScore);
					}
					continue;
				} else if("countdown()".equals(data[0])) {
//					console.append(data[1]);
//					if(!data[1].contains(userID)){
//						continue;
//					}
					timeCount = data[1].substring(data[1].indexOf('@') + 1);
					timer.setText(timeCount);
					message = "Countdown " + timeCount;
					cardPanel.setEnabled(false);
				} else if("Flip".equals(data[0])) {
					flip();
					continue;
				}
				console.append(message + "\n");
				revalidate();
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
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
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
			receive();
		}
	}
}
	

//
//public class ClientF {
//	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String address = "127.0.0.1";
//		int port = 6030;
//		Socket socket = null;
//		
//		try {
//			socket = new Socket(address, port);
//			if(socket.isConnected()) {
//				System.out.println(socket.getLocalSocketAddress());
//				new GameWindow(socket);
//			}
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//	}
//
//}