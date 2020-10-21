class Ex22 { 
 
	public static void main(String[] args) { 
 
		int su = 1234;

		if (su == 1234) {
			System.out.println("같다");
		} else { 
			System.out.println("다르다"); 
 		}
		System.out.println("--------------");

		switch (su) {
			case 1234:
			System.out.println("같다");
			break;

			default:
			System.out.println("다르다");
			break;
		}


		// -----------------------------------

		String msg = args[0];

		System.out.println("input = " + msg);

		System.out.println("--------------");

		if (msg == "java") {
			System.out.println("같다");
		} else { 
			System.out.println("다르다"); 
 		}
		System.out.println("--------------");

		switch (msg) {
			case "java":
			System.out.println("같다");
			break;

			default:
			System.out.println("다르다");
			break;
		}

	} // main end 
 
} // class end 
