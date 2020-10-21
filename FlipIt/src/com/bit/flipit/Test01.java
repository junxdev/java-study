package com.bit.flipit;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class TestButton extends JButton {
	int value;
	
	public TestButton(int i) {
		this.value = i + 3;
		// TODO Auto-generated constructor stub
	}

}
public class Test01 extends Frame implements ActionListener, Runnable{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void flip() {
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	Test01() {
		setLayout(new GridLayout(3,3));
		setSize(500, 500);
		setLocation(300, 300);
//		add(new TestButton(1));
		TestButton[] arr = new TestButton[9]; 
		
		for(int i = 0; i < 9; i++) {
			TestButton b = new TestButton(i);
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					b.setText("" + b.value);
					System.out.println(b.value);
				}
			});

			arr[i] = b;

		}
		for(int i = 0; i < 9; i++) {
			add(arr[i]);
		}
		
//		a.setText("11");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test01();
	}

}
