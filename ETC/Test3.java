class Test3 { 
 
	public static void main(String[] args) { 
 
		String A = "바보";
		String B = A;
		String C = new String("바보");
		System.out.println(A == B);
		System.out.println(A == C);
		System.out.println(B == C); 
 
	} // main end 
 
} // class end 
