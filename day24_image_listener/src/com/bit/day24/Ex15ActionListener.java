package com.bit.day24;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Ex15ActionListener extends Frame implements ActionListener {
	
	Ex15ActionListener() {
		Panel p = new Panel();
		TextField tf = new TextField(10);
		tf.addActionListener(this);
		
		p.add(tf);
		
		List cho = new List();
		cho.addActionListener
		(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("action in list");
			}
		});
		cho.addItem("Item1");
		cho.addItem("Item2");
		cho.addItem("Item3");
		cho.addItem("Item4");
		p.add(cho);
		
		
		Button btn = new Button("Button");
		p.add(btn);
		btn.addActionListener(this);
		add(p);
		
		setSize(500, 300);
		setLocation(300, 200);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex15ActionListener();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("actionPerformed");
		
	}

}