package com.bit.day11;
class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    public void foo(Dog someDog) {  // AAA
        someDog.setName("Max");     // BBB
        System.out.println("before new Dog() in foo() : " + someDog);
        someDog = new Dog("Fifi");  // CCC
        someDog.setName("Rowlf");   // DDD
        System.out.println("after new Dog() in foo() : " + someDog);
    }

    void showName() {
        System.out.println(name);
    }
}
public class Test1 {

    public static void main(String[] args) {
        
        Dog mydog;
        mydog = new Dog("Rover");

        System.out.println("before foo() : " + mydog);
        mydog.foo(mydog);
        // mydog = new Dog("Fifi");
        // mydog.setName("Rowlf");

        mydog.showName();
        System.out.println("after foo() : " + mydog);


    }
    
}