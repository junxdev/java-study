package com.bit.day09;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();
        
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());

            bw.write((number1 + number2) + "\n");
        }

        bw.flush();
        long end = System.currentTimeMillis();
        System.out.println((end - start) * 0.0001 + "초");
        bw.close();



    }
    
}