package com.bit.day27;

import java.io.Serializable;

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L; // write시 버전과 read시 버전이 동일해야 한다.
	
	public static int num; // "객체" 직렬화의 대상은 멤버필드이다.
	protected int kor;
	transient int eng; // transient > 기본값
	private int math;
	transient String name; // 객체 직렬화에서 제외하므로 IO 작업이 이루어지지 않는다.
	
	public Student(int num, String name, int kor, int eng, int math) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void show() {
		System.out.println(num + "번 " + name + " : 국어 " + kor + " 영어 " + eng + " 수학 " + math);
	}

	public String toString() {
		return num + "번 " + name + " : 국어 " + kor + " 영어 " + eng + " 수학 " + math;
	}
	
	public long getVersion() {
		return serialVersionUID;
	}
}

