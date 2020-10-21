package com.bit.day10;

public class Ex06 {
    
    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 3, 5, 7, 9};
        int[] arr3 = arr2; // 배열의 옅은 복사 : 두 배열이 하나의 데이터를 가리키고 있다.

        arr3[2] = 10; // 따라서 한 배열에서 수정 시 데이터를 수정하므로 다른 배열에서 출력해도 변한 값을 출력한다.
        System.out.println(arr1.toString());
        System.out.println(arr1 == arr2);
        System.out.println(arr3 == arr2);

        func01(arr3);
        for(int i = 0; i < arr3.length; i++) {
            System.out.println(arr2[i]); // {1, 3, 10, 7, 9}
        }
    }

    public static void func01(int[] su) { // 배열의 옅은 복사와 동일한 효과
        su[3] = 1234;
    }
}