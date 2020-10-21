package com.bit.day23;

import java.awt.Color;

public class Test01UI extends java.awt.Frame{
	
	Test01UI(int x, int y) {
		
		
		java.awt.Panel panel = new java.awt.Panel();
		panel.setLayout(new java.awt.GridLayout(x, y));
		
		for(int i = 0; i < (x * y); i++) {
			String num = "0";
			if(i == (x * y) - 3) {
				num = "*";
			} else if(i == (x * y) - 2) {
				num = "0";
			} else if(i == (x * y) - 1) {
				num = "#";
			} else {
				num = i + 1 + "";
			}
			java.awt.Button button = new java.awt.Button(num);
			panel.add(button);
		}
		
		
		add(panel);
		setLocation(200, 200);
		setSize(300, 400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test01UI(4, 3);
	}

}
