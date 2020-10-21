package Project;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
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
	
	int Score = 0;
	int cardPanelRows = 0;
	int cardPanelColumns = 0;
	int count = 0;
	Card[] cardDeck = null;
	Card[] flippedCards = new Card[2];
//	ArrayList<Card> flippedCards = new ArrayList<>();
	Card flippedCard = null;
	Panel cardPanel = null;
	
	public Main() {
		// TODO Auto-generated constructor stub
		
		setSize(800, 600);
		setLocation((1920 - this.getWidth()) / 2, (1080 - this.getHeight()) / 2);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		cardPanelRows = 4;
		cardPanelColumns = 4;
		
		Panel scorePanel = new Panel(new GridLayout(1, 3));
		add(BorderLayout.NORTH, scorePanel);
		
		Label score1 = new Label("user1 : 1");
		scorePanel.add(score1);
		Label time = new Label("5 secs");
		scorePanel.add(time);
		Label score2 = new Label("user2 : 1");
		scorePanel.add(score2);
		
		cardPanel = new Panel(new GridLayout(cardPanelRows, cardPanelColumns));
		add(BorderLayout.CENTER, cardPanel);
		
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


		Thread play = new Thread(this);
		play.start();
		
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
	
	public void flip() {
		for(int i = 0; i < cardDeck.length; i++) {
			if(cardDeck[i].paired == true) {
				cardDeck[i].setText("" + cardDeck[i].value);
			} else {
				cardDeck[i].setText("back");
			}
			cardPanel.add(cardDeck[i]);
		}
		revalidate();
	}
	
	public void pairCheck() {
		try {
			if(flippedCards[0].value == flippedCards[1].value) {
				for(int i = 0; i < cardDeck.length; i++) {
					if(cardDeck[i].value == flippedCards[0].value) {
						cardDeck[i].paired = true;
						cardDeck[i].setEnabled(false);
					}
				}
			}
		} catch(NullPointerException e) {
//			System.out.println("null");
		}
		flippedCards = new Card[2];
	}
	
	public void gameCheck() {
		
	}
	
//	public void timer() {
//		jla
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		shuffle();
		for(int i = 0; i < 20; i++) {
			flip();
			count = 0;
			while(true) {
				try {
				if(flippedCards[1] != null) {
					System.out.println("select two");
					Thread.sleep(100);
					break;
				} else if (++count > 50) {
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
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();

		
	}
	
}
