class Ex05 { 
 
	public static void main(String[] args) { 
 		int su = func01();
		func02();
		System.out.println("su = " + su); 

		System.out.println("su = " + func01()); 
 
	} // main end 

	public static void func02() {
		System.out.println("void method run...");
		return;
	}

	public static int func01() {
		System.out.println("func01 method run");
		int a = 3;
		int b = 2;
		int c = a + b;
		return c;
	}

	// return 데이터의 자료형 선언
	// C의 return은 -1, 0, 1로 시스템에 정상 종료 여부를 알려주기 위한 장치다. 시스템은 이를 받아서 조치한다.
	// java는 시스템 또는 JVM에 알리지 않기 때문에 main의 return은 void다.
 
} // class end 
