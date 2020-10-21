package com.bit.day10;

public class Ex04 {
    
    static String msg2;

    public static void main(String[] args) {

        String msg1 = "문자열";

        String msg3;
        msg3 = "";

        String msg4;
        msg4 = new String();

        char[] ch = {'문', '자', '열'};
        String msg5;
        msg5 = new String(ch);

        String msg6;
        msg6 = new String("문자열");

        String msg7 = "문자열";

        String msg8 = "문자";

        String msg9 = msg8 + "열"; // 런타임 시 연산

        String msg10 = "문자" + "열"; // 성능 향상을 위해 컴파일 과정에서 연산 후 "문자열"로 String에 저장

        System.out.println(msg1 == msg7); // true

        System.out.println(msg6 == msg7); // false

        System.out.println(msg7 == msg9); // false
        
        System.out.println(msg7 == msg10); // true

        byte[] by = {65, 66, 67, 68};
        String msg11 = new String(by);
        System.out.println(msg11);

        byte[] by2 = new byte[128];
        for(int i = 0; i < by2.length; i++) {
            by2[i] = (byte)i;
        }

        String msg12 = new String(by2);
        System.out.println(msg12);

        System.out.println(msg4);
        System.out.println(msg5);
        System.out.println(msg6);
        System.out.println(msg2);   // String 객체의 

    }

}