package com.bit.day11;
final class Test {

    private final int value;

    public Test(int value) {
        this.value = value; // instance를 생성하는 순간이기에 작동
//        this.value++; // 아래와 같은 이유로 작동 불가
    }
    
    public void increment() {
//        value++; // 인스턴스가 생성되는 순간 final이므로 작동되지 않음
    }

    public void print() {
        System.out.printf("value = %d%n", value);
    }

    public void plus() {
    }
}
public class Test0 {

    public static void main(String[] args) {
        Test me = new Test(100);
        me.print();
        System.out.println(me);
        //me.value++;
        //System.out.println(me);

        Integer i = new Integer(100);
        System.out.println(Integer.hashCode(i));
        i++;
        System.out.println(Integer.hashCode(i));

        Integer su = new Integer(1000);
        System.out.printf(su.toString());

        

        
    }
    
}