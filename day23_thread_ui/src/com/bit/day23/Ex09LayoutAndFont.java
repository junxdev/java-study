package com.bit.day23;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Ex09LayoutAndFont extends Frame {
	
	Ex09LayoutAndFont() {
		Panel p = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		p.setBackground(new Color(0, 255, 255));
		p2.setBackground(Color.BLUE);
		p.setLayout(new GridLayout(1, 2));
		Button btn1 = new Button();
		btn1.setLabel("출력");
		
		Font font = null;
		font = new Font("궁서" , 2, 37);
		btn1.setFont(font);
		
		javax.swing.JLabel la1 = new javax.swing.JLabel();
//		Label la1 = new Label();
		la1.setText("출력");
		la1.setFont(font);
		System.out.println(la1.getText());
		
		Button btn2 = new Button();
		btn2.setLabel("cancel");
		p2.add(la1);
		p.add(btn1);
		p.add(p2);
		add(p);
		setLocation(200, 200);
		setSize(500, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex09LayoutAndFont();
	}

}
