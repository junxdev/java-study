package com.bit.day10;

public class Answer {
    
    public static void main(String[] args) {

        int[] numbers = new int[7];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 45) + 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }


        for (int i = 0; i < numbers.length - 2; i++) {
            for(int j = i + 1; j < numbers.length - 1; j++) {
                if(numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.print("이번주 로또 번호 : ");
        for (int i = 0; i <numbers.length - 1; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.print("보너스 번호 : " + numbers[numbers.length - 1]);
        System.out.println();
    }
}