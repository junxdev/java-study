package com.bit.day27;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int num; // "��ü" ����ȭ�� ����� ����ʵ��̴�.
	protected int kor;
	transient int eng; // transient > �⺻��
	private int math;
	transient String name; // ��ü ����ȭ���� �����ϹǷ� IO �۾��� �̷������ �ʴ´�.
	
	public Student(int num, String name, int kor, int eng, int math) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void show() {
		System.out.println(num + "�� " + name + " : ���� " + kor + " ���� " + eng + " ���� " + math);
	}

	public String toString() {
		return num + "�� " + name + " : ���� " + kor + " ���� " + eng + " ���� " + math;
	}
}

public class Student01SerializeObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "data1.bin";
		File file = new File(path);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new Student(1, "ȫ�浿", 90, 80, 70));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
				if(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
