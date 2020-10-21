package day13;

public class Ex01StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// StringBuffer = 객체 하나도 부담이 되는 임베디드 상황에서 사용
		// 일반 경우에는 String을 써도 성능 상 무방
		String msg1 = new String("JavaWebFramework");
		StringBuffer sb1 = new StringBuffer("JavaWebFrameWork");
//		StringBuffer sb2 = "Java"; 에러
		StringBuffer sb3 = new StringBuffer(msg1);
		StringBuffer sb4 = new StringBuffer(1);
		
		System.out.println(sb1);
		System.out.println(sb3);
		System.out.println(sb4);
		
		System.out.println(msg1.length());
		System.out.println(sb1.length());
		
//		삽입, 조회, 수정, 삭제 CRUD
		
		StringBuffer sb5 = new StringBuffer("Java");
		StringBuffer sb6 = new StringBuffer("Web");
//		StringBuffer sb7 = sb5 + sb6; String 클래스만 가능
		
		StringBuffer sb7 = sb5.append(sb6);
		String msg2 = "My";
		msg2 = msg2.concat(msg1);
		System.out.println("sb7 = " + sb7); // JavaWeb
		System.out.println("sb5 = " + sb5); // JavaWeb
		System.out.println("sb6 = " + sb6); // Web
		System.out.println("msg2 = " + msg2); // MyJavaWebFramework
		
		sb5.append("Framework");
		System.out.println("sb5 = " + sb5); // JavaWebFramework
		sb5.delete(4, 7);
		System.out.println("sb5 = " + sb5); // JavaFramework
		sb5.insert(4, "DB");
		System.out.println("sb5 = " + sb5); // JavaDBFramework
		sb5.insert(sb5.length(), "Web");
		System.out.println("sb5 = " + sb5); // JavaDBFrameworkWeb
		
		sb5.replace(sb5.indexOf("DB"), sb5.indexOf("DB") + "DB".length(), "Database");
		System.out.println("sb5 = " + sb5); // JavaDBFrameworkWeb
		
	}

}
