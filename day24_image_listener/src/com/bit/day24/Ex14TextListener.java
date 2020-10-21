package com.bit.day24;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Ex14TextListener extends Frame implements TextListener {
	
	Ex14TextListener() {
		Panel p = new Panel();
		TextField tf = new TextField();
		tf.addTextListener(this);
		
		p.add(tf);
		add(p);
		
		setSize(500, 300);
		setLocation(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex14TextListener();
	}

	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		System.out.println("textValueChanged");
	}

}
