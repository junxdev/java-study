package com.bit.student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Student extends JFrame {
	
	JLabel[] table = new JLabel[50];

	private JPanel contentPane;
	private JTextField addNum;
	private JTextField addName;
	private JTextField addKor;
	private JTextField addEng;
	private JTextField addMath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("ÇÐ»ý¼ºÀû°ü¸®ÇÁ·Î±×·¥(ver 0.4.0)");
		label.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 16));
		panel.add(label);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(11, 5, 0, 0));
//		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		JLabel labelNo = new JLabel("\uD559\uBC88");
		centerPanel.add(labelNo);
		
		JLabel labelName = new JLabel("\uC774\uB984");
		centerPanel.add(labelName);
		
		JLabel labelKor = new JLabel("\uAD6D\uC5B4");
		centerPanel.add(labelKor);
		
		JLabel labelEng = new JLabel("\uC601\uC5B4");
		centerPanel.add(labelEng);
		
		JLabel labelMath = new JLabel("\uC218\uD559");
		centerPanel.add(labelMath);
		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{97, 0};
		gbl_panel_2.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton button1 = new JButton("Á¶È¸");
		
		
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.fill = GridBagConstraints.BOTH;
		gbc_button1.insets = new Insets(0, 0, 5, 0);
		gbc_button1.gridx = 0;
		gbc_button1.gridy = 1;
		panel_2.add(button1, gbc_button1);

		JPanel centerPanel2 = new JPanel();
//		contentPane.add(centerPanel2, BorderLayout.CENTER);
		GridBagLayout gbl_centerPanel2 = new GridBagLayout();
		gbl_centerPanel2.columnWidths = new int[]{100, 0, 50};
		gbl_centerPanel2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_centerPanel2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerPanel2.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		centerPanel2.setLayout(gbl_centerPanel2);
		
		JButton button2 = new JButton("ÀÔ·Â");
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.fill = GridBagConstraints.BOTH;
		gbc_button2.insets = new Insets(0, 0, 5, 0);
		gbc_button2.gridx = 0;
		gbc_button2.gridy = 3;
		panel_2.add(button2, gbc_button2);
		
		JButton button3 = new JButton("¼öÁ¤");
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.fill = GridBagConstraints.BOTH;
		gbc_button3.insets = new Insets(0, 0, 5, 0);
		gbc_button3.gridx = 0;
		gbc_button3.gridy = 6;
		panel_2.add(button3, gbc_button3);
		
		JButton button4 = new JButton("»èÁ¦");
		GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.fill = GridBagConstraints.BOTH;
		gbc_button4.insets = new Insets(0, 0, 5, 0);
		gbc_button4.gridx = 0;
		gbc_button4.gridy = 9;
		panel_2.add(button4, gbc_button4);
		
		JButton button5 = new JButton("Á¾·á");
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		GridBagConstraints gbc_button5 = new GridBagConstraints();
		gbc_button5.fill = GridBagConstraints.BOTH;
		gbc_button5.insets = new Insets(0, 0, 5, 0);
		gbc_button5.gridx = 0;
		gbc_button5.gridy = 12;
		panel_2.add(button5, gbc_button5);

		for(int i = 0; i < table.length; i++) {
			table[i] = new JLabel();
			centerPanel.add(table[i]);
		}
		
		JLabel lblNewLabel_3 = new JLabel("\uC785\uB825 \uD398\uC774\uC9C0");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		centerPanel2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel label_1 = new JLabel("\uD559\uBC88");
		label_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		centerPanel2.add(label_1, gbc_label_1);
		
		addNum = new JTextField();
		GridBagConstraints gbc_addNum = new GridBagConstraints();
		gbc_addNum.insets = new Insets(0, 0, 5, 0);
		gbc_addNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_addNum.gridx = 1;
		gbc_addNum.gridy = 1;
		centerPanel2.add(addNum, gbc_addNum);
		addNum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		centerPanel2.add(lblNewLabel, gbc_lblNewLabel);
		
		addName = new JTextField();
		GridBagConstraints gbc_addName = new GridBagConstraints();
		gbc_addName.insets = new Insets(0, 0, 5, 0);
		gbc_addName.fill = GridBagConstraints.HORIZONTAL;
		gbc_addName.gridx = 1;
		gbc_addName.gridy = 2;
		centerPanel2.add(addName, gbc_addName);
		addName.setColumns(10);
		
		JLabel label_2 = new JLabel("\uAD6D\uC5B4");
		label_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		centerPanel2.add(label_2, gbc_label_2);
		
		addKor = new JTextField();
		GridBagConstraints gbc_addKor = new GridBagConstraints();
		gbc_addKor.insets = new Insets(0, 0, 5, 0);
		gbc_addKor.fill = GridBagConstraints.HORIZONTAL;
		gbc_addKor.gridx = 1;
		gbc_addKor.gridy = 3;
		centerPanel2.add(addKor, gbc_addKor);
		addKor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC601\uC5B4");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		centerPanel2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		addEng = new JTextField();
		GridBagConstraints gbc_addEng = new GridBagConstraints();
		gbc_addEng.insets = new Insets(0, 0, 5, 0);
		gbc_addEng.fill = GridBagConstraints.HORIZONTAL;
		gbc_addEng.gridx = 1;
		gbc_addEng.gridy = 4;
		centerPanel2.add(addEng, gbc_addEng);
		addEng.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC218\uD559");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		centerPanel2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		addMath = new JTextField();
		GridBagConstraints gbc_addMath = new GridBagConstraints();
		gbc_addMath.insets = new Insets(0, 0, 5, 0);
		gbc_addMath.fill = GridBagConstraints.HORIZONTAL;
		gbc_addMath.gridx = 1;
		gbc_addMath.gridy = 5;
		centerPanel2.add(addMath, gbc_addMath);
		addMath.setColumns(10);
		
		JButton buttonAdd = new JButton("\uC785\uB825");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = addNum.getText() + ", '" + addName.getText() + "', " + addKor.getText() + ", " + addEng.getText() + ", " + addMath.getText();
				String sql = "insert into student01 values (" + data + ")";
				System.out.println(sql);
				
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
				
				new oracle.jdbc.driver.OracleDriver();
				java.util.Properties prop = new java.util.Properties();
				
				prop.setProperty("user", "scott");
				prop.setProperty("password", "tiger");
				
				java.sql.Connection conn = null;
				java.sql.Statement stmt = null;
				
				try {
					conn = java.sql.DriverManager.getConnection(url, prop);
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						if(stmt != null) stmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		GridBagConstraints gbc_buttonAdd = new GridBagConstraints();
		gbc_buttonAdd.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAdd.anchor = GridBagConstraints.NORTH;
		gbc_buttonAdd.gridwidth = 2;
		gbc_buttonAdd.gridx = 0;
		gbc_buttonAdd.gridy = 6;
		centerPanel2.add(buttonAdd, gbc_buttonAdd);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 7;
		centerPanel2.add(panel_1, gbc_panel_1);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPanel.setVisible(true);
				centerPanel2.setVisible(false);
				contentPane.add(centerPanel, BorderLayout.CENTER);
				
				String sql = "select * from student01";
				new oracle.jdbc.driver.OracleDriver();
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
				java.util.Properties prop = new java.util.Properties();
				prop.setProperty("user", "scott");
				prop.setProperty("password", "tiger");
				
				java.sql.Connection conn = null;
				java.sql.Statement stmt = null;
				java.sql.ResultSet rs = null;
				try {
					conn = java.sql.DriverManager.getConnection(url, prop);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					int count = 0;
					while(rs.next()) {
						for(int i = 0; i < 5; i++) {
							String data = rs.getString(i + 1);
							table[count++].setText(data);
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPanel.setVisible(false);
				centerPanel2.setVisible(true);
				contentPane.add(centerPanel2, BorderLayout.CENTER);
			}
		});
	}

}
