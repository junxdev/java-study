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
import java.util.Scanner;

public class Student01DataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data3.bin";
		File file = new File(path);
		
		String bar = "---------------------------------------------------";
		
		Scanner sc = new Scanner(System.in);
		String input = null;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		while(true) {
			System.out.print("1.���� 2.�Է� 0.���� > ");
			input = sc.nextLine();
			if("0".equals(input)) {
				System.out.println("�̿����ּż� �����մϴ�.");
				break;
			} else if("1".equals(input)) {
				System.out.println(bar);
				System.out.println("�й�\t�̸�\t����\t����\t����\t�հ�\t���");
				System.out.println(bar);
				
				try {
					fis = new FileInputStream(file);
					dis = new DataInputStream(fis);
					
					while(true) {
						int num = dis.readInt();
						String name = dis.readUTF();
						int kor = dis.readInt();
						int eng = dis.readInt();
						int math = dis.readInt();
						int total = kor + eng + math;
						double avg = (total * 100 / 3) / 100.0;
						
						System.out.println(num + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + avg);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EOFException e) {
					// �ݺ����� ���߱� ���� ���ܷ� ������ ���Ƿ� ������� �ʴ´�.
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
			} else if("2".equals(input)) {
				System.out.print("�й� > ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.print("�̸� > ");
				String name = sc.nextLine();
				System.out.print("���� > ");
				int kor = Integer.parseInt(sc.nextLine());
				System.out.print("���� > ");
				int eng = Integer.parseInt(sc.nextLine());
				System.out.print("���� > ");
				int math = Integer.parseInt(sc.nextLine());
				
				try {
					fis = new FileInputStream(file);
					dis = new DataInputStream(fis);
					
					// ���� �����Ϳ� �߰��ϱ� : �ڷᱸ���� ���� �ʾұ� ������ �Է��� ������ ���� �����Ϳ� ���� ����.
					ArrayList<Integer> nums = new ArrayList<>();
					ArrayList<String> names = new ArrayList<>();
					ArrayList<Integer> kors = new ArrayList<>();
					ArrayList<Integer> engs = new ArrayList<>();
					ArrayList<Integer> maths = new ArrayList<>();
					try {
						while(true) {
							nums.add(dis.readInt());
							names.add(dis.readUTF());
							kors.add(dis.readInt());
							engs.add(dis.readInt());
							maths.add(dis.readInt());
						}
					} catch (IOException e) {
						// �ݺ����� ���߱� ���� ���ܷ� ������ ���Ƿ� ������� �ʴ´�.
					}
					
					fos = new FileOutputStream(file);
					dos = new DataOutputStream(fos);
					
					dos.writeInt(num);
					dos.writeUTF(name);
					dos.writeInt(kor);
					dos.writeInt(eng);
					dos.writeInt(math);
					
					for(int i = 0; i < nums.size(); i++) {
						dos.writeInt(nums.get(i));
						dos.writeUTF(names.get(i));
						dos.writeInt(kors.get(i));
						dos.writeInt(engs.get(i));
						dos.writeInt(maths.get(i));
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
			} else if("3".equals(input)) {
				
			} else if("4".equals(input)) {
				
			} else {
				
			}
		}
	}

}
