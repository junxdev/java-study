package day13;

public class Ex03StringBufferCapacity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1.capacity());

		StringBuffer sb2 = new StringBuffer("abc"); // 16 + 3
		System.out.println(sb2.capacity());
	}

}
