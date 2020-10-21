package ch4;

import java.util.Arrays;

public class ArrayEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] abc = {'a', 'b', 'c', 'd'};
		char[] num = {1, 2, 3, 4, 5, 6, 7, 8};
		
		char[] result = new char[abc.length + num.length];
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.arraycopy(num, 0, result, abc.length, num.length);
		
		System.out.println(Arrays.toString(result));
		
		result = new char[abc.length + num.length];
		result = Arrays.copyOfRange(num, 0, 3);
		System.out.println(Arrays.toString(result));
		
		result = new char[abc.length + num.length];
		System.arraycopy(abc, 0, result, 3, abc.length);
		System.out.println(Arrays.toString(result));
		
		
	}

}
