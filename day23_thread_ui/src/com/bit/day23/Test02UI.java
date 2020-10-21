package com.bit.day23;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.TextField;

public class Test02UI extends Frame {

	Test02UI() {
		Panel mainPanel = new Panel();
		mainPanel.setSize(300, 500);
		mainPanel.setLayout(new GridLayout(4, 1));
		
		Panel displayPanel = new Panel();
		displayPanel.setSize(400, 100);
		TextField textfield = new TextField();
		displayPanel.add(textfield);
		
		Panel buttonPanelA = new Panel();
		buttonPanelA.setSize(400, 200);
		buttonPanelA.setLayout(new GridLayout(1, 2));
		
		Panel buttonPanelA1 = new Panel();
		buttonPanelA1.setSize(300, 200);
		buttonPanelA1.setLayout(new GridLayout(2, 3));
		buttonPanelA1.add(new Button("ac"));
		buttonPanelA1.add(new Button("*"));
		buttonPanelA1.add(new Button("/"));
		buttonPanelA1.add(new Button("7"));
		buttonPanelA1.add(new Button("8"));
		buttonPanelA1.add(new Button("9"));
		Button buttonA = new Button("+");
		buttonA.setSize(100, 200);
		buttonPanelA.add(buttonPanelA1);
		buttonPanelA.add(buttonA);
		
		Panel buttonPanelB = new Panel();
		buttonPanelB.setSize(400, 100);
		buttonPanelB.setLayout(new GridLayout(1, 2));
		Panel buttonPanelB1 = new Panel();
		buttonPanelB1.setLayout(new GridLayout(1, 3));
		buttonPanelB1.add(new Button("4"));
		buttonPanelB1.add(new Button("5"));
		buttonPanelB1.add(new Button("6"));
		Button buttonB = new Button("-");
		buttonB.setSize(100, 100);
		buttonPanelB.add(buttonPanelB1);
		buttonPanelB.add(buttonB);
		
		Panel buttonPanelC = new Panel();
		buttonPanelC.setSize(400, 200);
		buttonPanelC.setLayout(new GridLayout(1, 2));
		
		Panel buttonPanelC1 = new Panel();
		buttonPanelC.setLayout(new GridLayout(2, 1));
		Panel buttonPanelC11 = new Panel();
		buttonPanelC11.setSize(300, 100);
		buttonPanelC11.setLayout(new GridLayout(1, 3));
		buttonPanelC11.add(new Button("1"));
		buttonPanelC11.add(new Button("2"));
		buttonPanelC11.add(new Button("3"));
		Panel buttonPanelC12 = new Panel();
		buttonPanelC12.setSize(300, 100);
		buttonPanelC12.setLayout(new GridLayout(1, 2));
		buttonPanelC12.add(new Button("0"));
		buttonPanelC12.add(new Button("."));
		buttonPanelC1.add(buttonPanelC11);
		buttonPanelC1.add(buttonPanelC12);
		Button buttonC = new Button("=");
		buttonC.setSize(100, 200);
		buttonPanelC.add(buttonPanelC1);
		buttonPanelC.add(buttonC);
		
		mainPanel.add(displayPanel);
		mainPanel.add(buttonPanelA);
		mainPanel.add(buttonPanelB);
		mainPanel.add(buttonPanelC);
		
		add(mainPanel);
		
		setSize(400, 800);
		Dimension dimension = getSize();
		setLocation((1920 - dimension.width) / 2, (1080 - dimension.height) / 2);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test02UI();
	}

}
