package com.bit.day11;

public class Ex03FloatDouble {
    
    public static void main(String[] args) {
        Float su1;
        Double su2;

        su2 = new Double("3.14");
        System.out.println(su2);

        Double su3 = new Double(3.14);
        System.out.println(su3);

        double su4 = Double.parseDouble("3.14");
        System.out.println(su4);

        // int su5 = Integer.parseInt("3.14");
        
        Double su6 = Double.valueOf(3.14);
        
        double su7 = su6.doubleValue();
        int su8 = su6.intValue();
        System.out.println(su7);
        System.out.println(su8);
        
        Double su9 = 2/0.0;
        Double su10 = 0.0/0.0;
        System.out.println(su9.isInfinite());
        System.out.println(su10.isNaN());


    }
}