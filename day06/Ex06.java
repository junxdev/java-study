class Ex06 { 
 
	public static void main(String[] args) { 
 
		// 메소드 이름 중복 불가
		func01("하이!");
		func01();
 
	} // main end 

	// Overloading method
	// 1. precence of parameter
	// 2. number of parameters
	// 3. type of parameter

	public static void func01() {
		System.out.println("func01() run");
		return 10;
	}

	public static void func01(String str) {
		System.out.println(str);
	}

	public static void func01(int a, int b) {
		System.out.println("parameter, parameter func01() run");
	}
 
} // class end 
