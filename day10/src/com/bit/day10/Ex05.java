package com.bit.day10;

public class Ex05 {
    public static void main(String[] args) {
        String msg1 = "java";
        String msg2 = " Framework";
        String msg3 = msg1 + msg2;
        System.out.println(msg3);

        String msg4 = msg1.concat(msg2);
        System.out.println(msg4);
        System.out.println("--------------------------------");

        String msg7 = "ABCD EFG";
        System.out.print(msg7.charAt(0));
        System.out.print(msg7.charAt(2));
        System.out.print(msg7.charAt(4));
        System.out.println(msg7.charAt(7));
        System.out.println("--------------------------------");

        System.out.println(msg7.length());

        for(int i = 0; i < msg7.length(); i++) {
            System.out.print(msg7.charAt(i));            
        }
        System.out.println("--------------------------------");

        char[] ch1 = {'a', 'b', 'c', 'd'};
        String msg8 = new String(ch1);

        char[] ch2 = msg8.toCharArray();
        for(int i = 0; i < ch1.length; i++) {
            System.out.print(ch2[i]);
        }

    }
}