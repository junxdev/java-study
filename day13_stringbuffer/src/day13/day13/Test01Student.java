package day13;

public class Test01Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("학생성적관리프로그램 ver 0.1.0\n");
		
		int input = 1;
		String student = "";
		
		do {
			System.out.print("1. 보기 2. 입력 3. 수정 4. 삭제 0. 종료 >>> ");
			input = sc.nextInt();
			if (input == 2) {
				for(int i = 0; i < 3; i++) {
					student += "-";
					student += i + 1;
					System.out.print("이름 > ");
					student += " name" + sc.next();
					sc = new java.util.Scanner(System.in);
					System.out.print("국어 > ");
					int kor = sc.nextInt();
					student += " kor" + kor;
					System.out.print("영어 > ");
					int eng = sc.nextInt();
					student += " eng" + eng;
					System.out.print("수학 > ");
					int math = sc.nextInt();
					student += " math" + math;
					int sum = kor + eng + math;
					int avg = sum / 3;
					student += " sum" + sum + " avg" + avg + " ";
				}
			} else if (input == 1) {
				System.out.print("학번\t 성명\t 국어\t 영어\t 수학\t 합계\t 평균\n");
				System.out.print("-------------------------------------------\n");
				try {
					for(int i = 0; i < 3; i++) {
						int location = student.indexOf("-" + (i + 1));
						System.out.println(student.substring(student.indexOf("-", location) + 1, student.indexOf(" ", student.indexOf("-", location))));
						System.out.println(student.substring(student.indexOf("name", location) + 4, student.indexOf(" ", student.indexOf("name", location))));
						System.out.println(student.substring(student.indexOf("kor", location) + 3, student.indexOf(" ", student.indexOf("kor", location))));
						System.out.println(student.substring(student.indexOf("eng", location) + 3, student.indexOf(" ", student.indexOf("eng", location))));
						System.out.println(student.substring(student.indexOf("math", location) + 4, student.indexOf(" ", student.indexOf("math", location))));
						System.out.println(student.substring(student.indexOf("sum", location) + 3, student.indexOf(" ", student.indexOf("sum", location))));
						System.out.println(student.substring(student.indexOf("avg", location) + 3, student.indexOf(" ", student.indexOf("avg", location))));
					}
				} catch (NullPointerException e) {
					continue;
				}
			} else if (input == 3) {
				System.out.print("학번 > ");
				int number = sc.nextInt();
				System.out.print("국어 > ");
				int kor = sc.nextInt();
				student += "k" + kor;
				System.out.print("영어 > ");
				int eng = sc.nextInt();
				student += "e" + eng;
				System.out.print("수학 > ");
				int math = sc.nextInt();
				student += "m" + math;
				int sum = kor + eng + math;
				int avg = sum / 3;
				student += "s" + sum + "a" + avg;
			} else if (input == 4) {
//				System.out.print("학번 > ");
//				int number = sc.nextInt();
//				for(int i = 0; i < )
//			} else if (input == 0) {
//				return;
			}
		} while (input != 0);
		
//		for(int i = 0; i < student.length; i++) {
//			System.out.print(student[i]);
//			System.out.print("\n");
//		}
		

		
	}

}
