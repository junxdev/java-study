package com.bit.flipit0622;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Test extends Frame{

	public Test() {
		// TODO Auto-generated constructor stub
		setSize(600, 600);
		setLocation(400,400);
		setVisible(true);
		setLayout(new GridLayout(1, 1));
		
		Panel p = new Panel();
		p.setLayout(new GridLayout(3, 1));
		add(p);
		
		p.add(new Label("123"));
		p.add(new Button("123"));
		JButton jb = new JButton(new ImageIcon("scissors.png"));
		System.out.println(jb.getWidth() + ", " + jb.getHeight());
		
		
//		jb.setPreferredSize(new Dimension(100, 100));
		p.add(jb);
		
		revalidate();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "1.jpg";
		File file = new File(path);
		System.out.println(file.exists());
		System.out.println(new File("scissors.png").exists());
		System.out.println(file.getAbsolutePath());
		
		new Test();
	}

}
