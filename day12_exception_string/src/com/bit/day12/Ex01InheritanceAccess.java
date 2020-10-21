package com.bit.day12;

public class Ex01InheritanceAccess extends com.bit.day11.Lec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		com.bit.day11.Lec01 you = new com.bit.day11.Lec01(); // default로 접근 불가
//		you.func01(); // 상속을 하지 않아 default와 같은 접근 제한으로 접근 불가
		Ex01InheritanceAccess me = new Ex01InheritanceAccess(); // 상속
		me.func01(); // 상속을 통한 접근 가능

	}

}
