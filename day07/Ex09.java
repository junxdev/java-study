package com.bit.day07;

class Ex09 {

	public static void main(String[] args) {

		for(int i = 0; i < 'Z' - 'A' + 1; i++) {
			char tmp = (char)('A' + i);
			System.out.print(tmp + " ");
		}
		System.out.println("\n");

		for(int i = 0; i < 'Z' - 'A' + 1; i++) {
			char tmp = (char)('a' + i);
			System.out.print(tmp + " ");
		}
		System.out.println("\n");

		for(int i = 0; i < 'Z' - 'A' + 1; i++) {
			char tmp = (char)('A' + i);
			System.out.print(tmp + "(" + (char)(tmp + 'a' - 'A') + ") ");
		}
		System.out.println("\n");

		for(int i = 1; i < 16; i++) {
			if(i % 5 == 0) {
				System.out.println();
			} else {
				System.out.print('★');
			}
		}
		System.out.println("\n");

		int num = 1;
		for(int i = 1; i < 13; i++) {
			if (i % 4 == 0) {
				System.out.println();
			} else {
				System.out.print(num++ + " ");
			}
		}
		System.out.println();

		int limit = 3;
		boolean boo = true;
		for(int i = 1; limit != 6; i++) {
			System.out.print(i);
			if (limit == i) {
				limit ++;
				i -= 2;
				System.out.println();
			}
		}

	}

}