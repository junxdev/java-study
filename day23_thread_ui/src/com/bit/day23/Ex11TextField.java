package com.bit.day23;

import java.awt.Font;

public class Ex11TextField extends java.awt.Frame{
	
	static java.awt.TextField tf = null;

	public Ex11TextField() {
		Font font = new Font(Font.MONOSPACED, Font.ITALIC, 22);
		java.awt.Panel p = new java.awt.Panel();
		
		tf = new java.awt.TextField(15);
		tf.setText("example");
		tf.setEchoChar('*');
		p.add(tf);
		
		java.awt.Button bt = new java.awt.Button("OK");
		bt.setFont(font);
		bt.setSize(200, 200); // Element의 위치와 크기는 배치관리자가 제어하므로 임의로 제어할 수 없음
		p.add(bt);
		add(p);
		
		setLocation(1920 / 2 - 500 / 2, 1080 / 2 - 300 / 2); // 좌측 상단 꼭짓점 위치
		setSize(500, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex11TextField();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(tf.getText());
	}

}
