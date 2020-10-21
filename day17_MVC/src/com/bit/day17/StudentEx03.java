package com.bit.day17;

public class StudentEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ArrayList<StudentVO> list = new java.util.ArrayList<StudentVO>();
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		StudentController controller = new StudentController(list);
		StudentViewer viewer = new StudentViewer();
		
		while(true) {
			System.out.println("비트고등학교 성적 입출력 프로그램");
			System.out.println("1.입력 2.출력 3.수정 4.삭제 5.종료\n>");
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
					System.out.println("입력된 학생이 없습니다.");
					continue;
				}
				for(StudentVO s : list) {
					System.out.println(s);
				}
				System.out.println("수정할 학번 : ");
				StudentVO s = new StudentVO();
				s.setId(scanner.nextInt());
				while(controller.findById(s) == null) {
					System.out.println("잘못된 학번입니다.");
					System.out.println("수정할 학번 : ");
					s.setId(scanner.nextInt());
				}
				scanner.nextLine();
				s = viewer.setInformation(scanner, s.getId());
				
				
				controller.set(s);
			} else if(choice == 4) {
				if(list.size() == 0) {
					System.out.println("입력된 학생이 없습니다.");
					continue;
				}
				for(StudentVO s : list) {
					System.out.println(s);
				}
				System.out.println("삭제할 학번 : ");
				StudentVO s = new StudentVO();
				s.setId(scanner.nextInt());
				while(controller.findById(s) == null) {
					System.out.println("잘못된 학번입니다.");
					System.out.println("삭제할 학번 : ");
					s.setId(scanner.nextInt());
				}
				scanner.nextLine();
				controller.remove(s);
			} else if(choice == 5) {
			
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}

		}
	}

}
