package com.bit.day11;
class Lec15 {
    public void func01() {
        System.out.println("Lec15 func01");
    }
}
public class Ex15Polymorphism extends Lec15 {

    public void func01() {
        System.out.println("Ex15 func01");
    }
    public void func02() {
        System.out.println("Ex15 func02"); 
    }   
    public static void main(String[] args) {
        // 다형성
        Lec15 me = new Ex15Polymorphism();
        me.func01(); // Ex15 func01
        // me.func02(); Lec15에 func02가 없으므로 오류
        Ex15Polymorphism you = (Ex15Polymorphism)me;
        you.func02(); // Ex15 func02

        Lec15 me2 = you;
        me2.func01();  // Ex15 func01
        // me2.func02(); Lec15에 func02가 없으므로 오류


        Number su1 = new Integer(1234);
        Number su2 = new Double(1234);

        Number su = 1234;
        System.out.println(su);
        
        System.out.println(su1.intValue() + su2.doubleValue());

        func03(3); // Wrapper Class와 다형성에 의해 작동
        func04("sss"); // Wrapper Class와 다형성에 의해 작동
        

    }
    public static void func03(Number a) {
        System.out.println(a);
    }
    public static void func04(Object a) {
        System.out.println(a);
    }
    
}