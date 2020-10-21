package com.bit.day26;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test01Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<HashMap<String, Object>> data = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		String menu = "1.조회 2.입력 3.수정 4.삭제 0.종료 : ";
		String column = "학번\t이름\t국어\t영어\t수학\t합계\t평균";
		String line = "----------------------------------------------------";
		String input;
		
		System.out.println("성적관리 프로그램 ver 0.2.2");
		System.out.println(line);
		
		String path = "studentData.bin";
		File file = new File(path);
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  파일 생성//		
		if(!file.exists()) {
			try {
				System.out.println("기존에 저장된 데이터가 없습니다.\n");
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  파일 열기//		
		try {
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			while(true) {
				HashMap<String, Object> student = new HashMap<>();
										
				student.put("number", dis.readInt());
				student.put("name", dis.readUTF());
				student.put("korean", dis.readInt());
				student.put("english", dis.readInt());
				student.put("math", dis.readInt());
				
				data.add(student);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		} finally {
			try {
				if(dis != null) {
					dis.close();
				}
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  메뉴 선택//		
		while(true) {
			System.out.print(menu);
			input = scanner.nextLine();
			
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  종료//
			if("0".equals(input)) {
				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					fos = new FileOutputStream(file);
					dos = new DataOutputStream(fos);
					
					for(int i = 0; i < data.size(); i++) {
						HashMap<String, Object> student = data.get(i);
						
						int number = (int)student.get("number");
						String name = (String)student.get("name");
						int korean = (int)student.get("korean");
						int english = (int)student.get("english");
						int math = (int)student.get("math");
						
						dos.writeInt(number);
						dos.writeUTF(name);
						dos.writeInt(korean);
						dos.writeInt(english);
						dos.writeInt(math);
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if(dos != null) {
							dos.close();
						}
						if(fos != null) {
							fos.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  조회//	
			} else if("1".equals(input)) {
				System.out.println(column);
				System.out.println(line);

				for(int i = 0; i < data.size(); i++) {
					HashMap<String, Object> student = data.get(i);
					
					int number = (int)student.get("number");
					String name = (String)student.get("name");
					int korean = (int)student.get("korean");
					int english = (int)student.get("english");
					int math = (int)student.get("math");
					int total = korean + english + math;
					double avg = (total * 100 / 3) / 100.0;
					
					System.out.println(number + "\t" + name + "\t" + korean + "\t" + english + "\t" + math + "\t" + total + "\t" + avg);
				}
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  입력//			
			} else if("2".equals(input)) {
				HashMap<String, Object> student = new HashMap<>();
				
				System.out.print("학번 : ");
				int number = Integer.parseInt(scanner.nextLine());
				System.out.print("이름 : ");
				String name = scanner.nextLine();
				System.out.print("국어 : ");
				int korean = Integer.parseInt(scanner.nextLine());
				System.out.print("영어 : ");
				int english = Integer.parseInt(scanner.nextLine());
				System.out.print("수학 : ");
				int math = Integer.parseInt(scanner.nextLine());
				
				student.put("number", number);
				student.put("name", name);
				student.put("korean", korean);
				student.put("english", english);
				student.put("math", math);
				
				data.add(student);
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  수정//				
			} else if("3".equals(input)) {
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  삭제//				
			} else if("4".equals(input)) {
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  메뉴 입력 오류//				
			} else {
				System.out.println("error");
			}
		}
	}

}
