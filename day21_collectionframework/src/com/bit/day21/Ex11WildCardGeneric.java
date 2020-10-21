package com.bit.day21;

class Lec1<T> {
	T obj;
	
	void setObj(T obj) {
		this.obj = obj;
	}
	
	T getObj() {
		return obj;
	}
}
public class Ex11WildCardGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Lec1<?> lec = new Lec1<>(); // WildCard Generic Type : 선언 당시 결정하지 않는 방법
//		Lec1<String> lec2 = (Lec1<String>) lec;
		
//		<? super Number> Number를 상속받는 타입만 가능
//		<? extends Integer> Integer 상위 타입만 가능
		Lec1<? super Number> lec1 = new Lec1<>();
		lec1.setObj(12.34);
		Object msg = lec1.getObj();
		System.out.println(msg);
	}

}
