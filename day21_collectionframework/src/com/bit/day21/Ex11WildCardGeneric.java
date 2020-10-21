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
//		Lec1<?> lec = new Lec1<>(); // WildCard Generic Type : ���� ��� �������� �ʴ� ���
//		Lec1<String> lec2 = (Lec1<String>) lec;
		
//		<? super Number> Number�� ��ӹ޴� Ÿ�Ը� ����
//		<? extends Integer> Integer ���� Ÿ�Ը� ����
		Lec1<? super Number> lec1 = new Lec1<>();
		lec1.setObj(12.34);
		Object msg = lec1.getObj();
		System.out.println(msg);
	}

}
