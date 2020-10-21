class Ex14 { 
 
	public static void main(String[] args) { 

		// 단항 논리연산자

		boolean a;
		a = true;
 
		System.out.println(!a); 
		System.out.println(!(3 > 5)); 
		
		// 대입연산자, 배정연산자: =, +=, -=, *=, /=, %=

		int b;

		b = 100;
		b += 2 * 2; // b = b + (2 * 2)
		System.out.println(b); 

		b = 100;
		b -= 2 + 2; // b = b - (2 + 2)
		System.out.println(b); 

		b = 100;

		b *= 2 + 2; // b = b * (2 + 2)
		System.out.println(b); 
		
		byte c;

		c = 127;
		c *= 1 + 3;
		System.out.println(c); 

		// 바이트연산자: &, |

		byte d = 4;
		byte e = 5;
		System.out.println(d & e);
		System.out.println(d | e);

		// 쉬프트연산자: <<, >>

		byte f = 4;
		System.out.println(f << 2);
		System.out.println(f >> 2);
		
		
 
	} // main end 
 
} // class end 
