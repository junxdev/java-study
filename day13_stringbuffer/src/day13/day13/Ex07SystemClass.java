package day13;

public class Ex07SystemClass {
	
	static Ex07SystemClass ex = new Ex07SystemClass();
	
	public void func01() {}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		System.out.println("출력");
		
		Ex07SystemClass me = new Ex07SystemClass();
		me.func01();
		
		Ex07SystemClass.ex.func01(); // Class.field.method
		
		int[] origin = {1, 3, 5, 7, 9};
		int[] dest = new int[5];
		
//		for(int i = 0; i < 5; i++) {
//			dest[i] = origin[i];    
//		}
		
		System.arraycopy(origin, 0, dest, 0, dest.length);
		for(int i = 0; i < 5; i++) {
			System.out.printf("%d ", dest[i]);
		}
		
		dest = new int[5];
		System.arraycopy(origin, 1, dest, 1, 3);
		for(int i = 0; i < 5; i++) {
			System.out.printf("%d ", dest[i]);
		}
		System.out.println();
		dest = new int[5];
		for(int i = 0; i < 5; i++) {
			System.out.printf("%d ", dest[i]);
		}
		
		String str = "abc";
		System.out.print("\nstr before : " + str.hashCode());
		str = "bbc";
		System.out.print("\nstr after : " + str.hashCode());
		
		StringBuffer sb = new StringBuffer(3);
		System.out.print("\nsb before : " + sb.hashCode());
		sb = new StringBuffer(5);
		System.out.print("\nsb after : " + sb.hashCode());
		sb.append(123456);
		System.out.print("\nsb after : " + sb.hashCode() + ", buffer size : " + sb.capacity());
		
		long end = System.currentTimeMillis();
		System.out.print("\nmain 작업시간 : " + (end - start) + "ms");

	}

}
