package com.bit.day25;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Notepad01UI extends Frame implements ActionListener{
	String title = "제목 없음";
	MenuItem m1_1, m1_2, m1_3, m1_4, m2_1;
	TextArea ta;
	
	public Notepad01UI() {
		// TODO Auto-generated constructor stub
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		MenuBar mb = new MenuBar();
		Menu m1 = new Menu("파일");
		m1_1 = new MenuItem("새 파일");
		m1_2 = new MenuItem("열기");
		m1_3 = new MenuItem("저장");
		m1_4 = new MenuItem("닫기");
		m1_1.addActionListener(this);
		m1_2.addActionListener(this);
		m1_3.addActionListener(this);
		m1_4.addActionListener(this);
		m1.add(m1_1);
		m1.addSeparator();
		m1.add(m1_2);
		m1.add(m1_3);
		m1.add(m1_4);
		Menu m2 = new Menu("도움말");
		m2_1 = new MenuItem("정보");
		m2_1.addActionListener(this);
		m2.add(m2_1);
		
		mb.add(m1);
		mb.add(m2);
		
		setMenuBar(mb);
		
		ta = new TextArea();
		add(ta);
		
		setTitle(title);
		setSize(500, 400);
		setLocation(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Notepad01UI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object event = e.getSource();
		if(m1_2 == event) {
			FileDialog openDialog = new FileDialog(this, "열기", FileDialog.LOAD);
//			openDialog.setSize(400, 300);
//			openDialog.setLocation(getX() + 100, getY() + 100);
			openDialog.setVisible(true);
			
			String path = openDialog.getDirectory() + openDialog.getFile();
			System.out.println(path);
			File openFile = new File(path);
			FileInputStream fis = null;
			
			if(openFile.exists()) {
				ArrayList<Byte> dataByteList = new ArrayList<>();
				try {
					fis = new FileInputStream(openFile);
					while(true) {
						int dataChunk = fis.read();
						if(dataChunk == -1) {
							break;
						}
						dataByteList.add((byte)dataChunk);
						
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if(fis != null) {
						try {
							fis.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				Object[] dataObject = dataByteList.toArray();
				byte[] dataByte = new byte[dataObject.length];
				for(int i = 0; i < dataByte.length; i++) {
					dataByte[i] = (byte)dataObject[i];
				}
				ta.setText(new String(dataByte));
			}
		}
		if(m1_3 == event) {
			FileDialog saveDialog = new FileDialog(this, "저장", FileDialog.SAVE);
			saveDialog.setVisible(true);
			String path = saveDialog.getDirectory() + saveDialog.getFile();
			File saveFile = new File(path);
			if(!saveFile.exists()) {
				try {
					saveFile.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			String saveData = ta.getText();
			byte[] saveDataByte = saveData.getBytes();
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(saveFile);
				for(int i = 0; i < saveDataByte.length; i++) {
					fos.write((int)saveDataByte[i]);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				if(fos != null) {
					try {
						fos.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
		if(m1_4 == event) {
			dispose();
		}
		
		if(m2_1 == event) {
			Dialog dialog = new Dialog(this, "정보");
			Label label = new Label("by bit class");
			dialog.setLayout(new FlowLayout());
			dialog.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dialog.dispose();
				}
			});
			dialog.add(label);
			dialog.setSize(300, 200);
			dialog.setLocation(this.getX() + 100, this.getY() + 100);
			dialog.setVisible(true);
		}
	}

}
