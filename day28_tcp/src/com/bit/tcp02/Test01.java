package com.bit.tcp02;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Test01 extends Frame {

	Test01() {
		setSize(800, 600);
		setLocation(300, 300);
		setVisible(true);
		setLayout(new GridLayout(1, 2));
		Panel panel = new Panel(new GridLayout(2, 2));
		Label label1 = new Label("Pearl");
		Label label2 = new Label("Jam");
		panel.setBackground(Color.BLUE);
		
		add(panel);
		add(label2);
		panel.add(label1);
		panel.add(label2);
		panel.add(new Label("Smashing"));
		panel.add(label2);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test01();
	}

}
