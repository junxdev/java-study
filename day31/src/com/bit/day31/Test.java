package com.bit.day31;
interface Testable {
	void createInter();
	void updateInter();
	void deleteInter();
}

abstract class SupterTest implements Testable{
	void normal() {
		System.out.println("abstract class normal");
	}
	abstract void create();
	abstract void update();
	abstract void delete();
}
public class Test extends SupterTest implements Testable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createInter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInter() {
		// TODO Auto-generated method stub
		
	}

}
