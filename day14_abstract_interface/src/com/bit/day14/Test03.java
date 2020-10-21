package com.bit.day14;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("총 학생 수 : ");
		int maxNumber = sc.nextInt();
		int numberCount = 0;
		
		int[][] student = null;
		student = new int[maxNumber][];
		
		while(true) {
			System.out.print("1.조회 2.입력 3.수정 4.삭제 0.종료 > ");
			int mainSelect = sc.nextInt();
			
			if(mainSelect == 0) {
				break;
			} else if(mainSelect == 1) {
				System.out.println("학번\t국어\t영어\t수학\t평균");
				System.out.println("--------------------------------------------");
				for(int i = 0; i < maxNumber; i++) {
					if(student[i] == null) {
						continue;
					}
					System.out.print(student[i][0] + "\t");
					System.out.print(student[i][1] + "\t");
					System.out.print(student[i][2] + "\t");
					System.out.print(student[i][3] + "\t");
					System.out.print(((student[i][1] + student[i][2] + student[i][3]) * 100 / 3 / 100.0) + "\n");
				}
			} else if(mainSelect == 2) {
				if(numberCount < maxNumber) {
					int[] studentTemp = new int[4];
					studentTemp[0] = numberCount + 1;
					System.out.print("국어 > ");
					studentTemp[1] = sc.nextInt();
					System.out.print("영어 > ");
					studentTemp[2] = sc.nextInt();
					System.out.print("수학 > ");
					studentTemp[3] = sc.nextInt();
					student[numberCount++] = studentTemp;
				} else {
					System.out.println("정원을 초과했습니다.");
				}
			} else if(mainSelect == 3) {
				System.out.print("수정할 학번 > ");
				int numberDelete = sc.nextInt();
				if(numberDelete < 1 || numberDelete > maxNumber) {
					System.out.println("잘못된 입력입니다.");
					continue;
				}
				if(student[numberDelete - 1] != null) {
					int[] studentTemp = new int[4];
					studentTemp[0] = numberDelete;
					System.out.print("국어 > ");
					studentTemp[1] = sc.nextInt();
					System.out.print("영어 > ");
					studentTemp[2] = sc.nextInt();
					System.out.print("수학 > ");
					studentTemp[3] = sc.nextInt();
					student[numberDelete - 1] = studentTemp;
				} else {
					System.out.println("학생을 찾을 수 없습니다.");
				}
			} else if(mainSelect == 4) {
				System.out.print("삭제할 학번 > ");
				int numberDelete = sc.nextInt();
				if(numberDelete < 1 || numberDelete > maxNumber) {
					System.out.println("잘못된 입력입니다.");
					continue;
				}
				if(student[numberDelete - 1] != null) {
					student[numberDelete - 1] = null;
				} else {
					System.out.println("학생을 찾을 수 없습니다.");
				}
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
	}

}
