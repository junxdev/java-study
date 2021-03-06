package com.bit.game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Card extends JButton {
	int index;
	String value; // 카占쏙옙 占식븝옙占쏙옙
	boolean paired; // 짝占쏙옙 占쏙옙占쌩몌옙 true
	Card(int index, String value) {
		super.setIcon(new ImageIcon("back.jpg"));
		this.index = index;
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
	
	Card[] cardDeck = null;				// 占쏙옙 16占쏙옙占쏙옙 카占쏙옙 占쏙옙占쏙옙
	Card flippedCard = null;			// 占쏙옙占쏙옙占쏙옙 카占쏙옙 1占쏙옙
	Card[] flippedCards = new Card[2];	// 占쏙옙 占싹몌옙占쏙옙 占쏙옙占쏙옙占쏙옙 카占쏙옙 占쏙옙 2占쏙옙
	ImagePanel imgpanel= null;
	JPanel titleScreen = null;
	Panel inGameScreen = null;
	
	// titleScreen Components
	Button startButton = null;
	TextField insertName = null; 
	
	// inGameScreen Components
	Label userBoard = null;
	Label timer = null;
	Label oppositeBoard = null;
	Panel cardPanel = null;
	JLabel titleword =null; 
	JLabel titleword2 =null; 
	TextArea console = new TextArea();
	JButton restartButton = null;
	JButton exitButton = null;
	
	

	
	class ImagePanel extends JPanel{                  //C
		private Image img;
		public ImagePanel(Image img){
			this.img = img;
			setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
			setLayout(null);
			setOpaque(false);
		}
		public void paintComponent(Graphics g){
			g.drawImage(img, 0, 0, null);
			setOpaque(true);
		}
	}
	
	
	
	
	
	
	
	public ClientApp(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		new Receiver(socket).start();
		setTitle("FIND A SAME PIC(ver 1.0.0)");
		setSize(1024, 900);
		setLocation((1920 - this.getWidth()) / 2, (1080 - this.getHeight()) / 2);
		setFont(new Font(Font.DIALOG, Font.BOLD, 10));
		setResizable(false); 
		titleword=new JLabel("Click The Iron Man card and");        
		titleword2=new JLabel(" Find another Same Iron Man card "); 
		imgpanel =new ImagePanel(new ImageIcon("title.jpg").getImage());
		titleScreen = new JPanel();
		add(imgpanel);
		add(titleScreen);

		insertName = new TextField("Fill in your name");
		insertName.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				insertName.setText(""); // 키占쏙옙占쏙옙 占쌉뤄옙 占쏙옙 占썩본 占쌔쏙옙트(Placeholder)占쏙옙 占쏙옙占쏙옙
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
		titleScreen.setLayout(null);
		titleword.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		titleword.setForeground(Color.WHITE);
		titleword2.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		titleword2.setForeground(Color.WHITE);
		titleScreen.add(titleword);
		titleScreen.add(titleword2);
		titleScreen.add(insertName);
		startButton = new Button("Press this button");
		startButton.setBounds(440, 800, 115, 50);
		startButton.addActionListener(this);
		insertName.setBounds(440, 780, 114, 20);
		titleword.setBounds(100, 750, 200, 100);
		titleword2.setBounds(700, 750, 250, 100);
		titleScreen.add(startButton);
		titleScreen.setBackground(Color.BLACK);
		startButton.setBackground(Color.BLACK);
		startButton.setFont(new Font(Font.DIALOG, Font.BOLD, 8));
		startButton.setForeground(Color.WHITE);
		inGameScreen = new Panel();
		inGameScreen.setLayout(new BorderLayout());
		inGameScreen.setBackground(Color.BLACK);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				sendToServer("exitButton : " + userID + "@" + userName);
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
		statusPanel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		statusPanel.setForeground(Color.WHITE);
		timer = new Label("5");
		statusPanel.add(timer);
		oppositeBoard = new Label("Looking for new user...");
		
		statusPanel.add(oppositeBoard);
		
		cardPanel = new Panel(new GridLayout(cardPanelRows, cardPanelColumns));
		inGameScreen.add(BorderLayout.CENTER, cardPanel);
		
		cardDeck = new Card[cardPanelRows * cardPanelColumns];
		
		for(int i = 0; i < cardDeck.length; i++) {
			Card card = new Card(i, "" + (i / 2));
//			card.setFont(new Font(Font.SERIF, Font.BOLD, 30));
			card.setIcon(new ImageIcon ("C:\\Javaworkspace\\final2\\"+card.value+".jpg"));
			card.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flippedCard = (Card)e.getSource();
					flippedCard.setEnabled(false);
//					flippedCard.setText("" + flippedCard.value);
					flippedCard.setIcon(new ImageIcon ("C:\\Javaworkspace\\final2\\"+flippedCard.value+".jpg"));
					sendToServer("flippedCard : " + flippedCard.index + " : " + flippedCard.value);
				}
			});
			cardDeck[i] = card;
		}
		
		Panel controlPanel = new Panel(new GridLayout(3, 1));
		controlPanel.setPreferredSize(new Dimension(250, 500));
		
		inGameScreen.add(BorderLayout.LINE_END,controlPanel);
		 //
		console.setEditable(false);
		
		console.setForeground(Color.WHITE);
		console.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
		console.setBackground(Color.BLACK);
		controlPanel.add(console);
		restartButton = new JButton("Play Again");
		restartButton.setForeground(Color.WHITE);
		restartButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		restartButton.setBackground(Color.BLACK);
		restartButton.setEnabled(false);
		restartButton.addActionListener(this);
		controlPanel.add(restartButton);
		exitButton = new JButton("Leave");
		exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		exitButton.setBackground(Color.BLACK);
		titleword2.setBounds(700, 750, 250, 100); //
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
			setTitle("FIND A SAME PIC(ver 1.0.0)");
			sendToServer("startButton : " + userName + " : " + userID);
		}
		if(restartButton.equals(e.getSource())) {
			restartButton.setEnabled(false);
			userScore = 0;
			oppositeScore = 0;
			userBoard.setText(userName + " : " + userScore); 
			oppositeBoard.setText("Looking for new user..."); 
			userBoard.setForeground(Color.WHITE);
			userBoard.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			oppositeBoard.setForeground(Color.WHITE);
			oppositeBoard.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			
			sendToServer("restartButton : " + userName + " : " + userID);
		}
		if(exitButton.equals(e.getSource())) {	
			sendToServer("exitButton : " + userID + "@" + userName);
			dispose();
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
	
	public void flipBack() {											// 짝占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 카占썲를 占쌨몌옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쌨쇽옙占쏙옙
		for(int i = 0; i < cardDeck.length; i++) {
			if(cardDeck[i].paired == false) {						// 짝占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 카占쏙옙占�
//				cardDeck[i].setText("back");						// 占쌕쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쌍듸옙占쏙옙
				cardDeck[i].setIcon(new ImageIcon("back.jpg"));
				cardDeck[i].setEnabled(true);
				
			}
			cardPanel.add(cardDeck[i]);								// 占쏙옙占승댐옙
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
//				System.out.println(packet);
				String[] data = packet.split(" : ");
				String message = null;
				if("Server".equals(data[0])) {
					message = "Server : " + data[1];
				} else if("inGame".equals(data[0])) {
					remove(titleScreen);
					remove(imgpanel);
					add(inGameScreen);
					userBoard.setText(userName + " : " + userScore);
					message = data[1];
				} else if("Terminate".equals(data[0])) {
					sendToServer("Gone : ");
					message = data[1] + " has left";
				} else if("waitOpposite()".equals(data[0])) {
					message = "Please wait. Looking for opposite for " + data[1] + "s";
				} else if("shuffle()".equals(data[0])) {
					String tempCard = null;
					cardPanel.setEnabled(false);
					for(int i = 0; i < cardDeck.length; i++) {
						tempCard = "" + data[1].charAt(i);
						cardDeck[i].value = tempCard;
//						cardDeck[i].setText(tempCard);
						cardDeck[i].setIcon(new ImageIcon ("C:\\Javaworkspace\\final2\\"+cardDeck[i].value+".jpg"));
						cardDeck[i].paired = false; 
						cardPanel.add(cardDeck[i]);
						cardDeck[i].setEnabled(true);
					}
					continue;
				} else if("setOppositeName()".equals(data[0])) {
					if(!data[1].contains(userID)){
						oppositeName = data[1].substring(data[1].indexOf('@') + 1);
						oppositeBoard.setText(oppositeName + " : " + oppositeScore);
					}
					continue;
				} else if("countdown()".equals(data[0])) {
//					console.append(data[1]);
//					if(!data[1].contains(userID)){
//						continue;
//					}
					timeCount = data[1];
					timer.setText(timeCount);
					message = "Countdown " + timeCount;
				} else if("ShowAnswer".equals(data[0])) {
					timer.setText("Game Start!");
					message = "Game Start!";
					sendToServer("countdownBreak : ");
					for(int i = 0; i < cardDeck.length; i++) {
//						cardDeck[i].setText(cardDeck[i].value);
						cardDeck[i].setIcon(new ImageIcon ("C:\\Javaworkspace\\final2\\"+cardDeck[i].value+".jpg"));
						cardPanel.add(cardDeck[i]);
						cardDeck[i].setEnabled(false);
					}
				} else if("FlipBack".equals(data[0])) {
					flipBack();
					continue;
				} else if("Turn".equals(data[0])) {
					flipBack();
					if(userID.equals(data[1])) {
						userBoard.setBackground(Color.green);
						oppositeBoard.setBackground(Color.black);
						cardPanel.setEnabled(true);
					} else {
						userBoard.setBackground(Color.black);
						oppositeBoard.setBackground(Color.green);
						cardPanel.setEnabled(false);
					}
					continue;
				} else if("InGameCountdown".equals(data[0])) {
					if(userID.equals(data[1])) {
						timer.setText("Your turn : " + data[2]);
					} else {
						timer.setText(oppositeName + "'s turn : " + data[2]);
					}
					continue;
				} else if("flippedCardIndex".equals(data[0])) {
					int flippedCardIndex = Integer.parseInt(data[1]);
					Card flippedCard = cardDeck[flippedCardIndex];
//					flippedCard.setText(flippedCard.value);\
					flippedCard.setIcon(new ImageIcon ("C:\\Javaworkspace\\final2\\"+flippedCard.value+".jpg"));
					flippedCard.setEnabled(false);
					continue;
				} else if("pairCheck()".equals(data[0])) {
					for(int i = 0; i < cardDeck.length; i++) {
						if(cardDeck[i].value.equals(data[1])) {
//							cardDeck[i].setText(cardDeck[i].value);
							cardDeck[i].setIcon(new ImageIcon ("C:\\Javaworkspace\\final2\\"+cardDeck[i].value+".jpg"));
							cardDeck[i].paired = true;					
							cardDeck[i].setEnabled(false);				
						}
					}
					if(userID.equals(data[2])) {
						userBoard.setText(userName + " : " + data[3] + " points");
						message = userName + " got " + data[1] + " points!";
					} else {
						oppositeBoard.setText(oppositeName + " : " + data[3] + " points");
						message = oppositeName + " got " + data[1] + " points!";
					}
				} else if("Interrupt".equals(data[0])) {
					if(!userID.equals(data[1])) {
						sendToServer("Interrupt : ");
					}
					continue;
				} else if("threadTurn".equals(data[0])) {
					if(!userID.equals(data[1])) {
						sendToServer("threadTurn : ");
					}
					continue;
				} else if("Win".equals(data[0])) {
					message = "You win!";
					userBoard.setBackground(Color.RED);
					oppositeBoard.setBackground(Color.WHITE);
					restartButton.setEnabled(true);
				} else if("Lose".equals(data[0])) {
					message = "You lose!";
					userBoard.setBackground(Color.WHITE);
					oppositeBoard.setBackground(Color.RED);
					restartButton.setEnabled(true);
				} else if("Draw".equals(data[0])) {
					message = "Draw!";
					userBoard.setBackground(Color.WHITE);
					oppositeBoard.setBackground(Color.WHITE);
					restartButton.setEnabled(true);
				} else if("Gone".equals(data[0])) {
					userBoard.setBackground(Color.WHITE);
					oppositeBoard.setBackground(Color.WHITE);
					restartButton.setEnabled(true);
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