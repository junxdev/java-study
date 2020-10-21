package com.bit.day14;

public class AnswerStudent01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 학생성적관리프로그램 ver 0.1.1
		// 학번 이름 국어 영어 수학
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String[] data = null;
		System.out.print("총원 : ");
		data = new String[Integer.parseInt(sc.nextLine())];
		int err = 0;
		int cnt = 0;
		while(true) {
			System.out.print("1.보기 2.입력 3.수정 4.삭제 0.종료 : ");
			String input = sc.nextLine();
			if (input.equals("0")) { 
				break;
			} else if (input.equals("1")) { err = 0;
				System.out.println("----------------------------------------------");
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균");
				System.out.println("----------------------------------------------");
				for(int i = 0; i < data.length; i++) {
					if(data[i] == null) {
						continue;
					}
					String[] student = data[i].split(",");
					int num = Integer.parseInt(student[0]);
					String name = student[1];
					int kor = Integer.parseInt(student[2]);
					int eng = Integer.parseInt(student[3]);
					int math = Integer.parseInt(student[4]);
					double avg = (kor + eng + math) * 100 / 3 / 100.0;
					
					System.out.println(num + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + avg);
				}
				System.out.println("----------------------------------------------");
			} else if (input.equals("2")) { err = 0;
				if(cnt < data.length) {
					System.out.print("이름 : ");
					String name = sc.nextLine();
					System.out.print("국어 : ");
					int kor = Integer.parseInt(sc.nextLine().replace("\t", ""));
					System.out.print("영어 : ");
					int eng = Integer.parseInt(sc.nextLine().replace("\t", ""));
					System.out.print("수학 : ");
					int math= Integer.parseInt(sc.nextLine().replace("\t", ""));
					
					data[cnt++] = cnt + "," + name + "," + kor + "," + eng + "," + math;
				} else {
					System.out.println("총원을 초과했습니다.");
				}
			} else if (input.equals("3")) { err = 0;
				System.out.print("학번 : ");
				int num = Integer.parseInt(sc.nextLine());
				if(num < 1 || num > data.length) {
					System.out.println("찾는 학생이 없습니다.");
				} else if(data[num] == null) {
					System.out.println("찾는 학생이 없습니다.");
				} else {
					System.out.print("이름 : ");
					String name = sc.nextLine();
					System.out.print("국어 : ");
					int kor = Integer.parseInt(sc.nextLine().replace("\t", ""));
					System.out.print("영어 : ");
					int eng = Integer.parseInt(sc.nextLine().replace("\t", ""));
					System.out.print("수학 : ");
					int math= Integer.parseInt(sc.nextLine().replace("\t", ""));
					
					data[num - 1] = num + "," + name + "," + kor + "," + eng + "," + math;
					
				}
			} else if (input.equals("4")) { err = 0;
				System.out.print("학번 : ");
				int num = Integer.parseInt(sc.nextLine());
				if(num < 1 || num > data.length) {
					System.out.println("찾는 학생이 없습니다.");
				} else if(data[num - 1] == null) {
					System.out.println("찾는 학생이 없습니다.");
				} else {
					data[num - 1] = null;
				}
			} else {
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택해주세요.\n남은 선택 횟수 : " + (3 - err) +  "번\n");
				if (err++ > 3) {
					System.out.print("잘못된 접근입니다. ");
					break;
				}
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
