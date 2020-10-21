package com.bit.day11;
class Lec12 {

    Lec12(int a) {
        System.out.println("Lec12");
    }
    void func01() {
        System.out.println("Lec12 func01");
    }
}
public class Ex12OverrideSuper extends Lec12 {

    Ex12OverrideSuper() {
        this(111);
        System.out.println("Ex12");
    }

    Ex12OverrideSuper(int a) {
        super(a);
    }

    Ex12OverrideSuper(String a) {
        // super(122); : 하나의 피상속자 객체에서 상속자를 2번 호출할 수 없다
        this();
    }

    public static void main(String[] args) {
        Ex12OverrideSuper me = new Ex12OverrideSuper();
        me.func01();
    }    
}