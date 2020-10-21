package com.bit.day10;

public class Ex07 {
    
    public static void main(String[] args) {
        int[] arr; // 배열 선언
        arr = new int[5]; // 배열 초기화
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int[] arr1 = new int[] {2, 4, 6, 8};

        int[] arr2 = new int[arr1.length]; // 배열의 깊은 복사 : value만 복사

        for(int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }

        for(int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}