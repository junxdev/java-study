package com.bit.day00; 

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
    
class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
       
        int testCase = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < testCase; i++) {  
		StringTokenizer st = new StringTokenizer(br.readLine());

		int number1 = Integer.parseInt(st.nextToken());
		int number2 = Integer.parseInt(st.nextToken());
            
		System.out.println(number1 + number2);
        }
    }
}