package com.bit.day23;

import java.awt.Frame;
import java.awt.TextArea;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Input;

public class Test03 extends Frame {
	TextArea textArea;

	Test03(int width, int height) {
		textArea = new TextArea();
		add(textArea);
		
		setSize(width, height);
		setLocation((1920 - width) / 2, (1080 - height) / 2);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Test03 ui = new Test03(500, 500);
		
		File file = new File("C:\\javap\\Memo\\0513.txt");
		FileInputStream input = null;
	
		
		if(file.exists()) {
			try {
				input = new FileInputStream(file);
				ArrayList<Byte> array = new ArrayList<>();
				while(true) {
					try {
						int msgToByte = input.read();
						if(msgToByte == -1) {
							break;
						}
						array.add((byte)msgToByte);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Object[] msgToObject = array.toArray();
				byte[] msgToInt = new byte[msgToObject.length];
				for(int i = 0; i < msgToInt.length; i++) {
					msgToInt[i] = (byte)msgToObject[i];
				}
				ui.textArea.setText(new String(msgToInt));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				if(input != null) {
					try {
						input.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
}
