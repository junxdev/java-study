package com.bit.day24;

import java.awt.Button;
import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class Ex02Menu extends Frame {

	public Ex02Menu() {
		Menu menu01 = new Menu();
		menu01.setLabel("File");
		
		MenuItem menu01_1 = new MenuItem();
		menu01_1.setLabel("New");
		menu01.add(menu01_1);
		MenuItem menu01_2 = new MenuItem();
		menu01_2.setLabel("Save");
		menu01.add(menu01_2);
		menu01.addSeparator();
		MenuItem menu01_3 = new MenuItem();
		menu01_3.setLabel("Exit");
		menu01.add(menu01_3);
		
		Menu menu02 = new Menu();
		menu02.setLabel("Help");
		MenuItem menu02_1 = new CheckboxMenuItem("Welcome");
		menu02.add(menu02_1);
		MenuItem menu02_2 = new CheckboxMenuItem("Keys");
		menu02.add(menu02_2);
		MenuItem menu02_3 = new CheckboxMenuItem("Version");
		menu02.add(menu02_3);
		
		Menu menu03 = new Menu();
		menu03.setLabel("Search");
		Menu menu03_1 = new Menu("Text");
		MenuItem menu03_1_1 = new MenuItem("Workspace");
		menu03_1.add(menu03_1_1);
		menu03.add(menu03_1);
		
		MenuBar mb = new MenuBar();
		mb.add(menu01);
		mb.add(menu02);
		mb.add(menu03);
		
		setMenuBar(mb);
		
		Button btn = new Button();
		add(btn);
		
		setSize(500, 300);
		setLocation(200, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex02Menu();
		
		
	}

}
