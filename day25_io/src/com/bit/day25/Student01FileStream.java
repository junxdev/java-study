package com.bit.day25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//���� HashMap�� �� �ݸ� HaspMap�� �ϳ��� �л� ������ �����ϰ� �л� ����� ArrayList�� �Ѵ�.
// HashMap�� �� ������ Key�� �� Column�� ��ǥ�ϱ� ������ ������ ȣ���� �ξ� ���� �������̴�.
// HashMap<Integer, Object[]> �й����� �����ϱ⿡ ������ ���� ���ϸ� �ڷ��� ũ�Ⱑ �۾� �޸� ȿ������ ����. ������ ���� �迭�� ����Ͽ� �������� ����.
// HashMap<Integer, class> ������ ����ȯ�� �ʿ� ����. ��ü�� �ٷ�� ������ ���� ���ſ� �� ������ ������ �Ĥ��� ��翡���� ������ ����.
// HashMap<Integer, HashMap<String, class>> ���� ������ ������ ��� �����Ѵ�.
// ArrayList<HashMap<String, String>> IO���� ���谡 ���� ���ϴ�.

public class Student01FileStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<HashMap<String, String>> data = null; 
		data = new ArrayList<>();
		
		String path = "data.bin";
		File file = new File(path);
		FileInputStream fis = null;
		if(file.exists()) {
			ArrayList<Byte> dataByteList = new ArrayList<>();
//			byte[] dataByte = new byte[(int)file.length()];
			try {
				fis = new FileInputStream(file);
				while(true) {
					int dataChunk = fis.read();
					if(dataChunk == -1) {
						break;
					}
					dataByteList.add((byte)dataChunk);
					
				}
//				for(int i = 0; i < dataByte.length; i++) {
//					int dataChunk = fis.read();
//					if(dataChunk == -1) {
//						break;
//					}
//					dataByte[i] = (byte)dataChunk;
//				}
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
			
			Object[] dataObject = dataByteList.toArray();
			byte[] dataByte = new byte[dataObject.length];
			for(int i = 0; i < dataByte.length; i++) {
				dataByte[i] = (byte)dataObject[i];
			}
			String dataString = new String(dataByte);
			
			String[] dataStringArray = dataString.split("\n");
			for(int i = 0; i < dataStringArray.length; i++) {
				String studentString = dataStringArray[i];
				String[] studentStringArray = studentString.split(", ");
				HashMap<String, String> student = new HashMap<>();
				student.put("number", studentStringArray[0]);
				student.put("name", studentStringArray[1]);
				student.put("kor", studentStringArray[2]);
				student.put("eng", studentStringArray[3]);
				student.put("math", studentStringArray[4]);
				data.add(student);
			}
			
			
		}
		
		String title = "�����������α׷� ver 0.2.2";
		String menu = "1.��ȸ 2.�Է� 3.���� 4.���� 0.���� �� ����> ";
		
		Scanner scanner = new Scanner(System.in);
		String input = null;

		System.out.println(title);
		System.out.println("---------------------------------\n\n");
		
		while(true) {
			System.out.print(menu);
			input = scanner.nextLine();
			
			if("0".equals(input)) {
				if(!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				FileOutputStream fos = null;
				String tempData = "";
				for(int i = 0; i < data.size(); i++) {
					HashMap<String, String> student = data.get(i);
					String number = student.get("number");
					String name = student.get("name");
					String kor = student.get("kor");
					String eng = student.get("eng");
					String math = student.get("math");
					tempData += number + ", " + name +  ", " + kor +  ", " + eng +  ", " + math + "\n";
				}
				try {
					 fos = new FileOutputStream(file);
					 
					 byte[] byteData = tempData.getBytes();
//					 fos.write(byteData); �� �� ����
					 for(int i = 0; i < byteData.length; i++) {
						 fos.write((int)byteData[i]);
					 }
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if(fos != null) {
						try {
							fos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				break;
				
			} else if("1".equals(input)) {
				System.out.println("-------------------------------------------------------");
				System.out.println("�й�\t�̸�\t����\t����\t����\t�հ�\t���");
				System.out.println("-------------------------------------------------------");
				for(int i = 0; i < data.size(); i++) {
					HashMap<String, String> student = new HashMap<>();
					student = data.get(i);
					int number = Integer.parseInt(student.get("number"));
					String name = student.get("name");
					int kor = Integer.parseInt(student.get("kor"));
					int eng = Integer.parseInt(student.get("eng"));
					int math = Integer.parseInt(student.get("math"));
					int total = kor + eng + math;
					double avg = (total * 100 / 3) / 100;
					System.out.println(number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + avg);
				}
				
			} else if("2".equals(input)) {
				HashMap<String, String> student = null;
				student = new HashMap<>();
				System.out.print("�й� > ");
				student.put("number", scanner.nextLine());
				System.out.print("�̸� > ");
				student.put("name", scanner.nextLine());
				System.out.print("���� > ");
				student.put("kor", scanner.nextLine());
				System.out.print("���� > ");
				student.put("eng", scanner.nextLine());
				System.out.print("���� > ");
				student.put("math", scanner.nextLine());
				data.add(student);
				
			} else if("3".equals(input)) {
				System.out.print("������ �й� > ");
				input = scanner.nextLine();
				for(int i = 0; i < data.size(); i++) {
					HashMap<String, String> student = data.get(i);
					if(input.equals(student.get("number"))) {
						student.put("number", input);
						System.out.print("�̸� > ");
						student.put("name", scanner.nextLine());
						System.out.print("���� > ");
						student.put("kor", scanner.nextLine());
						System.out.print("���� > ");
						student.put("eng", scanner.nextLine());
						System.out.print("���� > ");
						student.put("math", scanner.nextLine());
						data.set(i, student);
						break;
					}
				}
				
			} else if("4".equals(input)) {
				System.out.print("������ �й� > ");
				input = scanner.nextLine();
				for(int i = 0; i < data.size(); i++) {
					HashMap<String, String> student = data.get(i);
					if(input.equals(student.get("number"))) {
						data.remove(i);
						break;
					}
				}
			} else {
				System.out.println("�Է� ����");
				System.out.println("�ùٸ� �޴� ��ȣ�� �Է��ϼ���");
			}
		}
	}

}
