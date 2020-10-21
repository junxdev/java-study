package com.bit.day09;

public class Ex06 {
    
    public static void main(String[] args) {
        // +2 출력
        int[] su1 = new int[] {1, 4, 6, 7, 9};

        for(int i = 0; i < su1.length; i++) {
            su1[i] += 2;
            System.out.print(su1[i]);
        }
        System.out.println("\n------------------------");

        // 오름차순
        int[] su2 = new int[] {17, 2, 64, 8, 13};

        int temp;

        for(int i = 0; i < su2.length - 1; i++) {
            for(int j = i + 1; j < su2.length; j++) {
                if(su2[i] > su2[j]) {
                    temp = su2[i];
                    su2[i] = su2[j];
                    su2[j] = temp;
                }
            }
        }
        for(int i = 0; i < su2.length; i++) {
            System.out.print(su2[i]);
        }
        System.out.println("\n------------------------");
        su2 = new int[] {52, 43, 26, 11, 9};
        for(int i = 0; i < su2.length -1; i++) {
            for(int j = i +1; j < su2.length; j++) {
                if (su2[i] > su2[j]) {
                    temp = su2[i];
                    su2[i] = su2[j];
                    su2[j] = temp;
                }
            }
        }

        for(int i = 0; i < su2.length; i++) {
            System.out.print(su2[i]);
        }
        System.out.println("\n------------------------");

        int[] su3 = new int[] {3, 15, 7};

        if(su3[0] < su3[1]) {
            if(su3[0] < su3[2]) {
                System.out.print(su3[0]);
                if(su3[1] < su3[2]) {
                    System.out.print(su3[1]);System.out.print(su3[2]);
                } else {
                    System.out.print(su3[2]);System.out.print(su3[1]);
                }
            } else { 
                System.out.print(su3[2]);System.out.print(su3[1]);System.out.print(su3[0]);
            }            
        } else if(su3[1] < su3[2]) {
            if(su3[1] < su3[0]) {
                System.out.print(su3[1]);
                if(su3[0] < su3[2]) {
                    System.out.print(su3[0]);System.out.print(su3[2]);
                } else {
                    System.out.print(su3[2]);System.out.print(su3[0]);
                }
            } else {
                System.out.print(su3[0]);System.out.print(su3[1]);System.out.print(su3[2]);
            }
        } else if(su3[2] < su3[0]) {
            if(su3[2] < su3[1]) {
                System.out.print(su3[2]);
                if(su3[0] < su3[1]) {
                    System.out.print(su3[0]);System.out.print(su3[1]);
                } else {
                    System.out.print(su3[1]);System.out.print(su3[0]);
                }
            } else {
                System.out.print(su3[1]);System.out.print(su3[2]);System.out.print(su3[0]);
            }
        }
        System.out.println("\n------------------------temp");


        if(su3[0] < su3[1] && su3[0] < su3[2]) {
            System.out.println(su3[0]);
            su3[0] = su3[0];
        } else if (su3[1] < su3[2] && su3[1] < su3[0]) {
            System.out.println(su3[1]);
            temp = su3[0];
            su3[0] = su3[1];
            su3[1] = temp;
        } else if (su3[2] < su3[0] && su3[2] < su3[1]) {
            System.out.println(su3[2]);
            temp = su3[0];
            su3[0] = su3[2];
            su3[2] = temp;
        }

        if(su3[1] < su3[2]) {
            System.out.println(su3[1]);
            System.out.println(su3[2]);
        } else if (su3[2] < su3[1]) {
            System.out.println(su3[2]);
            temp = su3[1];
            su3[1] = su3[2];
            su3[2] = temp;
            System.out.println(su3[2]);
        }
        System.out.println("------------------------");


        // 0 ~ 10 중 홀수 배열 출력
        int number = 13;
        int[] oddNumber;
        if(number % 2 == 0) {
            oddNumber = new int[number / 2];
        } else {
            oddNumber = new int[(number / 2) + 1];
        }
        for(int i = 0; i < number + 1; i++) {
            if(i % 2 == 1) {
                oddNumber[i / 2] = i;
            }
        }

        if(number % 2 == 0) {
            for(int i = 0; i < number / 2; i++) {
                System.out.print(oddNumber[i] + " ");
            }
        } else {
            
            for(int i = 0; i < (number / 2) + 1; i++) {
                System.out.print(oddNumber[i] + " ");
            }
        }
        System.out.println("\n------------------------");

        int index = 0;
        int[] su4 = new int[index];

        for(int i = 0; i < 11; i++) {
            if(i % 2 == 1) {
                index++;
                su4 = new int[index];
                su4[index - 1] = i;
            }
        }

        for(int i = 0; i < su4.length; i++) {
            System.out.print(su4[i]);
        }
        System.out.println("\n------------------------");


        // 알파벳 대문자 배열 출력
        char[] alphabet = new char['Z' - 'A' + 1];
        alphabet[0] = 'A';

        for(int i = 0; i < 'Z' - 'A' + 1; i++) {
            alphabet[i] = (char)('A' + i);
        }
        System.out.println(alphabet);


    }

}