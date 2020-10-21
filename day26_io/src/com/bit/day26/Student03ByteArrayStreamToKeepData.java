package com.bit.day26;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Student03ByteArrayStreamToKeepData {

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
			System.out.print("1.보기 2.입력 0.종료 > ");
			input = sc.nextLine();
			
			if("0".equals(input)) {
				System.out.println("이용해주셔서 감사합니다.");
				break;
				
			} else if("1".equals(input)) {
				System.out.println(bar);
				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
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
					// 반복문을 멈추기 위한 예외로 오류를 임의로 출력하지 않는다.
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
				System.out.print("학번 > ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.print("이름 > ");
				String name = sc.nextLine();
				System.out.print("국어 > ");
				int kor = Integer.parseInt(sc.nextLine());
				System.out.print("영어 > ");
				int eng = Integer.parseInt(sc.nextLine());
				System.out.print("수학 > ");
				int math = Integer.parseInt(sc.nextLine());
				
//				File temp = new File("temp.bin");
//				try {
//					if(!temp.exists()) {
//						temp.createNewFile();
//					}
//					fis = new FileInputStream(file);
//					fos = new FileOutputStream(temp);
//					while(true) {
//						int dataTemp = fis.read();
//						if(dataTemp == -1) {
//							break;
//						}
//						fos.write(dataTemp);
//					}
//				} catch(FileNotFoundException e) {
//					e.printStackTrace();
//				} catch(IOException e) {
//					e.printStackTrace();
//				} finally {
//					try {
//						if(fis != null) {
//							fis.close();
//						}
//						if(fos != null) {
//							fos.close();
//						}
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				byte[] copy = null;
				ByteArrayOutputStream baos = null;
				ByteArrayInputStream bais = null;
				try {
					fis = new FileInputStream(file);
					baos = new ByteArrayOutputStream();
					
					while(true) {
						int su = fis.read();
						if(su == -1) {
							break;
						}
						baos.write(su);
					}
					copy = baos.toByteArray();
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if(baos != null) {
							baos.close();
						}
						if(fis != null) {
							fis.close();
						}
					} catch(IOException e) {
						e.printStackTrace();
					}
				}

				try {
					bais = new ByteArrayInputStream(copy);
					dis = new DataInputStream(bais);
					
					fos = new FileOutputStream(file);
					dos = new DataOutputStream(fos);
					
					while(true) {
						dos.writeInt(dis.readInt());
						dos.writeUTF(dis.readUTF());
						dos.writeInt(dis.readInt());
						dos.writeInt(dis.readInt());
						dos.writeInt(dis.readInt());
					} 
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EOFException e) {
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
				
				try {
					dos.writeInt(num);
					dos.writeUTF(name);
					dos.writeInt(kor);
					dos.writeInt(eng);
					dos.writeInt(math);
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
