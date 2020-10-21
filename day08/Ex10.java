package com.bit.day08; 
 
class Ex10 { 
 
	public static void main(String[] args) { 

 		int number = 0;
		System.out.println("----------------------------1");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (j <= i) {
					System.out.print("★ ");
				}
			}
			System.out.println();
		}
		int total = 0;
		int count = 2;

		System.out.println("----------------------------2");
		for (int i = 0; i < 10; i++) {
			System.out.print("★ ");
			if (i == total) {
				System.out.println();
				total += count++;
			}
		}
		
		total = 0;
		count = 2;

		System.out.println("----------------------------3");
		for (int i = 0; i < 10; i++) {
			System.out.print((i + 1) + " ");
			if (i == total) {
				System.out.println();
				total += count++;
			}
		}

		System.out.println("----------------------------4");
		total = 0;
		count = 2;
		number = 0;

		for (int i = 0; i < 10; i++) {
			System.out.print((++number) + " ");
			if (i == total) {
				System.out.println();
				total += count++;
				number = 0;
			}
		}

		System.out.println("----------------------------5");
		count = 2;
		for (int i = 1; count - 2 < 4; i++) {
			if (i % count != 0) {
				System.out.print(i % count + " ");
			} else {
				System.out.println();
				i = 0;
				count ++;
			}
		}

		System.out.println("----------------------------6");
		count = 2;
		for (int i = 1; i - 1 < 4; i++) {
			if (i % count != 0) {
				System.out.print(i % count + " ");
			} else {
				System.out.println();
				i = 0;
				count ++;
			}
		}

		System.out.println("\n----------------------------7");
		int su = 2 ;
		for (int i = 1; i - 1 < 4; i++) {
			if (i % su == 0) {
				System.out.println();
				su++;
				i = 0;
			} else {
			System.out.print(i%su + " ");
			}
		}

		System.out.println("\n----------------------------8");
		
		su = 2;
		for (int i = 1; i - 1 < 4; i++) {
			
			if ((su - i) % su == 0) {
				System.out.println();
				su++;
				i = 0;
			} else {
			System.out.print((su - i) % su  + " ");
			}
		}

		System.out.println("\n----------------------------9");

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

		System.out.println("\n----------------------------10");

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (j > i - 1) {
				System.out.print("★ ");
				}
			}
			System.out.println();
		} 

		System.out.println("\n----------------------------11");

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (j < i) {
					System.out.print("  ");
				} else {	
					System.out.print("★ ");
				}
			}
			System.out.println();
		}

		System.out.println("\n----------------------------12");

		count = 0;
		number = 10;
		for (int i = 0; count < number;) {
			if (i < count) {
				System.out.print("  ");
			} else {
				System.out.print("★ ");
			}
			i++;

			if (i == number) {
				i = 0;
				count++;
				System.out.println();
			}
		}
							
			
	} // main end 
 
} // class end 
