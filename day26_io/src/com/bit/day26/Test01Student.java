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
		
		String menu = "1.��ȸ 2.�Է� 3.���� 4.���� 0.���� : ";
		String column = "�й�\t�̸�\t����\t����\t����\t�հ�\t���";
		String line = "----------------------------------------------------";
		String input;
		
		System.out.println("�������� ���α׷� ver 0.2.2");
		System.out.println(line);
		
		String path = "studentData.bin";
		File file = new File(path);
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  ���� ����//		
		if(!file.exists()) {
			try {
				System.out.println("������ ����� �����Ͱ� �����ϴ�.\n");
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  ���� ����//		
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
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  �޴� ����//		
		while(true) {
			System.out.print(menu);
			input = scanner.nextLine();
			
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  ����//
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
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  ��ȸ//	
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
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  �Է�//			
			} else if("2".equals(input)) {
				HashMap<String, Object> student = new HashMap<>();
				
				System.out.print("�й� : ");
				int number = Integer.parseInt(scanner.nextLine());
				System.out.print("�̸� : ");
				String name = scanner.nextLine();
				System.out.print("���� : ");
				int korean = Integer.parseInt(scanner.nextLine());
				System.out.print("���� : ");
				int english = Integer.parseInt(scanner.nextLine());
				System.out.print("���� : ");
				int math = Integer.parseInt(scanner.nextLine());
				
				student.put("number", number);
				student.put("name", name);
				student.put("korean", korean);
				student.put("english", english);
				student.put("math", math);
				
				data.add(student);
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  ����//				
			} else if("3".equals(input)) {
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  ����//				
			} else if("4".equals(input)) {
// *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  �޴� �Է� ����//				
			} else {
				System.out.println("error");
			}
		}
	}

}
