package com.bit.day24;

import java.awt.*;
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

class windowsAdapter extends WindowAdapter {
	
}

public class Test01Notepad extends Frame implements ActionListener {

	Frame test01 = null;
	
	File file = null;
	FileInputStream fis = null;
	FileOutputStream fos = null;
	
	TextArea textArea;
	MenuItem menuFile_New;
	MenuItem menuFile_Open;
	MenuItem menuFile_Save;
	MenuItem menuFile_Close;
	MenuItem menuHelp_Information;
	
	Test01Notepad() {
		setSize(800, 600);
		setLocation(200, 200);
		setVisible(true);
		
		addWindowListener(new windowsAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		Menu menuFile = new Menu("파일");
		menuFile_New = new MenuItem("새 파일");
		menuFile_Open = new MenuItem("열기");
		menuFile_Save = new MenuItem("저장");
		menuFile_Close = new MenuItem("종료");
		menuFile_New.addActionListener(this);
		menuFile_Open.addActionListener(this);
		menuFile_Save.addActionListener(this);
		menuFile_Close.addActionListener(this);
		menuFile.add(menuFile_New);
		menuFile.add(menuFile_Open);
		menuFile.add(menuFile_Save);
		menuFile.add(menuFile_Close);
		
		Menu menuHelp = new Menu("도움말");
		menuHelp_Information = new MenuItem("정보");
		menuHelp_Information.addActionListener(this);
		menuHelp.add(menuHelp_Information);
		
		MenuBar menuBar = new MenuBar();
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		setMenuBar(menuBar);
		
		Panel mainPanel = new Panel();
		
		textArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_BOTH);
		mainPanel.add(BorderLayout.NORTH, textArea);
		
		Panel belowPanel = new Panel();
		
		mainPanel.add(BorderLayout.CENTER, belowPanel);
		
		GridBagLayout layout = new GridBagLayout();
		mainPanel.setLayout(layout);
		
		GridBagConstraints constraintsMainPanel = new GridBagConstraints();
		constraintsMainPanel.fill = GridBagConstraints.BOTH;
		constraintsMainPanel.gridx = 0;
		constraintsMainPanel.gridy = 0;
		constraintsMainPanel.gridwidth = 20;
		constraintsMainPanel.gridheight = 1;
		constraintsMainPanel.weightx = 1;
		constraintsMainPanel.weighty = 1;
		layout.addLayoutComponent(textArea, constraintsMainPanel);

		constraintsMainPanel.gridx = 0;
		constraintsMainPanel.gridy = 1;
		constraintsMainPanel.gridwidth = 20;
		constraintsMainPanel.gridheight = 1;
		constraintsMainPanel.weightx = 1;
		constraintsMainPanel.weighty = 0;
		layout.addLayoutComponent(belowPanel, constraintsMainPanel);
		
		add(mainPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource());
		if(e.getSource().equals(menuFile_New)) {
			new Test01Notepad();
			
		} else if(e.getSource().equals(menuFile_Open)) {
			FileDialog fileOpen = new FileDialog(this, "열기", FileDialog.LOAD);
			fileOpen.setVisible(true);
			ArrayList<Byte> data = null;
			String txtCopied = null;
			if(fileOpen.getFile() != null) {
				file = new File(fileOpen.getFile());
				if(file.exists()) {
					try {
						data = new ArrayList<>();
						fis= new FileInputStream(file);
						for(int i = 0; i < file.length(); i++) {
							byte read = (byte)fis.read();
							if(read == -1) {
								break;
							}
							data.add(read);
						}
						char[] dataChar = new char[data.size()];
						for(int i = 0; i < data.size(); i++) {
							dataChar[i] = (char)(int)data.get(i);
						}
						txtCopied = String.copyValueOf(dataChar);
						textArea.setText(txtCopied);
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
				}
			}
			
		} else if(e.getSource().equals(menuFile_Save)) {
			try {
				FileDialog fileSave = new FileDialog(this, "저장", FileDialog.SAVE);
				fileSave.setVisible(true);
				String file = fileSave.getFile();
				if(file != null) {
					fos = new FileOutputStream(file);
					byte[] data = textArea.getText().getBytes();
					for(int i = 0; i < data.length; i++) {
						fos.write(data[i]);
					}
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
		
		} else if(e.getSource().equals(menuFile_Close)) {
			dispose();
		} else if(e.getSource().equals(menuHelp_Information)) {
			callInformation();
		}
		
	}
	
	void callInformation() {
		Dialog information = new Dialog(this, "메모장 정보");
		information.setVisible(true);
		information.addWindowListener(new windowsAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				information.dispose();
			}
		});
		information.setSize(300, 400);
		information.setLocation(250, 250);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test01Notepad();
	}

}
