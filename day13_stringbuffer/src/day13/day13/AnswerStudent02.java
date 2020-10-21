package day13;

public class AnswerStudent02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = null;
		sc = new java.util.Scanner(System.in);
		String title = "성적관리프로그램 ver 0.1.0";
		String menu = "1. 보기 2. 입력 3. 수정 4. 삭제 0. 종료 >>> ";
		System.out.println("총 인원 : ");
		int x = sc.nextInt();
		
		int[][] data = null;
		data = new int[x][];
		System.out.println(title);
		System.out.println("-----------------------");
		int input = 0;
		int idx = 0;
		
		while (true) {
			System.out.print(menu);
			input = sc.nextInt();
			if (input == 0) {break;}
			if (input == 1) {
				System.out.println("학번\t국어\t영어\t수학\t합계\t평균");
				System.out.println("----------------------------------------------");
				for (int i = 0; i < idx; i++) {
					int[] student = data[i];
					if (student == null) {continue;}
					System.out.print(student[0] + "\t");
					System.out.print(student[1] + "\t");
					System.out.print(student[2] + "\t");
					System.out.print(student[3] + "\t");
					System.out.print((student[1] + student[2] + student[3]) + "\t");
					System.out.println(((student[1] + student[2] + student[3]) * 100 / 3 / 100.0) + "\t");
				}
			}
			if (input == 2) {
				if(x > idx) {
					int[] student = new int[4];
					data[idx++] = student; 
					student[0] = idx;
					System.out.print("국어 > ");
					student[1] = sc.nextInt();
					System.out.print("영어 > ");
					student[2] = sc.nextInt();
					System.out.print("수학 > ");
					student[3] = sc.nextInt();
				} else {
					System.out.println("정원초과");
				}
			}
			if (input == 3) {
				System.out.print("학번 > ");
				int number = sc.nextInt();
				int[] student = new int[4];
				int temp = -1; // index 0 회피
				for (int i = 0; i < data.length; i++) {
					int[] checkStudent = data[i];
					if (checkStudent == null) {continue;}
					if (checkStudent[0] == number) {
						temp = i;
					}
				}
				if (temp != -1) {
					data[temp] = student;
					student[0] = number;
					System.out.print("국어 > ");
					student[1] = sc.nextInt();
					System.out.print("영어 > ");
					student[2] = sc.nextInt();
					System.out.print("수학 > ");
					student[3] = sc.nextInt(); 
				} else {
					System.out.println("찾는 학생이 없습니다");
				}
			}
			if (input == 4) {
				System.out.print("학번 > ");
				int number = sc.nextInt();
				int temp = -1; // index 0 회피
				for (int i = 0; i < data.length; i++) {
					int[] checkStudent = data[i];
					if (checkStudent == null) {continue;}
					if (checkStudent[0] == number) {
						temp = i;
					}
				}
				if (temp != -1) {
					data[temp] = null;
				} else {
					System.out.println("찾는 학생이 없습니다");
				}				
			}
		}
	}

}
