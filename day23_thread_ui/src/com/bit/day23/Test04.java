package com.bit.day23;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class Test04 extends Frame {
	
	Test04() {
		Panel display = new Panel();
		
		TextField resultArea = new TextField("calculating...");
		Panel keyboard = new Panel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;

		keyboard.setLayout(layout);
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		
		String[] keyLabel = new String[] {
			"AC", "*", "-", "+", 
			"7", "8", "9", 
			"4", "5", "6", "-", 
			"1", "2", "3", "=", 
			"0", "."	
		};
		Button[] button = new Button[keyLabel.length];
		for(int i = 0; i < button.length; i++) {
			button[i] = new Button(keyLabel[i]);
		}
		
		labelButton(keyboard, layout, constraints, button[0], 0, 0, 1, 1);
		labelButton(keyboard, layout, constraints, button[1], 1, 0, 1, 1);
		labelButton(keyboard, layout, constraints, button[2], 2, 0, 1, 1);
		labelButton(keyboard, layout, constraints, button[3], 3, 0, 1, 2);
		labelButton(keyboard, layout, constraints, button[4], 0, 1, 1, 1);
		labelButton(keyboard, layout, constraints, button[5], 1, 1, 1, 1);
		labelButton(keyboard, layout, constraints, button[6], 2, 1, 1, 1);
		labelButton(keyboard, layout, constraints, button[7], 0, 2, 1, 1);
		labelButton(keyboard, layout, constraints, button[8], 1, 2, 1, 1);
		labelButton(keyboard, layout, constraints, button[9], 2, 2, 1, 1);
		labelButton(keyboard, layout, constraints, button[10], 3, 2, 1, 1);
		labelButton(keyboard, layout, constraints, button[11], 0, 3, 1, 1);
		labelButton(keyboard, layout, constraints, button[12], 1, 3, 1, 1);
		labelButton(keyboard, layout, constraints, button[13], 2, 3, 1, 1);
		labelButton(keyboard, layout, constraints, button[14], 3, 3, 1, 2);
		labelButton(keyboard, layout, constraints, button[15], 0, 4, 2, 1);
		labelButton(keyboard, layout, constraints, button[16], 2, 4, 1, 1);
		
		add(BorderLayout.NORTH, resultArea);
		add(BorderLayout.CENTER, keyboard);
		Dimension size = new Dimension(500, 800);
		setSize(size);
		setLocation((1920 - size.width) / 2, (1080 - size.height) / 2);
		setVisible(true);
	}
	
	void labelButton(Panel panel, GridBagLayout layout, GridBagConstraints constraint, 
			Button button, int x, int y, int w, int h) {
		constraint.gridx = x;
		constraint.gridy = y;
		constraint.gridwidth = w;
		constraint.gridheight = h;
		layout.addLayoutComponent(button, constraint);
		panel.add(button);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test04();
	}

}
