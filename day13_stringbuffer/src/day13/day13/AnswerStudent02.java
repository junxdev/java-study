package day13;

public class AnswerStudent02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = null;
		sc = new java.util.Scanner(System.in);
		String title = "�����������α׷� ver 0.1.0";
		String menu = "1. ���� 2. �Է� 3. ���� 4. ���� 0. ���� >>> ";
		System.out.println("�� �ο� : ");
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
				System.out.println("�й�\t����\t����\t����\t�հ�\t���");
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
					System.out.print("���� > ");
					student[1] = sc.nextInt();
					System.out.print("���� > ");
					student[2] = sc.nextInt();
					System.out.print("���� > ");
					student[3] = sc.nextInt();
				} else {
					System.out.println("�����ʰ�");
				}
			}
			if (input == 3) {
				System.out.print("�й� > ");
				int number = sc.nextInt();
				int[] student = new int[4];
				int temp = -1; // index 0 ȸ��
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
					System.out.print("���� > ");
					student[1] = sc.nextInt();
					System.out.print("���� > ");
					student[2] = sc.nextInt();
					System.out.print("���� > ");
					student[3] = sc.nextInt(); 
				} else {
					System.out.println("ã�� �л��� �����ϴ�");
				}
			}
			if (input == 4) {
				System.out.print("�й� > ");
				int number = sc.nextInt();
				int temp = -1; // index 0 ȸ��
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
					System.out.println("ã�� �л��� �����ϴ�");
				}				
			}
		}
	}

}
