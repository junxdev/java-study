package com.bit.day23;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.TextField;

import java.awt.Font;

public class Calculator02 extends Frame {

	public Calculator02() {
		Panel p = new Panel();
		Panel p2 = new Panel();
		
		String[] name = {
				"AC", "*", "/", "+", 
				"7", "8", "9", 
				"4", "5", "6", "-", 
				"1", "2", "3", "=", 
				"0", "."
		};
		Button[] button = new Button[17];
		for(int i = 0; i < button.length; i++) {
			button[i] = new Button(name[i]);
		}
		GridBagLayout layout = new GridBagLayout();
		p2.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		func(p2, layout, gbc, button[0], 0, 0, 1, 1);
		func(p2, layout, gbc, button[1], 1, 0, 1, 1);
		func(p2, layout, gbc, button[2], 2, 0, 1, 1);
		func(p2, layout, gbc, button[3], 3, 0, 1, 2);
		func(p2, layout, gbc, button[4], 0, 1, 1, 1);
		func(p2, layout, gbc, button[5], 1, 1, 1, 1);
		func(p2, layout, gbc, button[6], 2, 1, 1, 1);
		func(p2, layout, gbc, button[7], 0, 2, 1, 1);
		func(p2, layout, gbc, button[8], 1, 2, 1, 1);
		func(p2, layout, gbc, button[9], 2, 2, 1, 1);
		func(p2, layout, gbc, button[10], 3, 2, 1, 1);
		func(p2, layout, gbc, button[11], 0, 3, 1, 1);
		func(p2, layout, gbc, button[12], 1, 3, 1, 1);
		func(p2, layout, gbc, button[13], 2, 3, 1, 1);
		func(p2, layout, gbc, button[14], 3, 3, 1, 2);
		func(p2, layout, gbc, button[15], 0, 4, 2, 1);
		func(p2, layout, gbc, button[16], 2, 4, 1, 1);
		
		Font font = new Font(Font.SERIF, Font.BOLD, 40);
		p2.setFont(font);
		p.setLayout(new BorderLayout());
		p.add(BorderLayout.NORTH, new TextField());
		p.add(BorderLayout.CENTER, p2);
		
		add(p);
		setSize(500, 600);
		setLocation(200, 200);
		setVisible(true);
	}
	
	public void func(Panel panel, GridBagLayout layout, GridBagConstraints gbc, Button button,
			int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		layout.setConstraints(button, gbc);
		panel.add(button);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator02();
	}

}
