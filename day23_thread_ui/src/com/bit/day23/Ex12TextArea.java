package com.bit.day23;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;

public class Ex12TextArea extends Frame {
	
	public Ex12TextArea() {
		Panel panel = new Panel();
		panel.setBackground(Color.blue);
		
		TextArea ta = new TextArea("Hello, World!\nHello Again!", 5, 20, TextArea.SCROLLBARS_NONE);
		panel.add(ta);
//		ta.setVisible(false);
		ta.setEnabled(false);
//		ta.setColumns(5);
//		ta.setRows(20);
		
		Button btn = new Button("OK");
		btn.setEnabled(false);
		panel.add(btn);
		
		add(panel);
		setLocation(200, 200);
		setSize(300, 400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex12TextArea();
	}

}
