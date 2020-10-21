class Ex091 { 

	public static void alphabet(char a) {
		for (int i = 0; i < 26; i ++) {
			char result = (char)(a + i);
			System.out.print(result + " ");
		}

		System.out.println("\n");
	}
		
 
	public static void main(String[] args) { 
 
//		Q1. print A ~ Z

		alphabet('A');	

//		Q2. print a ~ z

		alphabet('a');

//		Q3. print A(a) ~ Z(z)

		for (int i = 0; i < 26; i ++) {
			char upperCase = (char)(65 + i);
			char lowerCase = (char)(97 + i);
			System.out.print(upperCase + "(" + lowerCase + ")" + " ");
		}

		System.out.println();	

		System.out.println();

//		Q4. print next

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print('★');
			}
			System.out.println();
		}	

		System.out.println();

//		Q5. print next

		int input = 1;
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(input++ + " ");
			}
			System.out.println();
		}

		System.out.println();

//		Q6. print next

		for (int i = 0; i < 7; i++) {
			input = 1 + i;
			for(int j = 0; j < 3; j++) {
				System.out.print(input++ + " ");
			}
			System.out.println();
		}
 
 
	} // main end 
 
} // class end 
