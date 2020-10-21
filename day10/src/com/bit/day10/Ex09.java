package com.bit.day10;

public class Ex09 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2};
        int[] arr2 = new int[]{3, 4, 7};
        int[] arr3 = new int[]{5, 6, 8, 9, 10};

        int[][] arr4 = new int[][]{arr1, arr2, arr3, null};
        System.out.println(arr4.length);
        System.out.println("-----------------------");

/*        arr4[0][0] = 1;
        arr4[0][1] = 2;
        arr4[1][0] = 3;
        arr4[1][1] = 4;
        arr4[2][0] = 5;
        arr4[2][1] = 6;
*/
        int[][] arr5 = new int[3][]; // : int[][] arr5 = new int[][]{null, null, null};
        System.out.println(arr5[0]);
        System.out.println(arr5[1]);
        System.out.println(arr5[2]);
        System.out.println("-----------------------");
        
        for(int i = 0; i < arr4.length; i++) {
            int[] temp = arr4[i];
            if (arr4[i] == null) {continue;}
            for(int j = 0; j < temp.length; j++) {
                System.out.println(temp[j]);
            }
        }
        System.out.println("-----------------------");

        for(int i = 0; i < arr4.length; i++) {
            if (arr4[i] == null) {continue;}
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.println(arr4[i][j]);
            }
        }
    }
}