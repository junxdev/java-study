class Ex10 { 
// 클래스 선언: class 클래스명 {코드;}
/*
클래스명 규칙
- 첫글자는 영문 대문자
- 띄어쓰기 또는 특수문자 불가 (권장하지 않으나 가능한 예외: _, $)
- 단어 첫글자는 대문자
*/

	public static void main(String[] args) {

		System.out.println('#');
		System.out.println("문자열");
		System.out.println('문' + '자' + '열');
		System.out.println("문\t자\n열");
		System.out.println("문" + "\t" + '자');
		System.out.println("문" + '\u000B' + '자');
		
		char c;
		c = '	';
		
		System.out.println((int)c);

		System.out.println("path=C:\\java\\jdk");

		int b = 0001;
		String a = "\'\\u" + "0005" +"\'";
		System.out.println(a); //문자열로 인식되기 때문에 유니코드 문자가 나오지 않는다.
		System.out.println('\u0005');
	
		
/*		int i = 1;
		while (i < 100) {

			System.out.println(i + " = " + (char)i + ".");
			i ++;



		}
*/
	}

}