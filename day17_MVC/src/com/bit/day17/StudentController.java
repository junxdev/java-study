package com.bit.day17;
// ��Ʈ�ѷ��� UI�� VO�� ���� �����ؼ� ����
// �Ǵ� UI���� �Է��� ���� VO�� ��� �����ͺ��̽��� ����
// ������ DB�� ��� ��� �޼ҵ常 ����
public class StudentController {
	// �����ڸ� Ȱ���� DI
	// ����� DB�� list�� �����Ƿ� �ʵ�� ����
	// ������ Ȱ���� ���� ArrayList�� �ƴ� List
	
	java.util.List<StudentVO> list;
	public StudentController(java.util.List<StudentVO> list) {
		// ��Ʈ�ѷ� Ŭ������ list�� ������
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
