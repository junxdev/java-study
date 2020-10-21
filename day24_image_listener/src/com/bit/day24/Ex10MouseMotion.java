package com.bit.day24;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Ex10MouseMotion extends Frame implements MouseMotionListener{
	
	Button button;
	
	Ex10MouseMotion() {
		Panel p = new Panel();
		p.setLayout(null);
		p.addMouseMotionListener(this);
		
		button = new Button();
		button.setSize(50, 50);
//		button.setLocation(600, 600);
		
		p.add(button);
		add(p);
		setSize(600, 600);
		setLocation(200, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex10MouseMotion();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		button.setLocation(x, y);
	}

}
