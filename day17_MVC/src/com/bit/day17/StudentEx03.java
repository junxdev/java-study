package com.bit.day17;

public class StudentEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ArrayList<StudentVO> list = new java.util.ArrayList<StudentVO>();
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		StudentController controller = new StudentController(list);
		StudentViewer viewer = new StudentViewer();
		
		while(true) {
			System.out.println("��Ʈ����б� ���� ����� ���α׷�");
			System.out.println("1.�Է� 2.��� 3.���� 4.���� 5.����\n>");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			if(choice == 1) {
				StudentVO s = viewer.setInformation(scanner);
				controller.add(s);
			} else if(choice == 2) {
				for(int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
			} else if(choice == 3) {
				if(list.size() == 0) {
					System.out.println("�Էµ� �л��� �����ϴ�.");
					continue;
				}
				for(StudentVO s : list) {
					System.out.println(s);
				}
				System.out.println("������ �й� : ");
				StudentVO s = new StudentVO();
				s.setId(scanner.nextInt());
				while(controller.findById(s) == null) {
					System.out.println("�߸��� �й��Դϴ�.");
					System.out.println("������ �й� : ");
					s.setId(scanner.nextInt());
				}
				scanner.nextLine();
				s = viewer.setInformation(scanner, s.getId());
				
				
				controller.set(s);
			} else if(choice == 4) {
				if(list.size() == 0) {
					System.out.println("�Էµ� �л��� �����ϴ�.");
					continue;
				}
				for(StudentVO s : list) {
					System.out.println(s);
				}
				System.out.println("������ �й� : ");
				StudentVO s = new StudentVO();
				s.setId(scanner.nextInt());
				while(controller.findById(s) == null) {
					System.out.println("�߸��� �й��Դϴ�.");
					System.out.println("������ �й� : ");
					s.setId(scanner.nextInt());
				}
				scanner.nextLine();
				controller.remove(s);
			} else if(choice == 5) {
			
				System.out.println("������ּż� �����մϴ�.");
				break;
			}

		}
	}

}
