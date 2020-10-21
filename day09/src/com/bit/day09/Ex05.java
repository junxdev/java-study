package com.bit.day09;

public class Ex05 {
    
    public static void main(String[] args) {

        int a1 = 1;
        int a2 = 3;
        int a3 = 5;
        int a4 = 7;
        int a5 = 9;

        // 배열은 정적인 자료구조로 정해진 크기를 변경할 수 없다

        int[] a;
        a = new int[5];

        a[0] = 2;
        a[1] = 4;
        a[2] = 6;
        a[3] = 8;
        a[4] = 10;
        a[5] = 12;

        int[] b = new int[]{2, 4, 6, 8, 10};
        int[] c = {1, 2, 3, 4, 5}; // 프레임워크에서 문제 발생 가능하므로 권장하지 않는다.

        for(int i = 0; i < 5; i++ ) {
            System.out.print(a[i]);
        }
    }
}