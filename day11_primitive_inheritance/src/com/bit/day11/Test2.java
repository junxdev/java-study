package com.bit.day11;
class Get {
    
    private int x;
    int y;

    private void change1(int number) {
        x = number;
    }

    void change2(int number) {
        x = number;
    }

    void show() {
        System.out.println(x);
    }

    void superChange(int number) {
        change1(number);
    }

    Get (int number) {
        x = number;
    }
    Get (int number, int number2) {
        x = number;
        y = number2;
    }
}
public class Test2 {

    public static void main(String[] args) {

        Get a = new Get(5, 45253562);
        a.show();
        a.superChange(1111);
        a.show();
        a.change2(111);
        a.show();
        System.out.println(a.y);
    }
    
}