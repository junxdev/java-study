package com.bit.day14;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.println("총 학생 수 : ");
		int maxNumber = Integer.parseInt(sc.nextLine());
		
		String data = "\n";
		int numberCount = 0;
		while(true) {
			System.out.println("1.조회 2.입력 3.수정 4.삭제 0.종료 > ");
			String mainSelect = sc.nextLine();
			
			if(mainSelect.equals("0")) {
				break;
			} else if(mainSelect.equals("1")) {
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균");
				System.out.print("--------------------------------------------");
//				System.out.print("\n1\tjohn\t99\t51\t34\t43\n2\tkim\t88\t44\t88\t23\n");
				System.out.print(data);
			} else if(mainSelect.equals("2")) {
				int number = ++numberCount;
				System.out.print("이름 > ");
				String name = sc.nextLine();
				System.out.print("국어 > ");
				int kor = Integer.parseInt(sc.nextLine());
				System.out.print("영어 > ");
				int eng = Integer.parseInt(sc.nextLine());
				System.out.print("수학 > ");
				int math = Integer.parseInt(sc.nextLine());
				double avg = (kor + eng + math) * 100 / 3 / 100.0;
				data += number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + avg + "\n";
			} else if(mainSelect.equals("3")) {
				System.out.print("학번 > ");
				int editNumber = Integer.parseInt(sc.nextLine());
				int editIndex = data.indexOf("\n" + editNumber);
				if(editIndex != -1) {
					while(true) {
						System.out.print("무엇을 수정하시겠습니까?\n1.이름 2.국어 3.영어 4.수학 0.메인 메뉴로 > ");
						String editInput = sc.nextLine();
						if(editInput.equals("0")) {
							break;
						} else if(editInput.equals("1")) {
							int nameBeginIndex = data.indexOf("\t", editIndex + 1);
							int nameEndIndex = data.indexOf("\t", nameBeginIndex + 1);
							String nameEdit = data.substring(nameBeginIndex, nameEndIndex);
							System.out.print("이름 > ");
							String nameNew = "\t" + sc.nextLine();
							data = data.replace(nameEdit, nameNew);
							break;
						} else if(editInput.equals("2")) {
							int korBeginIndex = data.indexOf("\t", data.indexOf("\t", editIndex + 1) + 1);
							int korEndIndex = data.indexOf("\t", korBeginIndex + 1);
							String korEdit = data.substring(korBeginIndex, korEndIndex);
							System.out.print("국어 > ");
							String korNew = "\t" + sc.nextLine();
							data = data.replace(korEdit, korNew);
							break;
						} else if(editInput.equals("3")) {
							int engBeginIndex = data.indexOf("\t", data.indexOf("\t", data.indexOf("\t", editIndex + 1) + 1) + 1);
							int engEndIndex = data.indexOf("\t", engBeginIndex + 1);
							String engEdit = data.substring(engBeginIndex, engEndIndex);
							System.out.print("영어 > ");
							String engNew = "\t" + sc.nextLine();
							data = data.replace(engEdit, engNew);
							break;
						} else if(editInput.equals("4")) {
							int mathBeginIndex = data.indexOf("\t", data.indexOf("\t", data.indexOf("\t", data.indexOf("\t", editIndex + 1) + 1) + 1) + 1);
							int mathEndIndex = data.indexOf("\t", mathBeginIndex + 1);
							String mathEdit = data.substring(mathBeginIndex, mathEndIndex);
							System.out.print("수학 > ");
							String mathNew = "\t" + sc.nextLine();
							data = data.replace(mathEdit, mathNew);
							break;
						} else {
							System.out.println("잘못된 입력입니다.");
						}
					}
				} else {
					System.out.println("학번이 \"" + editNumber + "\"인 학생을 찾을 수 없습니다.\n");
				}
			} else if(mainSelect.equals("4")) {
				System.out.print("학번 > ");
				int deleteNumber = Integer.parseInt(sc.nextLine());
				int deleteIndex = data.indexOf("\n" + deleteNumber);
				if(deleteIndex != -1) {
					int deleteBegin = data.indexOf("\n", deleteIndex);
					int deleteEnd = data.indexOf("\n", deleteIndex + 1);
					String deleteData = data.substring(deleteBegin, deleteEnd);
					data = data.replace(deleteData, "");
				} else {
					System.out.println("학번이 " + deleteNumber + "인 학생을 찾을 수 없습니다.\n");
				}
			} else {
				System.out.println("잘못된 입력입니다.\n");
			}
		}
		
		

	}

}
