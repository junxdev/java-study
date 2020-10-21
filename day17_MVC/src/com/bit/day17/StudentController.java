package com.bit.day17;
// 컨트롤러는 UI에 VO의 값을 정제해서 전송
// 또는 UI에서 입력한 값을 VO에 담아 데이터베이스에 전송
// 지금은 DB가 없어서 계산 메소드만 구현
public class StudentController {
	// 생성자를 활용한 DI
	// 현재는 DB에 list가 없으므로 필드로 생성
	// 다형성 활용을 위해 ArrayList가 아닌 List
	
	java.util.List<StudentVO> list;
	public StudentController(java.util.List<StudentVO> list) {
		// 컨트롤러 클래스는 list에 의존적
		this.list = list;
	}
	public int calSum(StudentVO s) {
		return s.getKor() + s.getEng()+ s.getMath();
	}
	
	public double calAvr(StudentVO s) {
		return calSum(s) / 3.0;
	}
	
	public StudentVO findById(StudentVO s) {
		StudentVO result = null;
		if(list.indexOf(s) != -1) {
			int index = list.indexOf(s);
			result = list.get(index);
		}
		return result;
		
	}
	
	public void add(StudentVO s) {
		if(list.size() == 0) {
			s.setId(0);
		} else {
			int id = list.get(list.size() - 1).getId() + 1;
			s.setId(id);
		}
		list.add(s);
	}
	
	public void set(StudentVO s) {
		int index = list.indexOf(s);
		list.set(index, s);
	}
	
	public void remove(StudentVO s) {
		list.remove(s);
	}
}
