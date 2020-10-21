package com.bit.day08; 
 
import java.io.IOException;

class Test {
    
    public static void main(String[] args) throws IOException {
        
        java.io.BufferedReader br = 
            new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
       
        int number_case = Integer.parseInt(br.readLine());

        java.util.StringTokenizer st ;

        for (int i = 0; i < number_case; i++) {
            st = new java.util.StringTokenizer(br.readLine());
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            
            System.out.println(number1 + number2);
            
        }     
    }
}
