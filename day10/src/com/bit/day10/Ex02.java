package com.bit.day10;

public class Ex02 {

    int su;

    public Ex02() {                                      // 작업 전 객체가 생성되어야 하기 때문에 첫째줄에 선언
        this(1234);                              
        System.out.println("해쉬값 : " + this);          // 클래스 객체 해쉬값 출력
    }

    public Ex02(int su) {
        super();                                        // 작업 전 객체가 생성되어야 하기 때문에 첫째줄에 선언
        this.su = su;
        System.out.println("해쉬값 : " + this);
    }

    public void func01(Ex02 variable) {
        System.out.println(" " + variable + " 해쉬값 : " + this);
    }
    public static void main(String[] args) {
        Ex02 me = new Ex02();
        System.out.println("su = " + me.su);
        
    }
    
}