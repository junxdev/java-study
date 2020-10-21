class Ex04 { 
 
	public static void main(String[] args) { 
 
		System.out.println("main start"); 

		func01();

		func02();		

		System.out.println("main end"); 
 
	} // main end 

	public static void func01() {

		System.out.println("func01 start"); 
		System.out.println("void method..."); 
		func02();
		System.out.println("func01 end\n"); 

	}

	public static void func02() {

		System.out.println("func02 start"); 
		System.out.println("func02 run..."); 
		System.out.println("func02 end\n"); 

	}
 
} // class end 
