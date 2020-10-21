package com.bit.day08; 

class Car {

	String model = "";
	int accel = 10;
	int speed = 0;

	public void speedUp() {
		speed += accel;
	}

	public void speedDown() {
		speed -= accel;
	}
}
 
class Ex08 { 
 
	public static void main(String[] args) { 
		
		Car myCar = new Car();
		myCar.model = "모닝"; 
		
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다");
		myCar.speedUp();
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다"); 
		myCar.speedUp();
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다"); 
		myCar.speedDown();
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다"); 
		myCar.speedUp();
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다"); 
		myCar.speedDown();
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다"); 
		myCar.speedUp();

		myCar = new Car();
		myCar.model ="K3";
		myCar.accel = 15;
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다");
		myCar.speedUp();
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다"); 
		myCar.speedUp(); 
		myCar.speedUp(); 
		myCar.speedUp(); 
		myCar.speedUp();
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다"); 
		myCar.speedDown();
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다"); 
		myCar.speedDown();
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다"); 
		myCar.speedDown();
		System.out.println("내 " + myCar.model + "의 속도는 " + myCar.speed + "입니다"); 		
 
	} // main end 
 
} // class end 
