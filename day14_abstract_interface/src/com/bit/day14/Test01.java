package com.bit.day14;

public class Test01 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// �л������������α׷� ver 0.1.1
		// �й� �̸� ���� ���� ����
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String[] data = null;
		System.out.print("�ѿ� : ");
		data = new String[Integer.parseInt(sc.nextLine())];
		int err = 0;
		int cnt = 0;
		while(true) {
			System.out.print("1.���� 2.�Է� 3.���� 4.���� 0.���� : ");
			String input = sc.nextLine();
			if (input.equals("0")) { 
				break;
			} else if (input.equals("1")) { err = 0;
				System.out.println("----------------------------------------------");
				System.out.println("�й�\t�̸�\t����\t����\t����\t���");
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
					System.out.print("�̸� : ");
					String name = sc.nextLine();
					System.out.print("���� : ");
					int kor = Integer.parseInt(sc.nextLine().replace("\t", ""));
					System.out.print("���� : ");
					int eng = Integer.parseInt(sc.nextLine().replace("\t", ""));
					System.out.print("���� : ");
					int math= Integer.parseInt(sc.nextLine().replace("\t", ""));
					
					data[cnt++] = cnt + "," + name + "," + kor + "," + eng + "," + math;
				} else {
					System.out.println("�ѿ��� �ʰ��߽��ϴ�.");
				}
			} else if (input.equals("3")) { err = 0;
				System.out.print("�й� : ");
				int num = Integer.parseInt(sc.nextLine());
				
				if(num < 1 || num > data.length) {
					System.out.println("ã�� �л��� �����ϴ�.");
				} else {
					boolean num_search = false;
					for(int i = 0; i < data.length; i++) {
						if(data[i] == null) {
							continue;
						}
						String[] student = data[i].split(",");
						int num_stu = Integer.parseInt(student[0]);
						if(num_stu == num) {
							num_search = true;
							num = i;
						}
					}
					if(num_search) {
						String[] student = data[num].split(",");
						int num_stu = Integer.parseInt(student[0]);
						String name = student[1];
						int kor = Integer.parseInt(student[2]);
						int eng = Integer.parseInt(student[3]);
						int math = Integer.parseInt(student[4]);
						double avg = (kor + eng + math) * 100 / 3 / 100.0;
						
						System.out.println(num_stu + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + avg);
						
						while(num_search) {
							System.out.print("������ �����Ͻðڽ��ϱ�?\n1.�̸� 2.���� 3.���� 4.���� 0.���� �޴� : ");
							int num_edit = Integer.parseInt(sc.nextLine());
							
							if(num_edit == 0) {
								System.out.println("������ ����ϰ� ���� �޴��� ���ư��ϴ�.");
								num_search = false;
							} else if(num_edit == 1) {
								System.out.print("�̸� : ");
								String name_edit = sc.nextLine();
								data[num] = num_stu + "," + name_edit + "," + kor + "," + eng + "," + math;
								num_search = false;
							} else if(num_edit == 2) {
								System.out.print("���� : ");
								int kor_edit = Integer.parseInt(sc.nextLine().replace("\t", ""));
								data[num] = num_stu + "," + name + "," + kor_edit + "," + eng + "," + math; 
								num_search = false;
							} else if(num_edit == 3) {
								System.out.print("���� : ");
								int eng_edit = Integer.parseInt(sc.nextLine().replace("\t", ""));
								data[num] = num_stu + "," + name + "," + kor + "," + eng_edit + "," + math;
								num_search = false;
							} else if(num_edit == 4) {
								System.out.print("���� : ");
								int math_edit = Integer.parseInt(sc.nextLine().replace("\t", ""));
								data[num] = num_stu + "," + name + "," + kor + "," + eng + "," + math_edit;
								num_search = false;
							} else {
								System.out.println("�߸��� �Է��Դϴ�.");
							}
						}
					} else {
						System.out.println("ã�� �л��� �����ϴ�.");
					}
					
				}
				
			} else if (input.equals("4")) { err = 0;
				System.out.print("�й� : ");
				int num = Integer.parseInt(sc.nextLine());
				if(num < 1 || num > data.length) {
					System.out.println("ã�� �л��� �����ϴ�.");
				} else if(data[num - 1] == null) {
					System.out.println("ã�� �л��� �����ϴ�.");
				} else {
					data[num - 1] = null;
				}
			} else {
				System.out.println("�߸��� �Է��Դϴ�. �޴��� �ٽ� �������ּ���.\n���� ���� Ƚ�� : " + (3 - err) +  "��\n");
				if (err++ > 3) {
					System.out.print("�߸��� �����Դϴ�. ");
					break;
				}
			}
		}
		System.out.println("���α׷��� �����մϴ�.");

	}

}
