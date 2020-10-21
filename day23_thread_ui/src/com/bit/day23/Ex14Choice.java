package com.bit.day23;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;

public class Ex14Choice extends Frame {
	int index;
	String item;
	
	public Ex14Choice() {
		Panel panel = new Panel();
		Choice choice = new Choice();
		choice.add("Samsung");
		choice.add("KaKao");
		choice.add("NHN");
		choice.add("NCSoft");
		
		choice.select(3);
		
		panel.add(choice);
		add(panel);
		
		setSize(500, 300);
		Dimension dimension = getSize();
		setLocation((1920 - dimension.width) / 2, (1080 - dimension.height) / 2);
		setVisible(true);
		
		index = choice.getSelectedIndex();
		item = choice.getSelectedItem();
		System.out.println(index + item);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex14Choice ex14 = new Ex14Choice();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ex14.index + ex14.item);
	}

}
