package com.bit.day21;

import java.util.Arrays;

public class Test02Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.HashSet<Integer> Lotto = new java.util.HashSet<Integer>();
		java.util.Random randomizer = new java.util.Random();
		
		while(Lotto.size() < 7) {
			Lotto.add(randomizer.nextInt(45) + 1);
		}
		
		Object[] week = Arrays.copyOf(Lotto.toArray(), Lotto.size());
		Arrays.sort(week, 0, week.length - 1);

		for(int i = 0; i < week.length; i++) {
			System.out.print(week[i] + " ");
		}
	}

}
