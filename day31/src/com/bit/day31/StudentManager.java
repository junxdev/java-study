package com.bit.day31;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Student {
	private int number, korean, english, math;
	private String name;
	
	public Student(int number, String name) {
		// TODO Auto-generated constructor stub
		setNumber(number);
		setName(name);
	}
	
	public Student(int number, String name, int korean, int english, int math) {
		// TODO Auto-generated constructor stub
		setNumber(number);
		setName(name);
		setKorean(korean);
		setEnglish(english);
		setMath(math);
	}
	
	int getTotal() {
		return korean + english + math;
	}
	
	double getAverage() {
		return (getTotal() * 100 / 3) / 100.0;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if(number < 0) return;
		this.number = number;
	}

	public int getKorean() {
		return korean;
	}

	public boolean setKorean(int korean) {
		if(korean < 0 || korean > 100) return false;
		this.korean = korean;
		return true;
	}

	public int getEnglish() {
		return english;
	}

	public boolean setEnglish(int english) {
		if(english < 0 || english > 100) return false;
		this.english = english;
		return true;
	}

	public int getMath() {
		return math;
	}

	public boolean setMath(int math) {
		if(math < 0 || math > 100) return false;
		this.math = math;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

public class StudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Student> data = new TreeMap<Integer, Student>();
		
		Student tempStudent = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("�л������������α׷� Ver 1.0.0");
		System.out.println("-------------------------------------------");
		String newLine = "\n";
		
		//load data from DB table studentmanager
		new oracle.jdbc.driver.OracleDriver();
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		java.util.Properties property = new java.util.Properties();
		property.setProperty("user", "scott");
		property.setProperty("password", "tiger");
		
		String selectAllQuery = "select * from studentmanager";
		
		java.sql.Connection connection = null;
		java.sql.Statement statement = null;
		java.sql.ResultSet resultSet = null;
		try {
			connection = java.sql.DriverManager.getConnection(url, property);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectAllQuery);
			while(resultSet.next()) {
				int number = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int korean = resultSet.getInt(3);
				int english = resultSet.getInt(4);
				int math = resultSet.getInt(5);
				tempStudent = new Student(number, name, korean, english, math);
				data.put(number, tempStudent);
			}
			System.out.println("�����ͺ��̽��� ����� �����͸� �ҷ��Խ��ϴ�.");
			System.out.print(newLine);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace(); ù ���� �� ���̺��� ��� �ҷ����� ���� �� ������ ��� ����
			System.out.println("�����ͺ��̽��� ����� �����Ͱ� �����ϴ�.");
			System.out.print(newLine);
		} 
		
		while(true) {
			System.out.print("1.��ü 2.�� 3.�Է� 4.���� 5.���� 0.���� > ");
			String mainMenu = scanner.nextLine();
			System.out.print(newLine);
			
			try {
				if("0".equals(mainMenu)) {
					boolean exit = false;
					System.out.println("������ �����͸� �����ͺ��̽��� �����Ͻðڽ��ϱ�?");
					System.out.print("1.���� 0.�������� �ʰ� ���� > ");
					switch (scanner.nextLine()) {
						case "1":
							String createTable = "create table studentmanager ("
									+ "st_num number,"
									+ "st_name varchar2(10),"
									+ "st_kor number,"
									+ "st_eng number,"
									+ "st_math number"
									+ ")";
							String clearTable = "truncate table studentmanager";
							try {
								statement.executeUpdate(createTable);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
//								e1.printStackTrace(); �ߺ� ���� ������ ��� ����
							}
							try {
								statement.executeUpdate(clearTable);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
//								e1.printStackTrace(); 
							}
							Iterator<Integer> numberIterator = data.keySet().iterator();
							while(numberIterator.hasNext()) {
								tempStudent = data.get(numberIterator.next());
								String output = tempStudent.getNumber() + ", '" + tempStudent.getName() + 
										"', " + tempStudent.getKorean() + ", " + tempStudent.getEnglish() + ", " + tempStudent.getMath();
								String insertQuery = "insert into studentmanager (st_num, st_name, st_kor, st_eng, st_math) "
										+ "values (" + output + ")";
//								System.out.println(insertQuery);
								try {
									statement.executeUpdate(insertQuery);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
//									e.printStackTrace(); insert query ������ ��� ����
								}
							}
							System.out.println("������ �����͸� �����ͺ��̽��� �����߽��ϴ�.");
							System.out.println("���α׷��� �����մϴ�.");
							exit = true;
							break;
						case "0":
							System.out.println("���α׷��� �����մϴ�.");
							exit = true;
							break;
						default:
							System.out.println("�Է� ����: �ùٸ� ���ڸ� �Է����ּ���.");
							System.out.print(newLine);
					}
					if(exit == true) {
						break;
					}
					
				// ��ü ��ȸ ���
				} else if("1".equals(mainMenu)) {
					if(data.isEmpty()) {
						System.out.println("���α׷��� ��ϵ� �л��� �����ϴ�.");
						System.out.print(newLine);
						continue;
					}
					Iterator<Integer> numberIterator = data.keySet().iterator();
					System.out.println("�й�\t�̸�\t����\t����\t����");
					System.out.println("--------------------------------------");
					while(numberIterator.hasNext()) {
						tempStudent = data.get(numberIterator.next());
						String output = tempStudent.getNumber() + "\t" + tempStudent.getName() + 
								"\t" + tempStudent.getKorean() + "\t" + tempStudent.getEnglish() + "\t" + tempStudent.getMath();
						System.out.println(output);
					}
					System.out.print(newLine);
					
				// �� ��ȸ ���
				} else if("2".equals(mainMenu)) {
					System.out.print("ã�� �л��� �й� > ");
					int number = Integer.parseInt(scanner.nextLine());
					if(data.containsKey(number)) {
						tempStudent = data.get(number);
						String output=  "�й�:" + tempStudent.getNumber() + "\t�̸�:" + tempStudent.getName() +
									"\n����:" + tempStudent.getKorean() + "\t����:" + tempStudent.getEnglish() + "\t����:" + tempStudent.getMath() +
									"\n����:" + tempStudent.getTotal() +
									"\n���:" + tempStudent.getAverage();
						System.out.println(output);
					} else {
						System.out.println("ã�� ����� �����ϴ�.");
					}
					System.out.print(newLine);
					
				// �Է� ���					
				} else if("3".equals(mainMenu)) {
					int number;
					while(true) {
						System.out.print("�й� > ");
						number = Integer.parseInt(scanner.nextLine());
						if(!data.containsKey(number)) break;
						System.out.println("���� �й��� ���� �л��� �����մϴ�.");
						tempStudent = data.get(number);
						String output=  "�й�:" + tempStudent.getNumber() + " �̸�:" + tempStudent.getName() +
									" ����:" + tempStudent.getKorean() + " ����:" + tempStudent.getEnglish() + " ����:" + tempStudent.getMath();
						System.out.println(output);
					}
					System.out.print("�̸� > ");
					String name = scanner.nextLine();
					System.out.print("���� > ");
					int korean = Integer.parseInt(scanner.nextLine());
					System.out.print("���� > ");
					int english = Integer.parseInt(scanner.nextLine());
					System.out.print("���� > ");
					int math = Integer.parseInt(scanner.nextLine());
					tempStudent = new Student(number, name);
					if(!tempStudent.setKorean(korean) ||
					   !tempStudent.setEnglish(english) ||
					   !tempStudent.setMath(math)) {
						System.out.println("�Է� ���� : ����, ����, ������ 0���� 100 ������ ������ �Է��� �� �ֽ��ϴ�.");
						System.out.print(newLine);
						continue;
					}
					data.put(tempStudent.getNumber(), tempStudent);
					System.out.print(newLine);
					
				// ���� ���
				} else if("4".equals(mainMenu)) {
					boolean checkScore = false;
					System.out.print("������ �л��� �й� > ");
					int number = Integer.parseInt(scanner.nextLine());
					if(data.containsKey(number)) {
						tempStudent = data.get(number);
						System.out.println("�й�:" + tempStudent.getNumber() + "\t�̸�:" + tempStudent.getName());
						;
						while(true) {
							System.out.print("����>");
							if(tempStudent.setKorean(Integer.parseInt(scanner.nextLine()))) break;
							System.out.println("�Է� ���� :  0���� 100 ������ ������ �Է��� �� �ֽ��ϴ�.");
						};
						while(true) {
							System.out.print("����>");
							if(tempStudent.setEnglish(Integer.parseInt(scanner.nextLine()))) break;
							System.out.println("�Է� ���� : 0���� 100 ������ ������ �Է��� �� �ֽ��ϴ�.");
							
						}
						while(true) {
							System.out.print("����>");
							if(tempStudent.setMath(Integer.parseInt(scanner.nextLine()))) break;
							System.out.println("�Է� ���� : 0���� 100 ������ ������ �Է��� �� �ֽ��ϴ�.");
						}
						data.replace(number, tempStudent);
					} else {
						System.out.println("ã�� ����� �����ϴ�.");
					}
					System.out.print(newLine);
				
				// ���� ���
				} else if("5".equals(mainMenu)) {
					System.out.print("������ �л��� �й� > ");
					int number = Integer.parseInt(scanner.nextLine());
					if(data.containsKey(number)) {
						data.remove(number);
						System.out.println(number + "�� �л��� �����߽��ϴ�.");
					} else {
						System.out.println("ã�� ����� �����ϴ�.");
					}
					System.out.print(newLine);
				}  
			
			// int �Է¿� int �� �����͸� �Է� �� ����
			} catch (NumberFormatException e) {
				System.out.println("�Է� ����: �й�, ����, ����, ������ ���ڸ� �Է��� �� �ֽ��ϴ�.");
				System.out.print(newLine);
			}
		}
		try {
			if(resultSet != null) resultSet.close();
			if(statement != null) statement.close();
			if(connection != null) connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(scanner != null) scanner.close();
	}

}
