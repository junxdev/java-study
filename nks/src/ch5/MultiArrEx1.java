package ch5;

import java.util.*;

public class MultiArrEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] myBoard = new int[10][10];
		int myRow, myCol;
		System.out.print("배를 어디에 위치하시겠습니까? \n행 > ");
		myRow = Integer.parseInt(sc.nextLine());
		System.out.print("\n열 > ");
		myCol = Integer.parseInt(sc.nextLine());
		myBoard[myRow][myCol] = 1; 
		
		int[][] botBoard = new int[10][10];
	}

}
