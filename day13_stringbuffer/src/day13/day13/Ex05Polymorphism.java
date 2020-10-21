package day13;


class Son extends Ex05Polymorphism {

	String name = null;
	
	Son(int su) {
		super(su);
	}
	
	void getName(Ex05Polymorphism x) {
	}
	
}

public class Ex05Polymorphism {
	int su;
	Ex05Polymorphism(int su){
		this.su = su;
	}
	
	public boolean equals(Object you) { // Object you는 Ex05 객체를 가리킨다.
		return this.su == ((Ex05Polymorphism)you).su; // Object you는 su 멤버 필드가 없으므로 Ex05로 형변환하여 su 멤버 필드를 사용한다.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj1 = new Object();
		Object obj2 = obj1;
		Object obj3 = new Object();
		System.out.println(obj1.toString());
		System.out.println(obj1.hashCode());
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
		System.out.println("-------------------");
		Ex05Polymorphism me = new Ex05Polymorphism(100);
		Ex05Polymorphism you = new Ex05Polymorphism(100);
		System.out.println(me == you);
		System.out.println(me.equals(you)); // Ex05 you는 equals method의 parameter rule에 의해 Object 객체로 자동 형변환;Up casting
//		Object me3 = null;
//		try {
//			me3 = me.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(me.equals(me3));
		System.out.println("-------------------");
		String msg = "java";
		String msg2 = new String("java");
		System.out.println(msg == msg2);
		System.out.println(msg.equals(msg2));
		
//		System.out.println("-------------------");
//		Integer su1 = new Integer(100);
//		Integer su2 = new Integer(100);
//		System.out.println(su1 == su2);
//		System.out.println(su1.equals(su2));
	}

}
