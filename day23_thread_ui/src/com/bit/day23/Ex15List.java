package com.bit.day23;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

public class Ex15List extends Frame{

	Ex15List() {
		Panel panel = new Panel();
		
		List list = new List();
		list.add("Samsung");
		list.add("Hyundai");
		list.add("LG");
		list.add("SK");
		list.add("KT");
		list.add("Hyosung");
		list.add("Lotte");
		
		panel.add(list);
		add(panel);
		
		setSize(500, 300);
		Dimension dimension = getSize();
		setLocation((1920 - dimension.width) / 2, (1080 - dimension.height) / 2);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex15List();
	}

}
