package com.bit.day15;
class Student3 {
	int number, kor, eng, math;
	String name;
	
	Student3(int number) {
		this.number = number;
	}
	
	void readData() {
		System.out.println(number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + ((kor + eng + math) * 100 / 3 / 100.0));
	}
	
	void writeData() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("�̸� > ");
		this.name = sc.nextLine();
		System.out.print("���� > ");
		this.kor = Integer.parseInt(sc.nextLine());
		System.out.print("���� > ");
		this.eng = Integer.parseInt(sc.nextLine());
		System.out.print("���� > ");
		this.math = Integer.parseInt(sc.nextLine());
	}
	
}
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("�� �л� ��: ");
		int maxNumber = Integer.parseInt(sc.nextLine());
		
		Student3[] data;
		data = new Student3[maxNumber];
		
		
		int studentCount = 0;
		boolean program = true;
		
		while(program) {
			System.out.print("1.��ȸ 2.�Է� 3.���� 4.���� 0.���� \n> ");
			int mainMenu = Integer.parseInt(sc.nextLine());
			switch (mainMenu) {
			case 0 :
				System.out.println("���α׷��� �����մϴ�.");
				program = false;
				break;
			case 1 :
				System.out.println("�й�\t�̸�\t����\t����\t����\t���");
				System.out.println("---------------------------------------------");
				for(int i = 0; i < data.length; i++) {
					if(data[i] != null) {
						Student3 student = data[i];
						student.readData();
					}
				}
				break;
			case 2 :
				//�Է�
				Student3 student = new Student3(studentCount + 1); // �й� 1������ ����
				student.writeData();
				data[studentCount++] = student; // �Էµ� �л� �� ����
				break;
			case 3 :
				System.out.print("������ �л��� �й� > ");
				int numberToEdit = Integer.parseInt(sc.nextLine());
				int studentToEdit = -1;
				
				if(numberToEdit > data.length|| numberToEdit < 1) {
					System.out.println("�ùٸ� �Է��� �ƴմϴ�.");
					break;
				}
				
				for(int i = 0; i < studentCount; i++) {
					if(data[i].number == numberToEdit) {
						studentToEdit = i;
					}
				}
				if(studentToEdit > -1) {
					data[studentToEdit].writeData();
				} else {
					System.out.println("ã�� �л��� �������� �ʽ��ϴ�.");
				}
				break;
			case 4 :
				System.out.print("������ �л��� �й� > ");
				int numberToDelete = Integer.parseInt(sc.nextLine());
				int studentToDelete = -1;
				
				if(numberToDelete > data.length || numberToDelete < 1) {
					System.out.println("�ùٸ� �Է��� �ƴմϴ�.");
					break;
				}
				
				for(int i = 0; i < studentCount; i++) {
					if(data[i].number == numberToDelete) {
						studentToDelete = i;
					}
				}
				if(studentToDelete > -1) {
					data[studentToDelete] = null;
				} else {
					System.out.println("ã�� �л��� �������� �ʽ��ϴ�.");
				}
				break;
			default : 
				System.out.println("�ùٸ� �Է��� �ƴմϴ�.");	
			} // switch end
		} // while end
	} // main end
} // class end
