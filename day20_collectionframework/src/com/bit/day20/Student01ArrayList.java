package com.bit.day20;

public class Student01ArrayList {

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
					int number = (int)data.get(i++);
					String name = (String)data.get(i++);
					int kor = (int)data.get(i++);
					int eng = (int)data.get(i++);
					int math = (int)data.get(i++);
					int sum = kor + eng + math;
					double avg = (sum * 100 / 3) / 100.0;
					System.out.println(number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg);
				}
			} else if(input.equals("2")) {
				System.out.print("학번 > ");
				input = sc.nextLine();
				data.add(Integer.parseInt(input));
				System.out.print("이름 > ");
				input = sc.nextLine();
				data.add(input);
				System.out.print("국어 > ");
				input = sc.nextLine();
				data.add(Integer.parseInt(input)); // 입력 도중 오류가 발생하면 이미 앞에 add된 데이터를 처리해야 하는 비효율적 작업 발생
				System.out.print("영어 > ");
				input = sc.nextLine();
				data.add(Integer.parseInt(input));
				System.out.print("수학 > ");
				input = sc.nextLine();
				data.add(Integer.parseInt(input));
			} else if(input.equals("3")) {
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
					System.out.print("이름 > ");
					input = sc.nextLine();
					data.set(++index, input);
					System.out.print("국어 > ");
					input = sc.nextLine();
					data.set(++index, input);
					System.out.print("영어 > ");
					input = sc.nextLine();
					data.set(++index, input);
					System.out.print("수학 > ");
					input = sc.nextLine();
					data.set(++index, input);
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
