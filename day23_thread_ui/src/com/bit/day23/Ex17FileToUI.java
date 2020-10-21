package com.bit.day23;

import java.awt.Frame;
import java.awt.TextArea;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Ex17FileToUI extends Frame {
	TextArea ta;
	
	public Ex17FileToUI() {
		ta = new TextArea();
		add(ta);
		setLocation(200, 200);
		setSize(800 ,600);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Byte> list = new ArrayList<>();
		
		Ex17FileToUI me = new Ex17FileToUI();
		
		File file = new File("C:\\javap\\day23\\src\\com\\bit\\day23\\test.txt");
		System.out.println(file.exists());
		System.out.println(new File("Ex17.java").exists());
		
		FileInputStream fis = null;
		
		if(file.exists()) {
			try {
				fis = new FileInputStream(file);
				while(true) {
					int su = fis.read();
					if(su == -1) {
						break;
					}
					list.add((byte)su);
				}
				Object[] arr = list.toArray();
				byte[] charArr = new byte[arr.length];
				for(int i = 0; i < charArr.length; i++) {
					charArr[i] = (byte)arr[i];
				}
				me.ta.setText(new String(charArr));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
				if(fis != null) {
						fis.close();
					}
				} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
		}
	}

}
