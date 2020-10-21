package com.bit.day08;

class Car {

	String model = "";
	int accel = 10;
	int speed = 0;
	int limit = 150;

	public void speedUp() {
		speed += accel;
		if (speed > limit) {
			speed = limit;
		}
	}

	public void speedDown() {
		speed -= accel + 5;
		if (speed < 0) {
			speed = 0;
		}
	}
}
 

class Ex09 { 

    	public static void main(String[] args) {

		Car myCar = null;
		String menu = "1.차량 변경 2.가속 3.감속 0.종료 >> ";
		java.util.Scanner sc = null;
		sc = new java.util.Scanner(System.in);
		int input = 0;

		while(true) {
			System.out.print(menu);
			input = sc.nextInt();
			if (input == 0) {break;}
			else if (input == 1) {
				System.out.println("차량을 선택하세요");
				System.out.print("1.모닝 2.K3 3.셀토스 >> ");
				input = sc.nextInt();
				if (input == 1) {
					myCar = new Car();
					myCar.model = "모닝";
					myCar.accel = 10;
					myCar.limit = 150;
				} else if (input == 2) {
					myCar = new Car();
					myCar.model = "K3";
					myCar.accel = 14;
					myCar.limit = 180;
				} else if (input == 3) {
					myCar = new Car();
					myCar.model = "셀토스";
					myCar.accel = 18;
					myCar.limit = 200;
				}
			} else if (myCar != null && input == 2) {
				myCar.speedUp();
			} else if (myCar != null && input == 3) {
				myCar.speedDown();
			}
			if (myCar != null) {
				System.out.println(myCar.model + " 현재 속도는 " + myCar.speed + "Km입니다");
			}
		}
 
	} // main end 
 
} // class end 
