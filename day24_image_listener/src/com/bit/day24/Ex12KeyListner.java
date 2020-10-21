package com.bit.day24;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex12KeyListner extends Frame implements KeyListener{
	
	TextField tf;
	Button btn;
	Panel xp;
	
	Label ammo;

	public Ex12KeyListner() {
		Panel p = new Panel();
		p.setLayout(null);
		tf = new TextField(10);
		addKeyListener(this);
//		p.add(tf);
		
		btn = new Button();
//		p.add(btn);
		
		xp = new Panel();
		xp.setSize(25, 25);
		xp.setLocation(200, 200);
		xp.setLayout(new GridLayout(3, 1));
		
		Label label = new Label("  l ");
		Label label2 = new Label("  l ");
		Label label3 = new Label("lllll");
		xp.add(label);
		xp.add(label2);
		xp.add(label3);
		
		ammo = new Label("^^^^^");
		ammo.setSize(10, 10);
		ammo.setLocation(500, 500);
		
		p.add(ammo);
		p.add(xp);
		add(p);
		
		setSize(500, 300);
		setLocation(300, 200);
		setVisible(true);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped : " + e.getKeyCode());
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyPressed : " + e.getKeyCode());
		int x = xp.getX();
		int y = xp.getY();
		if(e.getKeyCode() == 38) {
			xp.setLocation(x, y - 10);
		} else if(e.getKeyCode() == 40) {
			xp.setLocation(x, y + 10);
		} else if(e.getKeyCode() == 39) {
			xp.setLocation(x + 10, y);
		} else if(e.getKeyCode() == 37) {
			xp.setLocation(x - 10, y);
		} else if(e.getKeyCode() == 32) {
			for(int i = 0; i < 30; i++) {
				ammo.setLocation(x + 2, y - ((i + 1) * 10));	
			} 
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyReleased : " + e.getKeyCode());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex12KeyListner();
	}

}
