package com.bit.day24;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Ex08MouseMotion extends Frame implements MouseMotionListener{

	public Ex08MouseMotion() {
		// TODO Auto-generated constructor stub
		Panel panel = new Panel();
		
		panel.addMouseMotionListener(this);
		
		add(panel);
		
		setSize(500, 600);
		setLocation(400, 200);
		setVisible(true);
		System.out.println(panel.getWidth() + ", " + panel.getHeight());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex08MouseMotion();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseDragged");
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		System.out.println("mouseMoved" + " x : " + x + " y : " +  y);
	}

}
