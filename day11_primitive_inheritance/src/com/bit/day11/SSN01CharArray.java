package com.bit.day11;

public class SSN01CharArray {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        boolean count = true;
        boolean digitCheck;


        while(count) {
            System.out.print("주민번호입력 : ");
            String ssn = sc.nextLine();
            char[] char_ssn = ssn.toCharArray();

            if (char_ssn.length != 14) {
            	if (char_ssn.length > 6 && char_ssn[6] != '-') {
                    System.out.println(">> 입력패턴을 다시 확인하세요(000000-0000000)");
            	} else {
            		System.out.println(">> 주민번호 자리 수를 다시 확인하세요");
            	}
            } else if (char_ssn[6] != '-') {
                System.out.println(">> 입력패턴을 다시 확인하세요(000000-0000000)");
            } else {
            	
	            int sex = char_ssn[7] - '0';
	
	            String birth_temp = "";
	            birth_temp += (char_ssn[0] - '0');
	            birth_temp += (char_ssn[1] - '0');
	            int birth = Integer.parseInt(birth_temp);
	
	            int age;
	            if (sex < 3) {
	                age = 120 - birth + 1;
	            } else {
	                age = 20 - birth + 1;
	            }
	
	            if (sex % 2 == 1) {
	                System.out.println(">> 당신은 " + age + "세 남자입니다");
	            } else {
	                System.out.println(">> 당신은 " + age + "세 여자입니다");
	            }
	            count = false;
                }
            }
            
            
        }
        
    }
    