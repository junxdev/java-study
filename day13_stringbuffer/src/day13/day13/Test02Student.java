package day13;

public class Test02Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String student = "-1 kor60 eng30 math20 sum10 avg0 -2 kor30 eng40 math50 sum60 avg70 -3 kor80 eng100 math50 sum40 avg30 ";
		for(int i = 0; i < 3; i++) {
			int location = student.indexOf("-" + (i + 1));
			System.out.println(student.substring(student.indexOf("kor", location) + 3, student.indexOf(" ", student.indexOf("kor", location))));
			System.out.println(student.substring(student.indexOf("eng", location) + 3, student.indexOf(" ", student.indexOf("eng", location))));
			System.out.println(student.substring(student.indexOf("math", location) + 4, student.indexOf(" ", student.indexOf("math", location))));
			System.out.println(student.substring(student.indexOf("sum", location) + 3, student.indexOf(" ", student.indexOf("sum", location))));
			System.out.println(student.substring(student.indexOf("avg", location) + 3, student.indexOf(" ", student.indexOf("avg", location))));
		}
	}

}
