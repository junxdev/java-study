package com.bit.day11;

class Father { // extends Object 생략
    int money = 1000;

    void work() {
        money += 100;
        System.out.println("Father works");
    }
    void push() {
        money -= 10;
    }
}

class Son extends Father {
    int money = 0;

    // 메서드 오버라이드
    void work() {
        money += 10;
        System.out.println("Son works");
    }

}

public class Ex10Override { // extends Object 생략
    
    public static void main(String[] args) {

        Father fa = new Father();
        System.out.println(fa.money);
        fa.work();fa.work();fa.work();fa.work();
        fa.push();
        System.out.println(fa.money);

        Son son = new Son();
        System.out.println(son.money);
        son.work();
        System.out.println(son.money);

        Object obj = new Object();
        System.out.println(obj.toString());
        System.out.println(obj.hashCode());
        Ex10Override me = new Ex10Override();
        System.out.println(me.toString()); //object > Ex10 오버라이딩
        System.out.println(me.hashCode());
        Object you = new Ex10Override();
        System.out.println(you.toString());
        
    }

    public String toString() { //object > Ex10 오버라이딩
        return "poli";
    }
}