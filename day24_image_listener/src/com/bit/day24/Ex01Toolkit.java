package com.bit.day24;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ex01Toolkit extends Frame {

	public Ex01Toolkit() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		byte[] data = null;
		File file = new File("C:\\Users\\bitcamp\\Pictures\\scissors.png");
		System.out.println(file.exists());
		System.out.println(file.length());
		System.out.println((int)file.length());
		FileInputStream fis = null;
		if(file.exists()) {
			try {
				data = new byte[(int)file.length()];
				fis = new FileInputStream(file);
				for(int i = 0; i < (int)file.length(); i++) {
					data[i] = (byte)fis.read();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		Icon icon = new ImageIcon(data);
		JButton btn01 = new JButton(icon);
		add(btn01);
		
//		System.out.println(dim.getWidth());
//		System.out.println(dim.getHeight());
		
		setSize(icon.getIconWidth(), icon.getIconHeight());
		Dimension dim = tool.getScreenSize();
		setLocation((dim.width - getWidth()) / 2, (dim.height - getHeight()) / 2);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Ex01Toolkit();
	}

}
