class Ex09 { 
 
	public static void main(String[] args) { 

//		Q1. print A ~ Z

		int input = 'A' + 0;
		for (int i = 0; i < 26; i ++) {
			char upperCase = (char)(input + i);
			System.out.print(upperCase + " ");
		}

		System.out.println();	

		System.out.println();

//		Q2. print a ~ z

		input = 'a' + 0;
		for (int i = 0; i < 26; i ++) {
			char lowerCase = (char)(input + i);
			System.out.print(lowerCase + " ");
		}

		System.out.println();	

		System.out.println();

//		Q3. print A(a) ~ Z(z)

		for (int i = 0; i < 26; i ++) {
			char upperCase = (char)(65 + i);
			char lowerCase = (char)(97 + i);
			System.out.print(upperCase + "(" + lowerCase + ")" + " ");
		}

		System.out.println();	

		System.out.println();

/*		Q4. print next
			★★★★
			★★★★
			★★★★
*/
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print('★');
			}
			System.out.println();
		}	

		System.out.println();

/*		Q5. print next
			1 2 3
			4 5 6
			7 8 9
*/
		input = '1';
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print((char)input++ + " ");
			}
			System.out.println();
		}

		System.out.println();

/*		Q6. print next
			1 2 3
			2 3 4
			 ...
			7 8 9
*/
		for (int i = 0; i < 7; i++) {
			input = i;
			for(int j = 0; j < 3; j++) {
				System.out.print(++input + " ");
			}
			System.out.println();
		}
 
	} // main end 
 
} // class end 
