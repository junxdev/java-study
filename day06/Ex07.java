class Ex07 { 
 
	public static void main(String[] args) { 
 
		System.out.println();
		func1(1234);
		func1('A');
 
	} // main end 

	// Auto casting while overloading

	public static void func1(double w) {
		System.out.println("parameter : " + w);
	}

	public static void func1(int w) {
		System.out.println("parameter : " + w);
	}
 
} // class end 
