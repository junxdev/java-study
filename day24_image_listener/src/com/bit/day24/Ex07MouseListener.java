package com.bit.day24;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ex07MouseListener extends Frame implements MouseListener{

	public Ex07MouseListener() {
		
		
		Panel panel = new Panel();
		
		Button button = new Button("¹öÆ°");
		panel.add(button);
		panel.addMouseListener(this);
		add(panel);
		
		setSize(500, 500);
		setLocation(200, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex07MouseListener();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseClicked");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseReleased");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseEntered");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseExited");
	}

}
