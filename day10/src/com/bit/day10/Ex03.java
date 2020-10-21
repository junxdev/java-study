package com.bit.day10;

class Car {

    private String model;
    private int speed;
    private int accel;
    private int limit;

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

    public Car() {
        this("승용차", 10, 150);
/*      model = "승용차";       같은 코드를 위 1줄로 표현
        accel = 10;
        limit = 150;
*/  }
    
    public Car(String model, int accel, int limit) {
        this.model = model;
        this.accel = accel;
        this.limit = limit;
    }
}

public class Ex03 {
    public static void main(String[] args) {
        Car car = new Car("모닝", 15, 120);
        
        for(int i = 0; i < 15; i++) {
            car.speedUp();
            car.show();
        }

        for(int i = 0; i < 15; i++) {
            car.speedDown();
            car.show();
        }

        System.out.println("객체 해쉬값 : " + car);

        car = new Car("k5", 21, 210);

        for(int i = 0; i < 15; i++) {
            car.speedUp();
            car.show();
        }

        for(int i = 0; i < 15; i++) {
            car.speedDown();
            car.show();
        }

        System.out.println("객체 해쉬값 : " + car);

    }
}