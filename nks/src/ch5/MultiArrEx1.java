package ch5;

import java.util.*;

public class MultiArrEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] myBoard = new int[10][10];
		int myRow, myCol;
		System.out.print("�踦 ��� ��ġ�Ͻðڽ��ϱ�? \n�� > ");
		myRow = Integer.parseInt(sc.nextLine());
		System.out.print("\n�� > ");
		myCol = Integer.parseInt(sc.nextLine());
		myBoard[myRow][myCol] = 1; 
		
		int[][] botBoard = new int[10][10];
	}

}
