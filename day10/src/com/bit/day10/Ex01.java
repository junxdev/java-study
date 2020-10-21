package com.bit.day10;

public class Ex01 {

    int su1 = 1234;

    Ex01 () {
        return;
    }

    Ex01 (int su1) {
        this.su1 = su1;                             // 멤버 필드 = 지역 매개변수 대입
    }

    public void func01() {
        int su1 = 999;
        System.out.println("func01 run");
        this.func02();
        System.out.println("su1 = " + su1);         // 지역변수 999 출력
        System.out.println("su1 = " + this.su1);    // 멤버 필드 1234 출력
    }

    public void func01(Ex01 ex) {                   // 원칙대로 작성한 코드
        System.out.println("func01(parameter : me) run");
        System.out.println(ex == this);             // this : 객체 자신의 주소값
        System.out.println("su1 = " + ex.su1);
        ex.func02();
    }

    public void func02() {
        System.out.println("func02 run");
    }

    public Ex01 func03(Ex01 me) {                   // 참조변수 me 리턴을 위한 메서드
        System.out.println("func03 run");
        return me;
    }

    public Ex01 func04() {                          // 클래스 객체의 this 리턴
        System.out.println("func04 run");
        return this;
    }

    public static void main(String[] args) {        // 1. 메인 메서드 스태틱 저장 2. 메인 메서드 스택 호출

        Ex01 me = new Ex01();                       // 3. 클래스 객체 생성 4. 객체 주소 부여
        me.func01();                                // 5. func01 메서드 호출
        me.func03(me).func03(me).func03(me);        
        me.func04().func04().func04();
//      System.out.println(this);                   static은 객체를 생성하지 않기 때문에 this 사용 불가

    }
}