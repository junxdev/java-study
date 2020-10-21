package com.bit.day21;

class Car implements Comparable{ // Car�� Comparable�� ����
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
		java.util.Set set2 = new java.util.HashSet(); // �ؽð��� �̿��� �ߺ��˻�
		
		set2.add(1);
		set2.add(5);
		set2.add(4);
		set2.add(3);
		set2.add(2);
		java.util.Iterator ite = set2.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		java.util.Set set1 = new java.util.TreeSet(); // ����Ʈ���� �̿��� �ߺ��˻�(�� �������� ������ �����), �ؽô� ������ value�� ���� ��ü�� ����� �� ����
		
//		set1.add(new Car()); // cannot be cast to java.lang.Comparable : ���Ƿ� ���� ��ü�� ���� ����� �𸣱⿡ Comparable�� ĳ���������� ����
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
