package com.bit.day12;

public class Ex05SerialExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� ó���� ��ӱ����� ����Ͽ� �ۼ�: �ǻ�� > �ǻ�� ... > ���
		// �켱 ������ �߻����� ������ �ش��ϴ� Exception�� Ȱ��
		String msg = "5a";
		try {
			int[] arr = {1, 2, 3, 4, 5};
			int su = Integer.parseInt(msg); 			// String �� ���ڷ� ����
			System.out.println(arr[su]); 				// 5 �̻� ���ڷ� ����
//		} catch (Exception e) { 						// ��� ������ ��Ƴ��Ƿ�
//		} catch (NumberFormatException e) {				// ����� �� ���� ���		
//		} catch (ArrayIndexOutOfBoundsException e) {	// ����� �� ���� ���
		} catch (ArrayIndexOutOfBoundsException e) {
		} catch (NumberFormatException e) {
		} catch (Exception e) {
		}
	}

}
