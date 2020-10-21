package com.bit.day09;

class Car {
    private String model; // Ex04 Class에서 접근할 수 없으므로 Car(String, int, int) 객체 생성 패턴을 유지한다
    private int limit; // = 캡슐화, 정보의 은닉
    private int speed;
    private int accel;

    Car() { // 생성자 overload
        model = "승용차";
        limit = 150;
        accel = 10;
    }

    Car(String name, int a, int b) {
        model = name;
        limit = a;
        accel = b;
    }

    void speedUp() {
        if((speed += accel) > limit) {
            speed = limit;
        }
    }
    void speedDown() {
        if((speed -= accel) < 0) {
            speed = 0;
        }
    }
    void show() {
        System.out.println(model + "의 현재 속도는 " + speed + "km/h입니다");
    }
}

public class Ex04 {

    public static void main(String[] args) {

        Car car = new Car("모닝", 130, 10);
        car.show();
        for(int i = 0; i < 25; i++) {
            car.speedUp();
            car.show();
        }
        for(int i = 0; i < 25; i++) {
            car.speedDown();
            car.show();
        }

        car = new Car("셀토스", 180, 14);
        car.show();
        for(int i = 0; i < 25; i++) {
            car.speedUp();
            car.show();
        }
        for(int i = 0; i < 25; i++) {
            car.speedDown();
            car.show();
        }

        car = new Car();
        car.show();
        for(int i = 0; i < 25; i++) {
            car.speedUp();
            car.show();
        }
        for(int i = 0; i < 25; i++) {
            car.speedDown();
            car.show();
        }

    }
    
}