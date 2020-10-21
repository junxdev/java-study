package com.bit.day11;
class Lec13 {
    public static void func01() {
        System.out.println("Lec func01");
    }
    private void func02() {
        System.out.println("private func02");
    }
}
public final class Ex13Final extends Ex11Override { // final : 더 이상 상속할 수 없음
    
    public void func01() {
        super.func01();
        System.out.println("Ex13 func01");
    }
    
    void func02() {
    	func01();
    }

    public static void main(String[] args) {
        Ex13Final me = new Ex13Final();
        me.func01();

        Lec13 you = new Lec13();

        me.func02();
        
//        you.func01();
//        you.func02(); // private
    }
}