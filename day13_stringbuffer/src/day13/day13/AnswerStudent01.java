package day13;

public class AnswerStudent01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = null;
		sc = new java.util.Scanner(System.in);
		
		String title = "성적관리프로그램 ver 0.1.0";
		String menu = "1. 보기 2. 입력 3. 수정 4. 삭제 0. 종료 >>> ";
		String table = "학번\t국어\t영어\t수학\t합계\t평균";
		String data = "----------------------------------------------\n";
		
		int input = 0;
		System.out.println(title);
		System.out.println("--------------------------------");
		int number = 0;
		int count = 0;
		
		while(true) {
			System.out.print(menu);
			input = sc.nextInt();
			if (input == 0) {break;}
			if (input == 1) {
				System.out.println(table);
				System.out.print(data);
			}
			if (input == 2) {
				count++;
				System.out.print("국어 > ");
				int kor = sc.nextInt();
				System.out.print("영어 > ");
				int eng = sc.nextInt();
				System.out.print("수학 > ");
				int math = sc.nextInt();
				int sum = kor + eng + math;
				int avg = sum * 100 / 3 / 100;
				data += count + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg + "\n";
			}
			if (input == 3) {
				System.out.print("학번 > ");
				number = sc.nextInt();
				System.out.print("국어 > ");
				int kor = sc.nextInt();
				System.out.print("영어 > ");
				int eng = sc.nextInt();
				System.out.print("수학 > ");
				int math = sc.nextInt();
				int sum = kor + eng + math;
				int avg = sum * 100 / 3 / 100;
				String newData = number + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg;
				
				int idx = data.indexOf("\n" + number); // "\n"의 위치
				String data1 = data.substring(0, idx + 1); // "\n"까지 남음
				String data2 = data.substring(data.indexOf("\n", idx + 1)); // "\n"부터 남음
				
				data = data1 + newData + data2;  // 
				
			}
			if (input == 4) {
				System.out.println("학번 > ");
				number = sc.nextInt();
				int idx = data.indexOf("\n" + number);
				String data1 = data.substring(0, idx); // "\n" 이전까지 남음
				String data2 = data.substring(data.indexOf("\n", idx + 1)); // "\n"부터 남음
				data = data1 + data2;
			}
		}
		

	}

}
