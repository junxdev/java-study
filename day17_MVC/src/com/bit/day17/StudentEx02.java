package com.bit.day17;

public class StudentEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ArrayList<StudentVO> list = new java.util.ArrayList<>();
		
		// <> : Template
		// 템플릿이란 해당 객체가 무슨 클래스의 집합인지 지정
		// 템플릿 안에는 클래스만 입력 가능
		// Collection Framework는 주소값을 이용하기 대문에 주소값이 존재하지 않는 기본형 데이터는 사용 불가
		// 기본형 데이터를 사용하려면 Wrapper 클래스 활용
		
		// 기본 equals 메서드는 return this == 0;이기 때문에 재정의하는 것이 중요
		
		// ArrayList는 크기가 동적
		
		StudentVO s = new StudentVO();
		StudentVO s1 = new StudentVO();
		StudentVO s2 = new StudentVO();
		
		System.out.println("list 크기 : " + list.size());
		list.add(s);
		s.setName("kuni");
		System.out.println("list 크기 : " + list.size());
		list.add(s1);
		s1.setName("jerry");
		System.out.println("list 크기 : " + list.size());
		list.add(s2);
		s2.setName("el");
		System.out.println("list 크기 : " + list.size());
		list.add(s2);
		System.out.println("list 크기 : " + list.size());
		
		// 데이터 호출은 get
		System.out.println("index 2의 student의 getName(): " + list.get(2).getName());
		System.out.println("index 2의 student의 getName(): " + list.get(3).getName());
		
		System.out.println("index 2의 s2의 indexOf(): " + list.indexOf(s2));
		System.out.println("index 2의 s2의 indexOf(): " + list.lastIndexOf(s2));
		System.out.println("index 2의 s2의 indexOf(): " + list.contains(s1));
		
		list.remove(1);
		System.out.println("list 크기 : " + list.size());
		list.remove(s2);
		System.out.println("list 크기 : " + list.size());
		System.out.println("index 2의 s2의 indexOf(): " + list.contains(s1));
		System.out.println("index 2의 s2의 indexOf(): " + list.lastIndexOf(s2));
	}

}
