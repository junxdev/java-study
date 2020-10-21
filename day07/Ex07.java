package com.bit.day07;

class Ex07 {

	public Ex07 func(Ex07 me) {
		System.out.println("func run");
		return me;
	}

	public static void main (String[] args) {

		Ex07 me;
		me = null;
		me = new Ex07();
		
		me.func(me).func(me).func(me).func(me).func(me);


	}

}