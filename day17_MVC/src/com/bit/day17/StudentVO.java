package com.bit.day17;
// Student 클래스의 필드를 정의하는 부분
// java.lang.Object 메소드를 오버라이딩하는 메소드만 포함
// 이렇게 데이터만 담당하는 '틀'을 Value Object or Data Transfer Object 클래스라고 부름

// 외부에서 꼭 알아야 하는 메서드가 아니라면 private으로 보호
// 대신 외부에서 접근이 불가능하기 때문에 메서드를 활용해서 값을 읽고 쓰게 함 : 캡슐화
public class StudentVO {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int id;
	
	
	// 값을 쓰는 메서드 : setter
	// 값을 읽는 메서드 : getter
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// 모든 클래스를 전부 오버로딩할 수 없으니 다형성을 사용
	public boolean equals(Object o) {
		// 2개의 객체 비교
		// 1. 2개의 객체가 같은 클래스 객체인지 확인
		// 2. 1번이 충족되었다면 해당 클래스의 필드 중 특정 필드 혹은 모든 필드를 비교해서 같으면 2개는 같은 객체
		
		// 1. 매개변수 o가 null이 아니라 StudentVO 클래스의 객체인지 확인
		if(o instanceof StudentVO) {
			// 위 조건이 true라면 o가 StudentVO의 객체라는 의미
			// 하지만 Object 타입이기 때문에 명시적 형변환을 통해 StudentVO로 변환
			StudentVO s = (StudentVO)o;
			if(id == s.id) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "학번 : " + id + ", 이름 : " + name + ", 국어 : " + kor + ", 영어 : " + eng
				+ ", 수학 : " + math;
	}
	
}
