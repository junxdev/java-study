package com.bit.day27;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CardGame extends Frame implements ActionListener, Runnable {
	
	JButton[] cards;
	Panel cardPanel;
	static int score;
	
	public static void main(String[] args) {
		new CardGame();
	}
	
	public CardGame() {
		// TODO Auto-generated constructor stub
		
		setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		Label titleBoard = new Label("Find a basketball!");
		
		Label scoreBoard = new Label("Score: " + "");
		

		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new GridLayout(6, 1));
		Button startButton = new Button("Start");
		startButton.addActionListener(this);
		Button endButton = new Button("End");
		endButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		buttonPanel.add(new Label());
		buttonPanel.add(startButton);
		buttonPanel.add(new Label());
		buttonPanel.add(new Label());
		buttonPanel.add(endButton);
		buttonPanel.add(new Label());
		
		cardPanel = new Panel();
		cardPanel.setLayout(new GridLayout(4, 4));
		cards = new JButton[16];
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < cards.length; i++) {
			Image image = toolkit.createImage(((i % 4) + 1 ) + ".jpg");
			Icon icon = new ImageIcon(image);
			cards[i] = new JButton(icon);
			if(i % 4 == 0) {
				cards[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						score++;
					}
				});
			} else {
				cards[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						score -= 2;
					}
				});
			}
			cards[i].setEnabled(false);
			cardPanel.add(cards[i]);
		}
		
		add(BorderLayout.NORTH, titleBoard);
		add(BorderLayout.SOUTH, scoreBoard);
		add(BorderLayout.EAST, buttonPanel);
		add(BorderLayout.CENTER, cardPanel);
		setSize(1125, 1000);
		setLocation(200, 50);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < cards.length; i++) {
			cards[i].setEnabled(true);
		}
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void mixCards() {
		Random random = new Random();
		JButton tempCard = new JButton();
		for(int i = 0; i < 1000; i++) {
			int number = random.nextInt(15) + 1;
			tempCard = cards[0];
			cards[0] = cards[number];
			cards[number] = tempCard;
		}
		for(int i = 0; i < cards.length; i++) {
			cardPanel.add(cards[i]);
		}
		revalidate();
	}
	
	private void play() {
		for(int i = 0; i < 20; i++) {
			mixCards();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i = 0; i < cards.length; i++) {
			cards[i].setEnabled(false);
		}
		System.out.println("Score : " + score);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		play();
	}

}
