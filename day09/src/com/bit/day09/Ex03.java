package com.bit.day09;

public class Ex03 {

    // 기본 생성자는 접근제한자가 public
    final static int su2 = 333;
    final int su = 3;
    Ex03() {
        // 객체는 생성됨
        // 객체 생성시점에 하고 싶은 작업 수행
        // 해당 생성자의 호출: 객체 생성 시 단 한번만 이루어짐

        // 필드의 초기화 : 변수 대입이 아니다!
    }

    public static void main(String[] args) {
        // 상수형 변수 : 변수명을 대문자로 작성
        final int A;
        A = 1111; // 변수의 초기화
        // a = 2222; // 변수 대입

        final int B = 9999;
        // b = 9999;

        final double PI = 3.14;
        
        Ex03 me = new Ex03();
        System.out.println(me.su);

//        Ex03 me = new Ex03(5);
//        Ex03 you = new Ex03(6);

//        System.out.println(me.su);
//       System.out.println(you.su);
    }
    
}