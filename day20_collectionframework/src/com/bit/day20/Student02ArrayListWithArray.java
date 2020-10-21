package com.bit.day20;

public class Student02ArrayListWithArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ArrayList data = new java.util.ArrayList();
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String input;
		
		while(true) {
			System.out.print("1.조회 2.입력 3.수정 4.삭제 0.종료 > ");
			input = sc.nextLine();
			
			if(input.equals("0")) {
			} else if(input.equals("1")) {
				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
				for(int i = 0; i < data.size();) {
					String[] student = (String[])data.get(i);
					int kor = Integer.parseInt(student[2]);
					int eng = Integer.parseInt(student[3]);
					int math = Integer.parseInt(student[4]);
					int sum = kor + eng + math;
					double avg = (sum * 100 / 3) / 100.0;
					System.out.println(student[0] + "\t" + student[1] + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg);
				}
			} else if(input.equals("2")) {
				String[] student = new String[5]; // 전체 데이터 열의 수는 유동적이나 각 학생의 데이터 열의 수는 같으므로 배열 활용
				System.out.print("학번 > ");
				student[0] = sc.nextLine(); // 다양한 자료형을 활용하려면 Object[] 활용
				System.out.print("이름 > ");
				student[1] = sc.nextLine();
				System.out.print("국어 > ");
				student[2] = sc.nextLine();
				System.out.print("영어 > ");
				student[3] = sc.nextLine();
				System.out.print("수학 > ");
				student[4] = sc.nextLine();
				data.add(student);
			} else if(input.equals("3")) {
				System.out.print("학번 > ");
				String number = sc.nextLine();
				int index = -1;
				for(int i = 0; i < data.size(); i++) {
					if(number == ((String[])data.get(i))[0]) {
						index = i;
						break;
					}
				}
				
				if(index > -1) {
					String[] student = (String[])data.get(index);
					System.out.print("이름 > ");
					student[1] = sc.nextLine();
					System.out.print("국어 > ");
					student[2] = sc.nextLine();
					System.out.print("영어 > ");
					student[3] = sc.nextLine();
					System.out.print("수학 > ");
					student[4] = sc.nextLine();
					data.set(index, student);
				} else {
					System.out.println("찾는 대상이 없습니다.");
				}
				
			} else if(input.equals("4")) {
				System.out.print("학번 > ");
				int number = Integer.parseInt(sc.nextLine());
				int index = -1;
				for(int i = 0; i < data.size(); i += 5) {
					if(number == (int)data.get(i)) {
						index = i;
						break;
					}
				}
				
				if(index > -1) {
					for(int i = 0; i < 5; i++) {
						data.remove(index);
					}
				} else {
					System.out.println("찾는 대상이 없습니다.");
				}
				
			} else {
				System.out.println("올바른 숫자를 입력해주세요.");
				
			}
		}
	}

}
