package com.bit.flipit;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;

class Card extends JButton {
	int value;
	boolean paired;
	Card(int value) {
		super("back");
		this.value = value;
	}
}

public class Main extends Frame implements ActionListener, Runnable{
	
	int score = 0;
	int cardPanelRows = 0;
	int cardPanelColumns = 0;
	int timeCount = 0;
	
	Panel titleScreen = null;
	Panel inGameScreen = null;
	
	Card[] cardDeck = null;
	Card[] flippedCards = new Card[2];
	Card flippedCard = null;
	Panel cardPanel = null;
	
	// titleScreen Components
	Button startButton = null;
	// inGameScreen Components
	Label time = null;
	TextArea console = new TextArea();
	Button restartButton = null;
	Button exitButton = null;
	
	public Main() {
		// TODO Auto-generated constructor stub
		setSize(1000, 600);
		setLocation((1920 - this.getWidth()) / 2, (1080 - this.getHeight()) / 2);
		
		titleScreen = new Panel();
		add(titleScreen);
//
		startButton = new Button("Start");
		startButton.addActionListener(this);
		titleScreen.add(startButton);
		
		inGameScreen = new Panel();
		inGameScreen.setLayout(new BorderLayout());
		
//		startButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				remove(titleScreen);
//				add(inGameScreen);
//				validate();
//			}
//		});

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
//		add(BorderLayout.PAGE_START, statusPanel);
		inGameScreen.add(BorderLayout.PAGE_START, statusPanel);
		
		Label score1 = new Label("user1 : 1");
		statusPanel.add(score1);
		time = new Label();
		statusPanel.add(time);
		Label score2 = new Label("user2 : 1");
		statusPanel.add(score2);
		
		cardPanel = new Panel(new GridLayout(cardPanelRows, cardPanelColumns));
		inGameScreen.add(BorderLayout.CENTER, cardPanel);
//		add(BorderLayout.CENTER, cardPanel);
		
		cardDeck = new Card[cardPanelRows * cardPanelColumns];
		
		for(int i = 0; i < cardDeck.length; i++) {
			Card tempCard = new Card(i / 2);
			
			tempCard.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flippedCard = (Card)e.getSource();
					flippedCard.setText("" + flippedCard.value);
					if(flippedCards[0] != null) {
						flippedCards[1] = flippedCard;
					} else {
						flippedCards[0] = flippedCard;
					}
				}
			});
			cardDeck[i] = tempCard;
		}
		
		Panel controlPanel = new Panel(new GridLayout(3, 1));
		controlPanel.setPreferredSize(new Dimension(250, 500));
		
		inGameScreen.add(BorderLayout.LINE_END, controlPanel);
//		add(BorderLayout.LINE_END, controlPanel);
		
		console.setEditable(false);
//		console.setEnabled(false);
		controlPanel.add(console);
		restartButton = new Button("Play Again");
		restartButton.setEnabled(false);
		restartButton.addActionListener(this);
		controlPanel.add(restartButton);
		exitButton = new Button("Leave");
		exitButton.setEnabled(false);
		exitButton.addActionListener(this);
		controlPanel.add(exitButton);

	


//		Thread play = new Thread(this);
//		play.start();
		
		setVisible(true);
	}
	
	public void shuffle() {
		Random random = new Random();
		for(int i = 0; i < 1000; i++) {
			int randomIndex = random.nextInt(cardPanelRows * cardPanelColumns - 1) + 1;
			Card randomCard = cardDeck[0];
			cardDeck[0] = cardDeck[randomIndex];
			cardDeck[randomIndex] = randomCard;
		}
	}
	
	public void reset() {
		score = 0;
		console.setText("New Game!");
		restartButton.setEnabled(false);
		exitButton.setEnabled(false);
		for(int i = 0; i < cardDeck.length; i++) {
			cardDeck[i].paired = false;
			cardDeck[i].setEnabled(true);
		}
	}
	
	public void flip() {
		for(int i = 0; i < cardDeck.length; i++) {
			if(cardDeck[i].paired == true) {
				cardDeck[i].setText("" + cardDeck[i].value);
			} else {
				cardDeck[i].setText("back");
			}
			cardPanel.add(cardDeck[i]);
		}
		timeCount = 0;
		revalidate();
	}
	
	public void pairCheck() {
		boolean gotPaired = false;
		try {
			if(flippedCards[0].value == flippedCards[1].value) {
				for(int i = 0; i < cardDeck.length; i++) {
					if(cardDeck[i].value == flippedCards[0].value) {
						cardDeck[i].paired = true;
						cardDeck[i].setEnabled(false);
						gotPaired = true;
					}
				}
			}
		} catch(NullPointerException e) {
//			System.out.println("null");
		}
		if(gotPaired) {
			score += flippedCards[0].value;
			console.append("You got " + flippedCards[0].value + " points! * Total score : " + score + "\n");
		}
		flippedCards = new Card[2];
	}
	
	public boolean gameOver() {
		for(int i = 0; i < cardDeck.length; i++) {
			if(cardDeck[i].paired == false) {
				return true;
			}
		}
		restartButton.setEnabled(true);
		exitButton.setEnabled(true);
		return false;
	}
	
	public void play() {
		if(restartButton.isEnabled()) {
			reset();
		}
		shuffle();
		while(gameOver()) {
			flip();
			while(true) {
//				System.out.println(timeCount/10);
				time.setText((5 - (timeCount / 10)) + "s left");
				try {
				if(flippedCards[1] != null) {
					System.out.println("select two");
					Thread.sleep(100);
					break;
				} else if (++timeCount > 50) {
					break;
				}
				Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pairCheck();
		}
		console.append("Wanna play again?");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(startButton.equals(e.getSource())) {
			remove(titleScreen);
			add(inGameScreen);
			validate();
			Thread play = new Thread(this);
			play.start();
		}
		if(restartButton.equals(e.getSource())) {
			Thread play = new Thread(this);
			play.start();
		}
		if(exitButton.equals(e.getSource())) {
			dispose();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		play();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();

		
	}
	
}
