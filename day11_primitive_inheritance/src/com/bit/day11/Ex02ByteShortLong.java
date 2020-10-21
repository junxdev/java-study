package com.bit.day11;

public class Ex02ByteShortLong {
    public static void main(String[] args) {
        byte su11 = 10;
        Byte su1 = new Byte(su11);
        su1 = new Byte("123");
        System.out.println(su1);
        
        short su22 = 10;
        Short su2 = new Short(su22);

        long su33 = 10L;
        Long su3 = new Long(su33);
        su3 = new Long(10); // int 10이 long으로 자동변환
        su3 = new Long(10L);

    }
}