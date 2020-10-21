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
	int value; // 카드 식별자
	boolean paired; // 짝을 맞추면 true
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
	
	Card[] cardDeck = null;				// 총 16장의 카드 묶음
	Card flippedCard = null;			// 선택한 카드 1장
	Card[] flippedCards = new Card[2];	// 매 턴마다 선택한 카드 총 2장
	
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
				insertName.setText(""); // 키보드 입력 시 기본 텍스트(Placeholder)를 삭제
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
		inGameScreen.add(BorderLayout.CENTER, cardPanel);			// 창의 크기를 변경하면 cardPanel의 크기만 변경(BorderLayout.CENTER)
		
		cardDeck = new Card[cardPanelRows * cardPanelColumns];
		
		for(int i = 0; i < cardDeck.length; i++) {
			Card card = new Card(i / 2); 							// 카드 생성 : 0, 0, 1, 1, ... 6, 6, 7, 7 총 2쌍씩 8개
			card.setFont(new Font(Font.SERIF, Font.BOLD, 30));
			
			card.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flippedCard = (Card)e.getSource(); 				// 클릭한 카드를 가리키는 참조변수
					flippedCard.setEnabled(false); 					// 클릭한 카드는 다시 클릭하지 못한다
					flippedCard.setText("" + flippedCard.value); 	// 클릭한 카드의 식별자를 보여준다
					if(flippedCards[0] == null) { 					// 첫번째 클릭이면
						flippedCards[0] = flippedCard;				// 클릭한 카드를 첫번째 선택한 카드로 설정
					} else { 										// 두번째 클릭이면
						flippedCards[1] = flippedCard; 				// 클릭한 카드를 두번째 선택한 카드로 설정
					}
				}
			});
			cardDeck[i] = card;										// 생성한 카드를 카드 묶음에 입력
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
			cardDeck[i].paired = false;								// 
			cardPanel.add(cardDeck[i]);								// 놓는다
			cardDeck[i].setEnabled(false);							// 게임을 시작하기 전까지 선택하지 못하도록 한다
		}
	}

	public void showAnswer() {										// 0.5초간 카드의 앞면을 보여주는 메서드
		for(int i = 0; i < cardDeck.length; i++) {
			cardDeck[i].setText("" + cardDeck[i].value);			// 모든 카드를 앞면으로
			cardPanel.add(cardDeck[i]);								// 놓고
		}
		validate();
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
	
	public void pairCheck() {										// 선택한 카드 두 장이 짝이 맞는지 확인하는 메서드
		boolean gotPaired = false;
		try {
			if(flippedCards[0].value == flippedCards[1].value) {	// 카드 두 장의 숫자(식별자)가 같으면
				for(int i = 0; i < cardDeck.length; i++) {
					if(cardDeck[i].value == flippedCards[0].value) {// 그 숫자를 가진 카드 두 장을 찾아서
						cardDeck[i].paired = true;					// 맞춘 카드로 표시하고
						cardDeck[i].setEnabled(false);				// 이후에 선택할 수 없게 만든다
						gotPaired = true;
					}
				}
			}
		} catch(NullPointerException e) {
//			System.out.println("null");
		}
		if(gotPaired) {												// 짝을 맞추면
			score += flippedCards[0].value;							// 해당 카드의 숫자만큼 점수가 증가한다
			console.append("You got " + flippedCards[0].value + " points! * Total score : " + score + "\n");
			firstUserScore.setText(userName + " : " + score);
		}
		flippedCards = new Card[2];									// 다른 카드를 선택할 준비(초기화)
	}
	
	public boolean gameOver() {										// 모든 카드의 짝을 맞췄는지 확인하는 메서드
		for(int i = 0; i < cardDeck.length; i++) {
			if(cardDeck[i].paired == false) {						// 모든 카드의 짝을 맞추지 못했다
				return false;										// false를 반환(게임이 끝나지 않았다)
			}
		}															// 맞췄다면
		restartButton.setEnabled(true);								// 재시작 버튼을 활성화하고
//		exitButton.setEnabled(true);
		return true;												// true를 반환(게임이 끝남)
	}
	
	public void reset() {											// 게임이 끝난 후 새로 게임을 시작할 때 초기화
		score = 0;
		console.setText("New Game!\n");
		restartButton.setEnabled(false);							// 재시작 버튼을 비활성화
//		exitButton.setEnabled(false);
	}
	
	public void play() {											// 게임 실행 시 작동하는 메서드
		if(restartButton.isEnabled()) {								// 다시 게임을 시작했을 때 재시작 버튼이 활성되어있으므로
			reset();												// reset 메서드 실행(따라서 첫 게임에서는 실행되지 않음)
		}
		firstUserScore.setText(userName + " : " + score);
		shuffle();													// 카드의 위치와 정답 여부를 초기화
		validate();
		timeCount = 0;
		while(true) {												// 게임 시작 전 5초 카운트다운
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
		showAnswer();												// 게임 시작 전 0.5초간 카드의 앞면 공개
		while(!gameOver()) {
			flip();													// 짝을 맞추지 못한 카드를 뒷면으로 놓는다
			while(true) {
//				System.out.println(timeCount/10);
				timer.setText((5 - (timeCount / 10)) + "s left");
				try {
				if(flippedCards[1] != null) {						// 조건1 : 두번째 카드까지 선택하면
					Thread.sleep(100);
					break;											// pariCheck 메서드로 이동
				} else if (++timeCount > 50) {						// 조건2 : 또는 5초가 지나면
					break;											// pariCheck 메서드로 이동
				}
				Thread.sleep(100);									// 0.1초마다 위 조건문을 검사
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pairCheck();											// 선택한 카드 두 장이 짝이 맞는지 확인
		}
		console.append("Wanna play again?");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(startButton.equals(e.getSource())) {						// 게임 시작 버튼을 클릭하면
			userName = insertName.getText();						// 입력한 문자열을 유저 이름으로 설정
			remove(titleScreen);									// 타이틀 화면에서
			add(inGameScreen);										// 게임 화면으로 이동
			validate();
			Thread play = new Thread(this);							// 게임 실행
			play.start();
		}
		if(restartButton.equals(e.getSource())) {					// 재시작 버튼을 클릭하면
			Thread play = new Thread(this);							// 게임 실행
			play.start();
		}
		if(exitButton.equals(e.getSource())) {						// 종료 버튼을 클릭하면
			dispose();												// 프레임 종료
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
