package com.bit.day11;

public class Ex05Character {
    
    public static void main(String[] args) {
        char ch1 = 'A';
        Character ch2 = new Character('B');
        ch2 = new Character(ch1);
        System.out.println(Character.BYTES);
        System.out.println(Character.SIZE);
        System.out.println((int)Character.MIN_VALUE);
        System.out.println((int)(Character.MAX_VALUE));

        
        System.out.println(Character.isLetter(ch1));
        System.out.println(Character.isDigit(ch1));
        System.out.println(Character.isUpperCase(ch1));
        System.out.println(Character.isLowerCase(99));
        
        // 띄어쓰기
        System.out.println(!Character.isSpace(ch1));
        System.out.println(Character.isWhitespace(ch1));

        System.out.printf("5: %10d", 10);
    }
}