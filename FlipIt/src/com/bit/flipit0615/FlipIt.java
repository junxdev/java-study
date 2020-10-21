package com.bit.flipit0615;

import java.awt.BorderLayout;
import java.awt.Button;
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
import java.util.Random;

import javax.swing.JButton;


class Card extends JButton {
	int value; // ī�� �ĺ���
	boolean paired; // ¦�� ���߸� true
	Card(int value) {
		super("back");
		this.value = value;
	}
}

public class FlipIt extends Frame implements ActionListener, Runnable{
	
	String userName = null;
	int score = 0;
	int cardPanelRows = 0;
	int cardPanelColumns = 0;
	int timeCount = 0;
	
	Card[] cardDeck = null;				// �� 16���� ī�� ����
	Card flippedCard = null;			// ������ ī�� 1��
	Card[] flippedCards = new Card[2];	// �� �ϸ��� ������ ī�� �� 2��
	
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
	
	public FlipIt() {
		// TODO Auto-generated constructor stub
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
		
		firstUserScore = new Label(userName + " : 0");
		statusPanel.add(firstUserScore);
		timer = new Label((5 - (timeCount / 10)) + "s left");
		statusPanel.add(timer);
		Label score2 = new Label("user2 : 0");
		statusPanel.add(score2);
		
		cardPanel = new Panel(new GridLayout(cardPanelRows, cardPanelColumns));
		inGameScreen.add(BorderLayout.CENTER, cardPanel);			// â�� ũ�⸦ �����ϸ� cardPanel�� ũ�⸸ ����(BorderLayout.CENTER)
		
		cardDeck = new Card[cardPanelRows * cardPanelColumns];
		
		for(int i = 0; i < cardDeck.length; i++) {
			Card card = new Card(i / 2); 							// ī�� ���� : 0, 0, 1, 1, ... 6, 6, 7, 7 �� 2�־� 8��
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
	
	public void shuffle() {											// ī�� 16���� ��ġ�� ���� ���θ� �ʱ�ȭ�ϰ� ���� �޼���	
		Random random = new Random();
		for(int i = 0; i < 1000; i++) {								// 0�� ī��� ������ ī���� ��ġ�� 1000�� �ٲ۴�
			int randomIndex = random.nextInt
					(cardPanelRows * cardPanelColumns - 1) + 1;
			Card randomCard = cardDeck[0];
			cardDeck[0] = cardDeck[randomIndex];
			cardDeck[randomIndex] = randomCard;
		}
		for(int i = 0; i < cardDeck.length; i++) {
			cardDeck[i].setText("back");							// ���� ī�带 �޸�����
			cardDeck[i].paired = false;								// 
			cardPanel.add(cardDeck[i]);								// ���´�
			cardDeck[i].setEnabled(false);							// ������ �����ϱ� ������ �������� ���ϵ��� �Ѵ�
		}
	}

	public void showAnswer() {										// 0.5�ʰ� ī���� �ո��� �����ִ� �޼���
		for(int i = 0; i < cardDeck.length; i++) {
			cardDeck[i].setText("" + cardDeck[i].value);			// ��� ī�带 �ո�����
			cardPanel.add(cardDeck[i]);								// ����
		}
		validate();
		try {
			Thread.sleep(500);										// 0.5�ʸ� ��ٸ���
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void flip() {											// ¦�� ������ ���� ī�带 �޸����� ���� �޼���
		for(int i = 0; i < cardDeck.length; i++) {
//			if(cardDeck[i].paired == true) {						// ¦�� ���� ī���
//				cardDeck[i].setText("" + cardDeck[i].value);		// �ո�����,
//			} 
			if(cardDeck[i].paired == false) {						// ¦�� ������ ���� ī���
				cardDeck[i].setText("back");						// �޸�����
				cardDeck[i].setEnabled(true);						// �ٽ� ������ �� �ֵ���
			}
			cardPanel.add(cardDeck[i]);								// ���´�
		}
		timeCount = 0;												// �� ���� �ð��� �ʱ�ȭ�Ѵ�
		revalidate();
	}
	
	public void pairCheck() {										// ������ ī�� �� ���� ¦�� �´��� Ȯ���ϴ� �޼���
		boolean gotPaired = false;
		try {
			if(flippedCards[0].value == flippedCards[1].value) {	// ī�� �� ���� ����(�ĺ���)�� ������
				for(int i = 0; i < cardDeck.length; i++) {
					if(cardDeck[i].value == flippedCards[0].value) {// �� ���ڸ� ���� ī�� �� ���� ã�Ƽ�
						cardDeck[i].paired = true;					// ���� ī��� ǥ���ϰ�
						cardDeck[i].setEnabled(false);				// ���Ŀ� ������ �� ���� �����
						gotPaired = true;
					}
				}
			}
		} catch(NullPointerException e) {
//			System.out.println("null");
		}
		if(gotPaired) {												// ¦�� ���߸�
			score += flippedCards[0].value;							// �ش� ī���� ���ڸ�ŭ ������ �����Ѵ�
			console.append("You got " + flippedCards[0].value + " points! * Total score : " + score + "\n");
			firstUserScore.setText(userName + " : " + score);
		}
		flippedCards = new Card[2];									// �ٸ� ī�带 ������ �غ�(�ʱ�ȭ)
	}
	
	public boolean gameOver() {										// ��� ī���� ¦�� ������� Ȯ���ϴ� �޼���
		for(int i = 0; i < cardDeck.length; i++) {
			if(cardDeck[i].paired == false) {						// ��� ī���� ¦�� ������ ���ߴ�
				return false;										// false�� ��ȯ(������ ������ �ʾҴ�)
			}
		}															// ����ٸ�
		restartButton.setEnabled(true);								// ����� ��ư�� Ȱ��ȭ�ϰ�
//		exitButton.setEnabled(true);
		return true;												// true�� ��ȯ(������ ����)
	}
	
	public void reset() {											// ������ ���� �� ���� ������ ������ �� �ʱ�ȭ
		score = 0;
		console.setText("New Game!\n");
		restartButton.setEnabled(false);							// ����� ��ư�� ��Ȱ��ȭ
//		exitButton.setEnabled(false);
	}
	
	public void play() {											// ���� ���� �� �۵��ϴ� �޼���
		if(restartButton.isEnabled()) {								// �ٽ� ������ �������� �� ����� ��ư�� Ȱ���Ǿ������Ƿ�
			reset();												// reset �޼��� ����(���� ù ���ӿ����� ������� ����)
		}
		firstUserScore.setText(userName + " : " + score);
		shuffle();													// ī���� ��ġ�� ���� ���θ� �ʱ�ȭ
		validate();
		timeCount = 0;
		while(true) {												// ���� ���� �� 5�� ī��Ʈ�ٿ�
			console.append("New game starts in " +(5 - (timeCount)) + "s\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (++timeCount > 4) {
				break;
			}
		}
		console.append("Game Start!\n");
		showAnswer();												// ���� ���� �� 0.5�ʰ� ī���� �ո� ����
		while(!gameOver()) {
			flip();													// ¦�� ������ ���� ī�带 �޸����� ���´�
			while(true) {
//				System.out.println(timeCount/10);
				timer.setText((5 - (timeCount / 10)) + "s left");
				try {
				if(flippedCards[1] != null) {						// ����1 : �ι�° ī����� �����ϸ�
					Thread.sleep(100);
					break;											// pariCheck �޼���� �̵�
				} else if (++timeCount > 50) {						// ����2 : �Ǵ� 5�ʰ� ������
					break;											// pariCheck �޼���� �̵�
				}
				Thread.sleep(100);									// 0.1�ʸ��� �� ���ǹ��� �˻�
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pairCheck();											// ������ ī�� �� ���� ¦�� �´��� Ȯ��
		}
		console.append("Wanna play again?");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(startButton.equals(e.getSource())) {						// ���� ���� ��ư�� Ŭ���ϸ�
			userName = insertName.getText();						// �Է��� ���ڿ��� ���� �̸����� ����
			remove(titleScreen);									// Ÿ��Ʋ ȭ�鿡��
			add(inGameScreen);										// ���� ȭ������ �̵�
			validate();
			Thread play = new Thread(this);							// ���� ����
			play.start();
		}
		if(restartButton.equals(e.getSource())) {					// ����� ��ư�� Ŭ���ϸ�
			Thread play = new Thread(this);							// ���� ����
			play.start();
		}
		if(exitButton.equals(e.getSource())) {						// ���� ��ư�� Ŭ���ϸ�
			dispose();												// ������ ����
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		play();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlipIt();
	}
	
}
