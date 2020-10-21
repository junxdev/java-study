package com.bit.day15;

import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("총 학생 수: ");
		int maxNumber = Integer.parseInt(sc.nextLine());
		
		String[] data;
		data = new String[maxNumber];
		
		int numberCount = 0;
		
		while(true) {
			System.out.print("1.조회 2.입력 3.수정 4.삭제 0.종료 > ");
			String mainMenu = sc.nextLine();
			
			if(mainMenu.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if(mainMenu.equals("1")) {
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균");
				System.out.println("---------------------------------------------");
				for(int i = 0; i < data.length; i++) {
					if(data[i] == null) {
						continue;
					}
					System.out.println(data[i]);
				}
			} else if(mainMenu.equals("2")) {
				if(numberCount < maxNumber) {
					String studentTemp = "";
					System.out.print("이름 > ");
					String name = sc.nextLine();
					System.out.print("국어 > ");
					int kor = Integer.parseInt(sc.nextLine());
					System.out.print("영어 > ");
					int eng = Integer.parseInt(sc.nextLine());
					System.out.print("수학 > ");
					int math = Integer.parseInt(sc.nextLine());
					double avg = (kor + eng + math) * 100 / 3 / 100.0;
					studentTemp = (numberCount + 1) + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + avg;
					
					data[numberCount] = studentTemp;
					numberCount++;
				} else if(numberCount >= maxNumber) {
					System.out.print("현재 정원은 " + maxNumber + "명입니다.\n학생을 추가하시겠습니까? 1.추가 2.취소 >");
					if(Integer.parseInt(sc.nextLine()) == 1) {
						maxNumber++;
						
						System.out.println("학생을 추가합니다.");	String studentTemp = "";
						System.out.print("이름 > ");
						String name = sc.nextLine();
						System.out.print("국어 > ");
						int kor = Integer.parseInt(sc.nextLine());
						System.out.print("영어 > ");
						int eng = Integer.parseInt(sc.nextLine());
						System.out.print("수학 > ");
						int math = Integer.parseInt(sc.nextLine());
						double avg = (kor + eng + math) * 100 / 3 / 100.0;
						studentTemp = (numberCount + 1) + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + avg;
						
						String[] dataTemp =  new String[maxNumber];
						for(int i = 0; i < data.length; i++) {
							dataTemp[i] = data[i];
						}
						dataTemp[maxNumber - 1] = studentTemp;
						data = dataTemp;
						
						numberCount++;
					} else {
						System.out.println("학생을 추가하지 않습니다.");
						continue;
					}
				}
			} else if(mainMenu.equals("3")) {
				System.out.print("수정하려는 학번을 입력하세요 > ");
				int numberEdit = Integer.parseInt(sc.nextLine());
				try {
					if(data[numberEdit - 1] != null) {
						String studentTemp = "";
						System.out.print("이름 > ");
						String name = sc.nextLine();
						System.out.print("국어 > ");
						int kor = Integer.parseInt(sc.nextLine());
						System.out.print("영어 > ");
						int eng = Integer.parseInt(sc.nextLine());
						System.out.print("수학 > ");
						int math = Integer.parseInt(sc.nextLine());
						double avg = (kor + eng + math) * 100 / 3 / 100.0;
						studentTemp = numberEdit + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + avg;
						
						data[numberEdit - 1] = studentTemp;
					} else {
						System.out.println("학번 " + numberEdit + " 학생이 없습니다.");
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("학번 " + numberEdit + " 학생이 없습니다.");
				}
			} else if(mainMenu.equals("4")) {
				System.out.print("삭제하려는 학번을 입력하세요 > ");
				int numberDelete = Integer.parseInt(sc.nextLine());
				try {
					if(data[numberDelete - 1] != null) {
						data[numberDelete - 1] = null;
					} else {
						System.out.println("학번 " + numberDelete + " 학생이 없습니다.");
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("학번 " + numberDelete + " 학생이 없습니다.");
				}
			} else {
				System.out.println(mainMenu + " 잘못된 입력입니다. 다시 선택해주세요.");
			}
		}
	}

}
