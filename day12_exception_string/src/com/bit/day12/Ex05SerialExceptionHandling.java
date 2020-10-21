package com.bit.day12;

public class Ex05SerialExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 예외 처리는 상속구조를 고려하여 작성: 피상속 > 피상속 ... > 상속
		// 우선 오류를 발생시켜 오류에 해당하는 Exception을 활용
		String msg = "5a";
		try {
			int[] arr = {1, 2, 3, 4, 5};
			int su = Integer.parseInt(msg); 			// String 내 문자로 오류
			System.out.println(arr[su]); 				// 5 이상 숫자로 오류
//		} catch (Exception e) { 						// 모든 오류를 잡아내므로
//		} catch (NumberFormatException e) {				// 수행될 수 없는 명령		
//		} catch (ArrayIndexOutOfBoundsException e) {	// 수행될 수 없는 명령
		} catch (ArrayIndexOutOfBoundsException e) {
		} catch (NumberFormatException e) {
		} catch (Exception e) {
		}
	}

}
