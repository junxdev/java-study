package com.bit.day11;

public class Ex01Wrapper {

    public static void main(String[] args) {
        // 래퍼 클래스;Wrapper Class (박싱 & 언박싱;Boxing & Unboxing) (래핑 & 언래핑; Wrapping & Unwrapping)
        // 기본 자료형에 해당하는 클래스

        // int > Integer
        int su1;
        su1 = 100;
        Integer su2;
        su2 = new Integer(1000);
        su2++;
        System.out.println(su2);

        Integer su3 = new Integer("3000");
        System.out.println(su2+su3);  // 참조변수;해쉬코드 간의 연산인데 가능한 이유 : int로 언박싱 및 연산;결과는 int 자료형
        
        Integer su4 = 1234; // 오토박싱; Auto-boxing

        
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.BYTES);

        System.out.println(2147483648.0 > Integer.MAX_VALUE);

        Integer su5 = new Integer(32769);
        System.out.println(su5.byteValue());
        System.out.println(su5.shortValue());
        
        byte by = su5.byteValue();
        short sh = su5.shortValue();
        int su6 = su5.intValue();

        Integer su7 = new Integer(100);
        Integer su8 = new Integer(100);
        System.out.println(su7 == su8); // false : 객체 참조값끼리 비교
        System.out.println(su7 == 100); // true : 참조변수를 언래핑하여 int 자료값을 호출
        System.out.println(su7.equals(su8));

        String msg = "1234";
        Integer su9 = Integer.valueOf(msg);
        System.out.println(su9);
        int su10 = Integer.parseInt(msg);
        System.out.println(su10);

        int su11 = Integer.max(12, 9);
        int su12 = Integer.min(12, 9);
        System.out.println(su11);
        System.out.println(su12);

        int su13 = 1;
        int su14 = Integer.reverse(su13);
        System.out.println(su14);

        int su15 = 16;
        System.out.println(su15);
        System.out.println(Integer.toBinaryString(su15));
        System.out.println(Integer.toOctalString(su15));
        System.out.println(Integer.toHexString(su15));

        int su16 = 15;
        int su17 = 10;
        int su18 = Integer.compare(su16, su17);
        Integer su19 = 11;
        int su20 = su19.compareTo(su16);
        System.out.println(su18);
        System.out.println(su20);
        
        

        
        
    }
    
}