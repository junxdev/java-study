package com.bit.day24;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ex11DoubleClick extends Frame implements MouseListener {
	int count = 0;
	long before, after;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("click");
		count++;
		if(count == 1) {
			before = System.currentTimeMillis();
		} else if(count == 2) {
			after = System.currentTimeMillis();
			if(after - before < 1000) {
				System.out.println("double click");
				count = 0;
			} else {
				before = after;
				count = 1;
			}
		}
	}

	public Ex11DoubleClick() {
		addMouseListener(this);
		setSize(400, 300);
		setLocation(200, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Ex11DoubleClick();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
