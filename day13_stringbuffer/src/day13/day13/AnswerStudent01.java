package day13;

public class AnswerStudent01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = null;
		sc = new java.util.Scanner(System.in);
		
		String title = "�����������α׷� ver 0.1.0";
		String menu = "1. ���� 2. �Է� 3. ���� 4. ���� 0. ���� >>> ";
		String table = "�й�\t����\t����\t����\t�հ�\t���";
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
				System.out.print("���� > ");
				int kor = sc.nextInt();
				System.out.print("���� > ");
				int eng = sc.nextInt();
				System.out.print("���� > ");
				int math = sc.nextInt();
				int sum = kor + eng + math;
				int avg = sum * 100 / 3 / 100;
				data += count + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg + "\n";
			}
			if (input == 3) {
				System.out.print("�й� > ");
				number = sc.nextInt();
				System.out.print("���� > ");
				int kor = sc.nextInt();
				System.out.print("���� > ");
				int eng = sc.nextInt();
				System.out.print("���� > ");
				int math = sc.nextInt();
				int sum = kor + eng + math;
				int avg = sum * 100 / 3 / 100;
				String newData = number + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg;
				
				int idx = data.indexOf("\n" + number); // "\n"�� ��ġ
				String data1 = data.substring(0, idx + 1); // "\n"���� ����
				String data2 = data.substring(data.indexOf("\n", idx + 1)); // "\n"���� ����
				
				data = data1 + newData + data2;  // 
				
			}
			if (input == 4) {
				System.out.println("�й� > ");
				number = sc.nextInt();
				int idx = data.indexOf("\n" + number);
				String data1 = data.substring(0, idx); // "\n" �������� ����
				String data2 = data.substring(data.indexOf("\n", idx + 1)); // "\n"���� ����
				data = data1 + data2;
			}
		}
		

	}

}
