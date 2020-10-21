package com.bit.day24;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class Ex09AbsoluteLocation extends Frame {

	public Ex09AbsoluteLocation() {
//		setResizable(false);
//		setLayout(null);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		
		Button button1 = new Button("Button");
		button1.setSize(200, 200);
		button1.setLocation(0, 0);
		
		TextField field = new TextField();
		field.setSize(100, 50);
		field.setLocation(200, 0);
		
		panel.add(field);
		panel.add(button1);
		add(panel);
		setSize(500, 500);
		setLocation(200, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex09AbsoluteLocation();
	}

}
