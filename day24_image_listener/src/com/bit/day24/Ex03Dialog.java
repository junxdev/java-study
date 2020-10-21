package com.bit.day24;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;

public class Ex03Dialog extends Frame {

	public Ex03Dialog() {
		
		setSize(800, 600);
		setLocation(500, 500);
		setVisible(true);
		
		Dialog dialog = new Dialog(this, "New Window");
		dialog.add(new Button("Button"));
		dialog.setSize(300, 300);
		dialog.setLocation(500 + 800 / 2 - 300 / 2, 500 + 600 / 2 - 300 / 2);
		dialog.setVisible(true);
		
		FileDialog fileDialog = new FileDialog(this, "File", FileDialog.SAVE);
		fileDialog.setVisible(true);
		System.out.println(fileDialog.getDirectory());
		System.out.println(fileDialog.getFile());
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex03Dialog();
	}

}
