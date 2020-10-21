package com.bit.day09;

public class Ex07 {

    public static void main(String[] args) {
        // 1~6 랜덤 배열
        // 중복 없음
        int[] su = new int[6];

        for(int i = 0; i < su.length; i++) {
            su[i] = (int)(Math.random() * 6.0) + 1;
            for(int j = 0; j < i; j++) {
                if(su[j] == su[i]) {
                    i--;
                }
            }
        }

        for(int i = 0; i < su.length; i++) {
            System.out.println(su[i]);
        }

    }
    
}