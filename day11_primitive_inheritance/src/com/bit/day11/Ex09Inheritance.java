package com.bit.day11;

class Lec09{
    int su = 1234;

    void func01() {
        System.out.println("Lec09 func01");
    }
}

public class Ex09Inheritance extends Lec09 {

    public static void main(String[] args) {
        //Lec09 you;
        //you = new Lec09();
        //you.func01();

        Ex09Inheritance me = new Ex09Inheritance();
        me.func01();


    }
    
}