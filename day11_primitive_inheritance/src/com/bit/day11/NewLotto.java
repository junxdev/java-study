package com.bit.day11;

public class NewLotto {

    public static void main(String[] args) {
        
        int[][] balls = new int[45][2];

        for(int i = 0; i < 45; i++) {
            balls[i][0] = i + 1;
        }

        for(int i = 0; i < 45; i++) {
            System.out.print(balls[i][0] + " ");
        }
        System.out.println("\n-----------");

        // int[] temp = null;
        // for(int i = 0; i < 5000; i++) {
        //     int random = (int)(Math.random() * 45);
        //     temp = balls[0];
        //     balls[0] = balls[random];
        //     balls[random] = temp;
        // }


        // for(int i = 0; i < 5; i++) {
        //     for(int j = i + 1; j < 6; j++) {
        //         if(balls[i][0] > balls[j][0]) {
        //             temp = balls[i];
        //             balls[i] = balls[j];
        //             balls[j] = temp;
        //         }
        //     }
        // }

        // for(int i = 0; i < 45; i++) {
        //     System.out.print(balls[i][0] + " ");
        // }

        for(int i = 0; i < 6; i++) {
            int random = (int)(Math.random() * 45);
            if(balls[random][1] == 1) {
                i--;
            } else {
                balls[random][1] = 1;
                System.out.print(balls[random][0] + " ");
            }
        }
        
    }
}