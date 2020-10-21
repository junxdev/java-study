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
		System.out.print("이름 > ");
		this.name = sc.nextLine();
		System.out.print("국어 > ");
		this.kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어 > ");
		this.eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 > ");
		this.math = Integer.parseInt(sc.nextLine());
	}
	
}
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("총 학생 수: ");
		int maxNumber = Integer.parseInt(sc.nextLine());
		
		Student3[] data;
		data = new Student3[maxNumber];
		
		
		int studentCount = 0;
		boolean program = true;
		
		while(program) {
			System.out.print("1.조회 2.입력 3.수정 4.삭제 0.종료 \n> ");
			int mainMenu = Integer.parseInt(sc.nextLine());
			switch (mainMenu) {
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				program = false;
				break;
			case 1 :
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균");
				System.out.println("---------------------------------------------");
				for(int i = 0; i < data.length; i++) {
					if(data[i] != null) {
						Student3 student = data[i];
						student.readData();
					}
				}
				break;
			case 2 :
				//입력
				Student3 student = new Student3(studentCount + 1); // 학번 1번부터 시작
				student.writeData();
				data[studentCount++] = student; // 입력된 학생 수 증가
				break;
			case 3 :
				System.out.print("수정할 학생의 학번 > ");
				int numberToEdit = Integer.parseInt(sc.nextLine());
				int studentToEdit = -1;
				
				if(numberToEdit > data.length|| numberToEdit < 1) {
					System.out.println("올바른 입력이 아닙니다.");
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
					System.out.println("찾는 학생이 존재하지 않습니다.");
				}
				break;
			case 4 :
				System.out.print("삭제할 학생의 학번 > ");
				int numberToDelete = Integer.parseInt(sc.nextLine());
				int studentToDelete = -1;
				
				if(numberToDelete > data.length || numberToDelete < 1) {
					System.out.println("올바른 입력이 아닙니다.");
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
					System.out.println("찾는 학생이 존재하지 않습니다.");
				}
				break;
			default : 
				System.out.println("올바른 입력이 아닙니다.");	
			} // switch end
		} // while end
	} // main end
} // class end
