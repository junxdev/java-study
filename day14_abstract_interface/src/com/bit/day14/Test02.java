package com.bit.day14;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.println("�� �л� �� : ");
		int maxNumber = Integer.parseInt(sc.nextLine());
		
		String data = "\n";
		int numberCount = 0;
		while(true) {
			System.out.println("1.��ȸ 2.�Է� 3.���� 4.���� 0.���� > ");
			String mainSelect = sc.nextLine();
			
			if(mainSelect.equals("0")) {
				break;
			} else if(mainSelect.equals("1")) {
				System.out.println("�й�\t�̸�\t����\t����\t����\t���");
				System.out.print("--------------------------------------------");
//				System.out.print("\n1\tjohn\t99\t51\t34\t43\n2\tkim\t88\t44\t88\t23\n");
				System.out.print(data);
			} else if(mainSelect.equals("2")) {
				int number = ++numberCount;
				System.out.print("�̸� > ");
				String name = sc.nextLine();
				System.out.print("���� > ");
				int kor = Integer.parseInt(sc.nextLine());
				System.out.print("���� > ");
				int eng = Integer.parseInt(sc.nextLine());
				System.out.print("���� > ");
				int math = Integer.parseInt(sc.nextLine());
				double avg = (kor + eng + math) * 100 / 3 / 100.0;
				data += number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + avg + "\n";
			} else if(mainSelect.equals("3")) {
				System.out.print("�й� > ");
				int editNumber = Integer.parseInt(sc.nextLine());
				int editIndex = data.indexOf("\n" + editNumber);
				if(editIndex != -1) {
					while(true) {
						System.out.print("������ �����Ͻðڽ��ϱ�?\n1.�̸� 2.���� 3.���� 4.���� 0.���� �޴��� > ");
						String editInput = sc.nextLine();
						if(editInput.equals("0")) {
							break;
						} else if(editInput.equals("1")) {
							int nameBeginIndex = data.indexOf("\t", editIndex + 1);
							int nameEndIndex = data.indexOf("\t", nameBeginIndex + 1);
							String nameEdit = data.substring(nameBeginIndex, nameEndIndex);
							System.out.print("�̸� > ");
							String nameNew = "\t" + sc.nextLine();
							data = data.replace(nameEdit, nameNew);
							break;
						} else if(editInput.equals("2")) {
							int korBeginIndex = data.indexOf("\t", data.indexOf("\t", editIndex + 1) + 1);
							int korEndIndex = data.indexOf("\t", korBeginIndex + 1);
							String korEdit = data.substring(korBeginIndex, korEndIndex);
							System.out.print("���� > ");
							String korNew = "\t" + sc.nextLine();
							data = data.replace(korEdit, korNew);
							break;
						} else if(editInput.equals("3")) {
							int engBeginIndex = data.indexOf("\t", data.indexOf("\t", data.indexOf("\t", editIndex + 1) + 1) + 1);
							int engEndIndex = data.indexOf("\t", engBeginIndex + 1);
							String engEdit = data.substring(engBeginIndex, engEndIndex);
							System.out.print("���� > ");
							String engNew = "\t" + sc.nextLine();
							data = data.replace(engEdit, engNew);
							break;
						} else if(editInput.equals("4")) {
							int mathBeginIndex = data.indexOf("\t", data.indexOf("\t", data.indexOf("\t", data.indexOf("\t", editIndex + 1) + 1) + 1) + 1);
							int mathEndIndex = data.indexOf("\t", mathBeginIndex + 1);
							String mathEdit = data.substring(mathBeginIndex, mathEndIndex);
							System.out.print("���� > ");
							String mathNew = "\t" + sc.nextLine();
							data = data.replace(mathEdit, mathNew);
							break;
						} else {
							System.out.println("�߸��� �Է��Դϴ�.");
						}
					}
				} else {
					System.out.println("�й��� \"" + editNumber + "\"�� �л��� ã�� �� �����ϴ�.\n");
				}
			} else if(mainSelect.equals("4")) {
				System.out.print("�й� > ");
				int deleteNumber = Integer.parseInt(sc.nextLine());
				int deleteIndex = data.indexOf("\n" + deleteNumber);
				if(deleteIndex != -1) {
					int deleteBegin = data.indexOf("\n", deleteIndex);
					int deleteEnd = data.indexOf("\n", deleteIndex + 1);
					String deleteData = data.substring(deleteBegin, deleteEnd);
					data = data.replace(deleteData, "");
				} else {
					System.out.println("�й��� " + deleteNumber + "�� �л��� ã�� �� �����ϴ�.\n");
				}
			} else {
				System.out.println("�߸��� �Է��Դϴ�.\n");
			}
		}
		
		

	}

}
