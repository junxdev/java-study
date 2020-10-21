package com.bit.game;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

 
 

 

import java.util.Random;

 


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


	public class Ui extends Frame implements ActionListener{

		Frame f2;
		JButton[] btns;
		Panel cardpanel;
		int score;
		boolean paired;
		
		@Override
		public void actionPerformed(ActionEvent e) {

			
			
			
		}
	
		Ui(){

			addWindowListener(new WindowAdapter() {

				@Override

				public void windowClosing(WindowEvent e) {

					System.exit(0);
				}

			});

			JButton btn= new JButton("접속하기");

			JButton btn2= new JButton("종료");
 
			btn2.addActionListener(new ActionListener(){

				@Override

				public void actionPerformed(ActionEvent e) {

					System.exit(0);

				}

			});

	      btn.addActionListener(new ActionListener(){

				@Override

				public void actionPerformed(ActionEvent e) {

					setVisible(false);

					f2.setVisible(true);
				}

			});

			setLayout(null);

			add(btn);

			add(btn2);

			btn.setBounds(400, 350, 200, 100);

			btn2.setBounds(450, 500, 100, 50);

			setTitle("프로젝트(카드뒤집기게임)");

			setSize(1000,800);

			setLocation(475,150);

			setVisible(true);

			f2=new Frame();

			f2.setTitle("게임화면");

			f2.setSize(1000,800);

			f2.setLocation(475,150);

			 f2.setLayout(null);


			 JLabel label2 = new JLabel("점수="+score);

			 JLabel label3 = new JLabel("상대방이 카드를 선택중입니다.");

			  label2.setSize(130, 30);  //크키 설정

			  label2.setLocation(200, 750); //위치 설정

			  label3.setSize(180, 30);  //크키 설정
			  label3.setLocation(10, 750); //위치 설정
		       label2.setOpaque(true); 
		       label2.setBackground(Color.RED);
		       label3.setOpaque(true); 
		       label3.setBackground(Color.RED);
		       f2.add(label2);
			   f2.add(label3);
		       Button bt= new Button("시작");
		       Button bt2= new Button("준비");
		       Button bt3= new Button("종료");
		       f2.add(bt);
			   f2.add(bt2);
			   f2.add(bt3);
			      bt.setSize(50, 30);  //크키 설정
				  bt.setLocation(900, 650); //위치 설정
				  bt2.setSize(50, 30);  //크키 설정
				  bt2.setLocation(900, 700); //위치 설정
				  bt3.setSize(50, 30);  //크키 설정
				  bt3.setLocation(900, 750); //위치 설정
				  bt.setEnabled(false);
				  f2.setLayout( new BorderLayout());

				  cardpanel=new Panel();

				  f2.add(cardpanel);	

				  cardpanel.setLayout(new GridLayout(5,10));
					btns=new JButton[16];
				
					for(int i=0; i<btns.length; i++){	
						btns[i]=new JButton();
						cardpanel.add(btns[i]);
						btns[i].setEnabled(false);		
						
						btns[i].addActionListener(new ActionListener(){
							 

							@Override

							public void actionPerformed(ActionEvent e) {


							}

					});
						btns[i].addActionListener(new ActionListener(){ 
							@Override
							public void actionPerformed(ActionEvent e) {
								
								Random ran=new Random();
								int su=ran.nextInt(3)+1;
								Random ran2=new Random();
								int sa=ran2.nextInt(3)+1;  
								
								
								if(e.getSource() == btns[0]){btns[0].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[1]){btns[1].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[2]){btns[2].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[3]){btns[3].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[4]){btns[4].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[5]){btns[5].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[6]){btns[6].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[7]){btns[7].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[8]){btns[8].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[9]){btns[9].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[10]){btns[10].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[11]){btns[11].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[12]){btns[12].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[13]){btns[13].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[14]){btns[14].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[15]){btns[15].setIcon(new ImageIcon(su+sa+".jpg")); }
								else if(e.getSource() == btns[11]){btns[11].setIcon(new ImageIcon(su+sa+".jpg")); }
							
					           
								
							
							}
							
						
						});
						
						
				
					
					}
					
				
			
				
					
		
					
					
				
					
					
					f2.addWindowListener(new WindowAdapter() {

						@Override

						public void windowClosing(WindowEvent e) {

							System.exit(0);
						}

					});
					
					
				    bt.addActionListener(new ActionListener(){
 

						@Override

						public void actionPerformed(ActionEvent e) {

							for(int i=0; i<btns.length; i++){	

							btns[i].setEnabled(true);

							}

						}

				});

				    bt2.addActionListener(new ActionListener(){

						@Override

						public void actionPerformed(ActionEvent e) {
							
							bt.setEnabled(true);

						}

				});

			     bt3.addActionListener(new ActionListener(){


						@Override

						public void actionPerformed(ActionEvent e) {

						System.exit(0);

						}

				});

		}


			

	}