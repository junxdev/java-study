package com.bit.day23;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Font;

public class Ex13Checkbox extends Frame {

	public Ex13Checkbox() {
		Panel p = new Panel();
		Font font = new Font("±Ã¼­Ã¼", 0, 22);
		
		CheckboxGroup cbg = new CheckboxGroup();
		
		Checkbox chk01 = new Checkbox("BMW", false, cbg);
		Checkbox chk02 = new Checkbox("Benz", true, cbg);
		Checkbox chk03 = new Checkbox(null, false, cbg);
		chk03.setLabel("Audi");
		
		chk01.setFont(font);
		chk02.setFont(font);
		chk03.setFont(font);
		
		
		p.add(chk01);
		p.add(chk02);
		p.add(chk03);
		
		add(p);
		
		setLocation(200, 300);
		setSize(500, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Ex13Checkbox();
	}

}
