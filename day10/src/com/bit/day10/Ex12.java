package com.bit.day10;

public class Ex12 {

    public static void main(String[] args) {
        int[] ball = new int[45];

        for(int i = 0; i < 45; i++) {
            ball[i] = i + 1;
        }

        int temp;
        for(int i = 0; i < 1000; i++) {
            int random = (int)(Math.random()*45);
            temp = ball[0];
            ball[0] = ball[random];
            ball[random] = temp;
        }

        for (int i = 0; i < 5; i++) {
            for(int j = i + 1; j < 6; j++) {
                if(ball[i] > ball[j]) {
                    temp = ball[i];
                    ball[i] = ball[j];
                    ball[j] = temp;
                }
            }
        }

        String print = "로또 번호 : ";
        for(int i = 0; i < 6; i++) {
            print += ball[i] + " ";
        }
        print += "보너스 번호 : " + ball[6];
        
        System.out.println(print);


    }
    
}