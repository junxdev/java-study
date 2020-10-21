package com.bit.day23;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.TextField;

public class Calculator01 extends Frame {

	public Calculator01() {
		Panel p = new Panel();
		Panel p2 = new Panel();
		
		String[] name = {
				"ac", "*", "/", "+", 
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
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		layout.setConstraints(button[0], gbc);
		p2.add(button[0]);
		gbc.gridx = 1;
		layout.setConstraints(button[1], gbc);
		p2.add(button[1]);
		gbc.gridx = 2;
		layout.setConstraints(button[2], gbc);
		p2.add(button[2]);
		gbc.gridx = 3;
		gbc.gridheight = 2;
		layout.setConstraints(button[3], gbc);
		p2.add(button[3]);
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridheight = 1;
		layout.setConstraints(button[4], gbc);
		p2.add(button[4]);
		gbc.gridx = 1;
		layout.setConstraints(button[5], gbc);
		p2.add(button[5]);
		gbc.gridx = 2;
		layout.setConstraints(button[6], gbc);
		p2.add(button[6]);
		gbc.gridy = 2;
		gbc.gridx = 0;
		layout.setConstraints(button[7], gbc);
		p2.add(button[7]);
		gbc.gridx = 1;
		layout.setConstraints(button[8], gbc);
		p2.add(button[8]);
		gbc.gridx = 2;
		layout.setConstraints(button[9], gbc);
		p2.add(button[9]);
		gbc.gridx = 3;
		layout.setConstraints(button[10], gbc);
		p2.add(button[10]);
		gbc.gridy = 3;
		gbc.gridx = 0;
		layout.setConstraints(button[11], gbc);
		p2.add(button[11]);
		gbc.gridx = 1;
		layout.setConstraints(button[12], gbc);
		p2.add(button[12]);
		gbc.gridx = 2;
		layout.setConstraints(button[13], gbc);
		p2.add(button[13]);
		gbc.gridx = 3;
		gbc.gridheight = 2;
		layout.setConstraints(button[14], gbc);
		p2.add(button[14]);
		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		layout.setConstraints(button[15], gbc);
		p2.add(button[15]);
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		layout.setConstraints(button[16], gbc);
		p2.add(button[16]);
		
		
		p.setLayout(new BorderLayout());
		p.add(BorderLayout.NORTH, new TextField());
		p.add(BorderLayout.CENTER, p2);
		
		add(p);
		setSize(500, 600);
		setLocation(200, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator01();
	}

}
