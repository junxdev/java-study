package Project;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout; 
import java.awt.Label;
import java.awt.Panel;

import javax.swing.*; 

import java.awt.event.*; 
import java.io.IOException;


	public class Project implements ActionListener{

//멤버 변수선언
		JFrame f; 
		int su = 4;  
		JButton [][] btn = new JButton [su][su]; 

		int [][] answer = new int[su][su]; 

		JLabel[] img = new JLabel[8]; 

		JButton click = null; 
		
		int first=0, second=0; 
 
//객체 생성
		public Project() { 
			f = new JFrame("Find a same pic"); 
			for(int i = 0; i<4;i++) { 
				for(int j = 0;j<4;j++) { 
					btn[i][j] = new JButton(); 
				} 
			} 

	
	
	
	
}//end of Project 






//화면 붙이기 및 출력
void addLayout() { 

	
	f.setLayout(new GridLayout(5, 10)); 
	
	for(int i = 0;i<su;i++) { 
		for (int j = 0 ;j<su;j++) { 
			f.add(btn[i][j]); 



//문자를 '0' 
		answer[i][j] = '0'; 
		btn[i][j].addActionListener(this); 
		} 
	} 
	
// 종료 버튼, 현황 표기
	
	
	Button exit=new Button("Exit");
	f.add(BorderLayout.SOUTH, exit);
	  	  
	exit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			f.dispose();
		}
	});
	

	
	
	f.setSize(800, 800);
	f.setLocation(200, 0);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	

	
}//end of addLayout 


	


	void initChar() { 
		int correct =0; 

		DASI: 
			for(int i=0;i<16;) { 
			//임의의 그림 만들기 
				if(i%2==0) { 
					correct = (int)(Math.random()*8); 

			// 기존의 그림과 동일한걸 찾으면
					for(int r = 0;r<su;r++) { 
						for (int c = 0 ;c<su;c++) { 
							if( answer[r][c] == correct) continue DASI; 
						} 

					}// end of
				} 

// 임의의 위치에 지정 
				boolean boo = false; 
				do { 
					int one = (int)(Math.random()*4); 
					int two = (int)(Math.random()*4); 
						if(answer[one][two] == '0') { 
							answer[one][two]=correct; 
							i++; 
							boo = true; 
						} 
				}while(!boo); 
			} 
	} 

	void showAnswer() { 
		// 그림을 버튼에 지정하기 
		for(int i=0 ; i<su;i++) { 
			for(int j=0;j<su;j++) { 
				btn[i][j].setIcon(new ImageIcon ("C:\\Javaworkspace\\Project\\a"+answer[i][j]+".jpg")); 

			} 
		} 

		//버튼에서 그림을 1초후에 지우기 
		try { 
			Thread.sleep(1000); 
		}catch(Exception ex) {} 


			for(int i=0 ; i<su;i++) { 
				for(int j=0;j<su;j++) { 
					btn[i][j].setIcon(null); 
				} 

			}//end of 1초후에 지우기 

}//end of showAnswer 

	public void actionPerformed(ActionEvent e) { 

		JButton b = (JButton)e.getSource();  
		
		for(int i=0 ; i<su;i++) { 
			for(int j=0;j<su;j++) { 
				if(b == btn[i][j]) { 

			


						if(click == null) { //첫번째 선택시 
					click = b; 
					first = i; 
					second = j; 
					click.setIcon(new ImageIcon ("C:\\Javaworkspace\\Project\\a"+answer[first][second]+".jpg")); 

						}else { //두번째 선택시 
					if(answer[i][j]==answer[first][second]) { 

					b.setIcon(new ImageIcon ("C:\\Javaworkspace\\Project\\a"+answer[first][second]+".jpg")); 
					

					}else { 
						try { 
//								Thread.sleep(500); 
							}catch(Exception ex) {} 


								for(int i1=0 ; i1<su;i1++) { 
									for(int j1=0;j1<su;j1++) { 
										btn[i1][j1].setIcon(null); 
									} 
									click.setIcon(null); 

								} 
					if(i== first && i == second) { 
					continue; 
					} 


					click= null; 

					}
				} 
		
						}
				}
		
			}
}//end of actionPerformed 

	

//메인함수
	public static void main(String[] args) { 

		Project g = new Project(); 
		g.addLayout(); 
		g.initChar(); 
		g.showAnswer(); 

		
	
	

	}//end of main 


}