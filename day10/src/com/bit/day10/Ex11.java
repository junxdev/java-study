package com.bit.day10;

class Lotto {
    private int[] numbers = new int[6];
    private String who;

    Lotto() {}
    
    Lotto(String name) {
        who = name;
    }

    void pick() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 45) + 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }
    }

    void sort() {
        for (int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    void print() {
        System.out.print(who + "의 번호 : ");
        for (int i = 0; i <numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}

public class Ex11 {

    public static void main(String[] args) {
        
        Lotto bot = new Lotto("컴퓨터");
        bot.pick();
        bot.sort();
        bot.print();

        Lotto user = new Lotto("사용자");
        user.pick();
        user.sort();
        user.print();

    }

    
}