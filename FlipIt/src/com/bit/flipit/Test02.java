package com.bit.flipit;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;

public class Test02 extends Frame implements ActionListener{
	
	Test02() {
		Panel titleScreen = new Panel();
		titleScreen.setSize(1000, 600);
//		titleScreen.setLocation(0, 50);
		titleScreen.setVisible(true);
		
		Panel playScreen = new Panel();
//		playScreen.setSize(1000, 600);
//		playScreen.setLocation(1200, 800);
		playScreen.setVisible(true);
		playScreen.setLayout(new GridLayout(3, 1));
		playScreen.add(new Button("Where"));
		JButton test = new JButton("123");
		playScreen.setEnabled(false);
		playScreen.add(test);
		
		playScreen.setBackground(Color.BLACK);
		
		Button startButton = new Button("Start");
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				titleScreen.setVisible(false);
				remove(titleScreen);
				add(playScreen);
//				playScreen.setVisible(true);
//				playScreen.setLocation(0, 50);
				revalidate();
			}
		});
		titleScreen.add(startButton);
		
		add(playScreen);
//		add(BorderLayout.CENTER, playScreen);
		add(titleScreen);
//		add(BorderLayout.CENTER, titleScreen);
		
		setSize(1000, 600);
		setLocation(200, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test02();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
