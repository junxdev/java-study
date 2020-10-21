package ch4;

import java.util.Arrays;
import java.util.Random;

public class ArrayEx11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(10);
		}
		for(int i = 1; i < arr.length + 1; i++) {
			System.out.print(arr[i - 1]);
			if(i % 20 == 0) {
				System.out.println();
			}
		}		
		int[] count = new int[10];
		for(int i = 0; i < arr.length; i++) {
			count[arr[i]] = count[arr[i]] + 1;
		}
		
		for(int i = 0; i < count.length; i++) {
			System.out.println("i = " + count[i]);
		}
	}

}
