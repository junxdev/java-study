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
		System.out.println("학생성적관리프로그램 Ver 1.0.0");
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
			System.out.println("데이터베이스에 저장된 데이터를 불러왔습니다.");
			System.out.print(newLine);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace(); 첫 실행 시 테이블이 없어서 불러오지 못할 때 오류문 출력 방지
			System.out.println("데이터베이스에 저장된 데이터가 없습니다.");
			System.out.print(newLine);
		} 
		
		while(true) {
			System.out.print("1.전체 2.상세 3.입력 4.수정 5.삭제 0.종료 > ");
			String mainMenu = scanner.nextLine();
			System.out.print(newLine);
			
			try {
				if("0".equals(mainMenu)) {
					boolean exit = false;
					System.out.println("수정한 데이터를 데이터베이스에 저장하시겠습니까?");
					System.out.print("1.저장 0.저장하지 않고 종료 > ");
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
//								e1.printStackTrace(); 중복 생성 오류문 출력 방지
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
//									e.printStackTrace(); insert query 오류문 출력 방지
								}
							}
							System.out.println("수정한 데이터를 데이터베이스에 저장했습니다.");
							System.out.println("프로그램을 종료합니다.");
							exit = true;
							break;
						case "0":
							System.out.println("프로그램을 종료합니다.");
							exit = true;
							break;
						default:
							System.out.println("입력 오류: 올바른 숫자를 입력해주세요.");
							System.out.print(newLine);
					}
					if(exit == true) {
						break;
					}
					
				// 전체 조회 기능
				} else if("1".equals(mainMenu)) {
					if(data.isEmpty()) {
						System.out.println("프로그램에 등록된 학생이 없습니다.");
						System.out.print(newLine);
						continue;
					}
					Iterator<Integer> numberIterator = data.keySet().iterator();
					System.out.println("학번\t이름\t국어\t영어\t수학");
					System.out.println("--------------------------------------");
					while(numberIterator.hasNext()) {
						tempStudent = data.get(numberIterator.next());
						String output = tempStudent.getNumber() + "\t" + tempStudent.getName() + 
								"\t" + tempStudent.getKorean() + "\t" + tempStudent.getEnglish() + "\t" + tempStudent.getMath();
						System.out.println(output);
					}
					System.out.print(newLine);
					
				// 상세 조회 기능
				} else if("2".equals(mainMenu)) {
					System.out.print("찾는 학생의 학번 > ");
					int number = Integer.parseInt(scanner.nextLine());
					if(data.containsKey(number)) {
						tempStudent = data.get(number);
						String output=  "학번:" + tempStudent.getNumber() + "\t이름:" + tempStudent.getName() +
									"\n국어:" + tempStudent.getKorean() + "\t영어:" + tempStudent.getEnglish() + "\t수학:" + tempStudent.getMath() +
									"\n총점:" + tempStudent.getTotal() +
									"\n평균:" + tempStudent.getAverage();
						System.out.println(output);
					} else {
						System.out.println("찾는 대상이 없습니다.");
					}
					System.out.print(newLine);
					
				// 입력 기능					
				} else if("3".equals(mainMenu)) {
					int number;
					while(true) {
						System.out.print("학번 > ");
						number = Integer.parseInt(scanner.nextLine());
						if(!data.containsKey(number)) break;
						System.out.println("같은 학번을 가진 학생이 존재합니다.");
						tempStudent = data.get(number);
						String output=  "학번:" + tempStudent.getNumber() + " 이름:" + tempStudent.getName() +
									" 국어:" + tempStudent.getKorean() + " 영어:" + tempStudent.getEnglish() + " 수학:" + tempStudent.getMath();
						System.out.println(output);
					}
					System.out.print("이름 > ");
					String name = scanner.nextLine();
					System.out.print("국어 > ");
					int korean = Integer.parseInt(scanner.nextLine());
					System.out.print("영어 > ");
					int english = Integer.parseInt(scanner.nextLine());
					System.out.print("수학 > ");
					int math = Integer.parseInt(scanner.nextLine());
					tempStudent = new Student(number, name);
					if(!tempStudent.setKorean(korean) ||
					   !tempStudent.setEnglish(english) ||
					   !tempStudent.setMath(math)) {
						System.out.println("입력 오류 : 국어, 영어, 수학은 0부터 100 사이의 정수만 입력할 수 있습니다.");
						System.out.print(newLine);
						continue;
					}
					data.put(tempStudent.getNumber(), tempStudent);
					System.out.print(newLine);
					
				// 수정 기능
				} else if("4".equals(mainMenu)) {
					boolean checkScore = false;
					System.out.print("수정할 학생의 학번 > ");
					int number = Integer.parseInt(scanner.nextLine());
					if(data.containsKey(number)) {
						tempStudent = data.get(number);
						System.out.println("학번:" + tempStudent.getNumber() + "\t이름:" + tempStudent.getName());
						;
						while(true) {
							System.out.print("국어>");
							if(tempStudent.setKorean(Integer.parseInt(scanner.nextLine()))) break;
							System.out.println("입력 오류 :  0부터 100 사이의 정수만 입력할 수 있습니다.");
						};
						while(true) {
							System.out.print("영어>");
							if(tempStudent.setEnglish(Integer.parseInt(scanner.nextLine()))) break;
							System.out.println("입력 오류 : 0부터 100 사이의 정수만 입력할 수 있습니다.");
							
						}
						while(true) {
							System.out.print("수학>");
							if(tempStudent.setMath(Integer.parseInt(scanner.nextLine()))) break;
							System.out.println("입력 오류 : 0부터 100 사이의 정수만 입력할 수 있습니다.");
						}
						data.replace(number, tempStudent);
					} else {
						System.out.println("찾는 대상이 없습니다.");
					}
					System.out.print(newLine);
				
				// 삭제 기능
				} else if("5".equals(mainMenu)) {
					System.out.print("삭제할 학생의 학번 > ");
					int number = Integer.parseInt(scanner.nextLine());
					if(data.containsKey(number)) {
						data.remove(number);
						System.out.println(number + "번 학생을 삭제했습니다.");
					} else {
						System.out.println("찾는 대상이 없습니다.");
					}
					System.out.print(newLine);
				}  
			
			// int 입력에 int 외 데이터를 입력 시 오류
			} catch (NumberFormatException e) {
				System.out.println("입력 오류: 학번, 국어, 영어, 수학은 숫자만 입력할 수 있습니다.");
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
