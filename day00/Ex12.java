class Ex12{

	public static void main(String[] args) {
	
	// 연산자

	// 사칙연산: +, -, *, /, %

	System.out.println((3+2)*3);
	// System.out.println(0/0);

	// 증감연산자: ++, --

	int a;
	a = 100;
	System.out.println((a++)+1);
	System.out.println("a = " + a);
	System.out.println((++a)+1);
	System.out.println("a = " + a);
	System.out.println((a++)+1+(++a));
	System.out.println("a = " + a);
	System.out.println((a++)+1+(++a)+(a++));
	System.out.println("a = " + a);

	//

	byte e;
	e = 127;
	e = e + 1;
	System.out.println(e);

	} // main end

} // class end