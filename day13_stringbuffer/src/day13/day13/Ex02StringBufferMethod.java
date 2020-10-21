package day13;

public class Ex02StringBufferMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// buffer size가 변하면서 배열 복사 후 객체 생성
		StringBuffer sb1 = new StringBuffer(); // 초기값 : 16
		System.out.println("buffer size : " + sb1.capacity());
		StringBuffer sb2 = new StringBuffer(3);
		System.out.println("buffer size : " + sb2.capacity());
		for(int i = 0; i < 8; i++) { // buffer size : (capacity + 1) * 2
			sb2.append(i);
			System.out.println(sb2 + " : " + sb2.capacity());
		}
		for(int i = 0; i < 3; i++) {
			sb2.delete(sb2.length() - 1, sb2.length());
			System.out.println(sb2 + " : " + sb2.capacity());
		}
		sb2.trimToSize();
		System.out.println(sb2 + " : " + sb2.capacity());
	}
}
