package com.bit.day21;

class Car implements Comparable{ // Car가 Comparable을 구현
	int su;
	Car(int i) {
		this.su = i;
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		return su - ((Car)obj).su;
	}
	
}

public class Ex04TreeSetVSHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Set set2 = new java.util.HashSet(); // 해시값을 이용한 중복검사
		
		set2.add(1);
		set2.add(5);
		set2.add(4);
		set2.add(3);
		set2.add(2);
		java.util.Iterator ite = set2.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		java.util.Set set1 = new java.util.TreeSet(); // 이진트리를 이용한 중복검사(이 과정에서 정렬이 수행됨), 해시는 있지만 value가 없는 객체는 사용할 수 없음
		
//		set1.add(new Car()); // cannot be cast to java.lang.Comparable : 임의로 만든 객체를 비교할 방법을 모르기에 Comparable로 캐스팅하지만 실패
		set1.add(new Car(1));
		set1.add(new Car(2));
		set1.add(new Car(444));
		
		ite = set1.iterator();
		while(ite.hasNext()) {
			Car car = (Car)ite.next();
			System.out.println(car.su);
		}
	}

}
