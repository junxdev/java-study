package com.bit.day11;

import com.bit.day10.Ex20;

public class Ex14Access extends com.bit.day10.Ex20 {
    // public > protected >= default > private
    // protected
    // default와 일반적으로 동일
    // 단, 다른 패키지라도 상속을 통한 접근 허용
    public static void main(String[] args) {
        Ex14Access me = new Ex14Access();
        me.func01();

    }
    
}