package com.bit.day21;

class Lec10<T, V> {
	T su;
	V msg;
	
	void setSu(T su) {
		this.su = su;
	}
	
	void setMsg(V msg) {
		this.msg = msg;
	}
	
	T getSu() {
		return su;
	}
	
	V getMsg() {
		return msg;
	}
}
public class Ex10GenericUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lec10<Integer, StringBuffer> lec = new Lec10();
		
		lec.setSu(1234);
		lec.setMsg(new StringBuffer("hello"));
		
		int x = lec.getSu();
		
		System.out.println(lec.getSu());
		System.out.println(lec.getMsg());
		
	}

}
