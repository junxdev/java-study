package com.bit.day11;
class Lec01 {
    int su = 1234;
    void func01() {
        su++;
        System.out.println("Lec01 func01");
    }
}
class Lec11 extends Lec01 {

    int su = 4321;
    // void func01() {
    //     su++;
    //     System.out.println("Lec11 func01");
    // }
    void func02() {
        System.out.println(super.su);
    }
    
    void func01() {
    	su++;
    	System.out.println("Lec11 func01");
    }
}
public class Ex11Override {

    void func01() {};
    
    public static void main(String[] args) {
        Lec11 me = new Lec11();
        me.func01();
        System.out.println(me.su); // 4321 출력
        me.func02(); // 1234 출력
        
        Lec01 you = new Lec11();
        you.func01(); // Lec11 func01 출력: 메소드 오버라이드
        System.out.println(you.su); // 1234 출력 : 필드는 오버라이드 되지 않는다
        // you.func02();
    }

}