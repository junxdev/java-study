package com.bit.day24;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowListener;

public class Ex04Canvas extends Frame {
	
	class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			g.drawString("Welcome", 400, 400);
			g.drawLine(10, 10, 100, 100);
			g.setColor(Color.BLUE);
			g.drawRect(200, 200, 10, 10);
			g.drawArc(500, 500, 30, 30, 90, 270);
			g.drawOval(300, 200, 80, 80);
		}
	}
	
	Ex04Canvas() {
		
		Canvas canvas = new MyCanvas();
		
		add(canvas);
		setSize(800, 600);
		setLocation(202, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex04Canvas();
	}

}
