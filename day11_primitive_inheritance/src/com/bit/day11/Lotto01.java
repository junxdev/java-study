package com.bit.day11;

class Ball {
	
    final int number;
    Boolean pickedUp = false;

    Ball(int number) {
        this.number = number;
    }

    void showNumber() {
        System.out.print(number + " ");
    }


}

public class Lotto01 {

    public static void main(String[] args) {
        
        Ball[] ballBox = new Ball[45];

        for(int i = 0; i < ballBox.length; i++) {
            ballBox[i] = new Ball(i + 1);
        }

        // Ball temp = null;
        // for(int i = 0; i < 5000; i++) {
        //     int random = (int)(Math.random() * 45);
        //     temp = ballBox[0];
        //     ballBox[0] = ballBox[random];
        //     ballBox[random] = temp;
        // }


        // for(int i = 0; i < 5; i++) {
        //     for(int j = i + 1; j < 6; j++) {
        //         if(ballBox[i].number > ballBox[j].number) {
        //             temp = ballBox[i];
        //             ballBox[i] = ballBox[j];
        //             ballBox[j] = temp;
        //         }
        //     }
        // }

        // for(int i = 0; i < 6; i++) {
        //     ballBox[i].showNumber();
        // }

        int[] list = new int[6];

        for(int i = 0; i < 6; i++) {
            int random = (int)(Math.random() * 45);
            if (ballBox[random].pickedUp == true) {
                i--;
            } else {
                ballBox[random].showNumber();
                ballBox[random].pickedUp = true;
                list[i] = ballBox[random].number;
            }
        }

    }
    
}