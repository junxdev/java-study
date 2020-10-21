package com.bit.day07;

class Ex10 {

	public static void main (String[] args) {
		
		System.out.println("\n------------------1");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j - 1 < i; j++) {
				System.out.print("★ ");
			}
			System.out.println();
		}

		int count = 1;

		System.out.println("\n------------------2");
		for (int i = 0; count <= 4;) {
			System.out.print("★ ");
			i++;
			if (i == count) {
				count++;
				i = 0;
				System.out.println();
			}			
		}

		System.out.println("\n------------------3");	
		count = 1;

		for (int i = 1; count <= 4; i++) {
			System.out.print(i + " ");
			if (i == count) {
				count++;
				i = 0;
				System.out.println();
			}
		}

		System.out.println("\n------------------4");
		
		int num4 = 1;
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print(num4++ + " ");
			}
			System.out.println();
		}

		System.out.println("\n------------------5");
		int num5 = 1;
		count = 1;
		for (int i = 0; count <= 4;) {
			System.out.print(num5++ + " ");
			i++;
			if (i == count) {
				count++;
				i = 0;
				System.out.println();
			}			
		}

		System.out.println("\n------------------6");
		int num6 = 'A' + 0;
		count = 1;
		for (int i = 0; count <= 4;) {
			System.out.print((char)(num6++) + " ");
			i++;
			if (i == count) {
				count++;
				i = 0;
				System.out.println();
			}
		}

		System.out.println("\n------------------7");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print("★ ");
			}
			System.out.println();
		}
				
		System.out.println("\n------------------8");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4 - (i + 1); j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < (i + 1); j++) {
				System.out.print("★ ");
			}
			System.out.println();
		}
			
		System.out.println("\n------------------9");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (j > 4 - (i + 2)) {
					System.out.print("★ ");	
				} else {
				System.out.print("  ");
				}
			}
			System.out.println();
		}		

		System.out.println("\n------------------10");
		int num11 = 9;
		for (int i = 0; i < num11; i++) {
			if (i < (num11 / 2 + 1)) {
				for (int j = 0; j < (num11 / 2 + 1) - (i + 1); j++) {
					System.out.print("  ");
				}
				for (int k = 0; k < (2 * i) + 1; k++) {
					System.out.print("★ ");
				}
			} else {
				for (int j = 0; j < i - (num11 / 2) ; j++) {
					System.out.print("  ");
				}
				for (int k = 0; k < (num11 * 2 - 1) - (2 * i); k++) {
					System.out.print("★ ");
				}
			}
			System.out.println();
		}	
			

	} // main end

} // class end