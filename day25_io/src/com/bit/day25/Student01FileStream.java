package com.bit.day25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//나는 HashMap만 쓴 반면 HaspMap을 하나의 학생 단위로 설정하고 학생 목록을 ArrayList로 한다.
// HashMap만 쓸 때보다 Key가 각 Column을 대표하기 때문에 데이터 호출이 훨씬 쉽고 직관적이다.
// HashMap<Integer, Object[]> 학번으로 제어하기에 구현이 보다 편리하며 자료의 크기가 작아 메모리 효율성이 높다. 하지만 정적 배열을 사용하여 유동성이 낮다.
// HashMap<Integer, class> 데이터 형변환이 필요 없다. 객체를 다루기 때문에 비교적 무거울 수 있으나 현재의 컴ㅍ터 사양에서는 무리가 없다.
// HashMap<Integer, HashMap<String, class>> 위의 장점과 단점을 모두 보유한다.
// ArrayList<HashMap<String, String>> IO와의 연계가 비교적 편리하다.

public class Student01FileStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<HashMap<String, String>> data = null; 
		data = new ArrayList<>();
		
		String path = "data.bin";
		File file = new File(path);
		FileInputStream fis = null;
		if(file.exists()) {
			ArrayList<Byte> dataByteList = new ArrayList<>();
//			byte[] dataByte = new byte[(int)file.length()];
			try {
				fis = new FileInputStream(file);
				while(true) {
					int dataChunk = fis.read();
					if(dataChunk == -1) {
						break;
					}
					dataByteList.add((byte)dataChunk);
					
				}
//				for(int i = 0; i < dataByte.length; i++) {
//					int dataChunk = fis.read();
//					if(dataChunk == -1) {
//						break;
//					}
//					dataByte[i] = (byte)dataChunk;
//				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			Object[] dataObject = dataByteList.toArray();
			byte[] dataByte = new byte[dataObject.length];
			for(int i = 0; i < dataByte.length; i++) {
				dataByte[i] = (byte)dataObject[i];
			}
			String dataString = new String(dataByte);
			
			String[] dataStringArray = dataString.split("\n");
			for(int i = 0; i < dataStringArray.length; i++) {
				String studentString = dataStringArray[i];
				String[] studentStringArray = studentString.split(", ");
				HashMap<String, String> student = new HashMap<>();
				student.put("number", studentStringArray[0]);
				student.put("name", studentStringArray[1]);
				student.put("kor", studentStringArray[2]);
				student.put("eng", studentStringArray[3]);
				student.put("math", studentStringArray[4]);
				data.add(student);
			}
			
			
		}
		
		String title = "성적관리프로그램 ver 0.2.2";
		String menu = "1.조회 2.입력 3.수정 4.삭제 0.저장 후 종료> ";
		
		Scanner scanner = new Scanner(System.in);
		String input = null;

		System.out.println(title);
		System.out.println("---------------------------------\n\n");
		
		while(true) {
			System.out.print(menu);
			input = scanner.nextLine();
			
			if("0".equals(input)) {
				if(!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				FileOutputStream fos = null;
				String tempData = "";
				for(int i = 0; i < data.size(); i++) {
					HashMap<String, String> student = data.get(i);
					String number = student.get("number");
					String name = student.get("name");
					String kor = student.get("kor");
					String eng = student.get("eng");
					String math = student.get("math");
					tempData += number + ", " + name +  ", " + kor +  ", " + eng +  ", " + math + "\n";
				}
				try {
					 fos = new FileOutputStream(file);
					 
					 byte[] byteData = tempData.getBytes();
//					 fos.write(byteData); 둘 중 무관
					 for(int i = 0; i < byteData.length; i++) {
						 fos.write((int)byteData[i]);
					 }
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if(fos != null) {
						try {
							fos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				break;
				
			} else if("1".equals(input)) {
				System.out.println("-------------------------------------------------------");
				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
				System.out.println("-------------------------------------------------------");
				for(int i = 0; i < data.size(); i++) {
					HashMap<String, String> student = new HashMap<>();
					student = data.get(i);
					int number = Integer.parseInt(student.get("number"));
					String name = student.get("name");
					int kor = Integer.parseInt(student.get("kor"));
					int eng = Integer.parseInt(student.get("eng"));
					int math = Integer.parseInt(student.get("math"));
					int total = kor + eng + math;
					double avg = (total * 100 / 3) / 100;
					System.out.println(number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + avg);
				}
				
			} else if("2".equals(input)) {
				HashMap<String, String> student = null;
				student = new HashMap<>();
				System.out.print("학번 > ");
				student.put("number", scanner.nextLine());
				System.out.print("이름 > ");
				student.put("name", scanner.nextLine());
				System.out.print("국어 > ");
				student.put("kor", scanner.nextLine());
				System.out.print("영어 > ");
				student.put("eng", scanner.nextLine());
				System.out.print("수학 > ");
				student.put("math", scanner.nextLine());
				data.add(student);
				
			} else if("3".equals(input)) {
				System.out.print("수정할 학번 > ");
				input = scanner.nextLine();
				for(int i = 0; i < data.size(); i++) {
					HashMap<String, String> student = data.get(i);
					if(input.equals(student.get("number"))) {
						student.put("number", input);
						System.out.print("이름 > ");
						student.put("name", scanner.nextLine());
						System.out.print("국어 > ");
						student.put("kor", scanner.nextLine());
						System.out.print("영어 > ");
						student.put("eng", scanner.nextLine());
						System.out.print("수학 > ");
						student.put("math", scanner.nextLine());
						data.set(i, student);
						break;
					}
				}
				
			} else if("4".equals(input)) {
				System.out.print("삭제할 학번 > ");
				input = scanner.nextLine();
				for(int i = 0; i < data.size(); i++) {
					HashMap<String, String> student = data.get(i);
					if(input.equals(student.get("number"))) {
						data.remove(i);
						break;
					}
				}
			} else {
				System.out.println("입력 오류");
				System.out.println("올바른 메뉴 번호를 입력하세요");
			}
		}
	}

}
