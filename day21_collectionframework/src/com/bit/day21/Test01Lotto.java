package com.bit.day21;

public class Test01Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Set lotto = new java.util.HashSet();
		java.util.Random random = new java.util.Random();

		while(lotto.size() < 7) {
			lotto.add(random.nextInt(45) + 1);
		}
		
		java.util.Iterator note = lotto.iterator();
		java.util.List list = new java.util.ArrayList(lotto);
//		
//		for(int i = 0; i < 6; i++) {
//			list.add(note.next());
//		}
//		list.sort(new java.util.Comparator() {
//
//			@Override
//			public int compare(Object o1, Object o2) {
//				// TODO Auto-generated method stub
//				return (int)o1 - (int)o2;
//			}
//			
//		});
//		list.add(note.next());
//		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		
		java.util.List list2 = list.subList(0, 6);
		list2.sort(new java.util.Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return (int)o1 - (int)o2;
			}
			
		});
		list2.add(list.get(6));
		
		for(int i = 0; i < list2.size(); i++) {
			if(i == list2.size() - 1) {
				System.out.print("Bonus Number ");
			}
			System.out.print(list.get(i) + " ");
		}
	}

}
