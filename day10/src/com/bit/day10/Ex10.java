package com.bit.day10;

// 0. 1~45 중복 없는 6개의 임의 숫자 생성
// 1. 수동 또는 자동
// 2-a. 수동 시 6개 번호 선택
// 2-b. 자동 시 6개 번호 자동 선택
// 3. 숫자 오름차순 정렬 출력
// 4. 보너스번호

// 1. 어제 배운 정렬, 비교 활용
// 2. 객체 활용
// 3. ??

public class Ex10 {
    public static void main(String[] args) {
        int[] numbers = new int[6];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 45) + 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }

        int bonus_number = (int)(Math.random() * 45) + 1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == bonus_number) {
                bonus_number = (int)(Math.random() * 45) + 1;
                i--;
            }
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.print("이번주 로또 번호 : ");
        for (int i = 0; i <numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.print("보너스 번호 : " + bonus_number);
        System.out.println();

        java.util.Scanner sc = new java.util.Scanner(System.in);

        int[] user_numbers = new int[6];

        System.out.print("1.수동 2.자동 0.취소 >>> ");
        int user = sc.nextInt();

        if(user == 1) {

            for (int i = 0; i < user_numbers.length; i++) {
                System.out.print("\n1~45 번호 선택 >>> ");
                
                user_numbers[i] = sc.nextInt();
                if (user_numbers[i] < 1 || user_numbers[i] > 45) {
                    i--;
                    System.out.println("1에서 45까지 숫자 중 선택해주세요");
                } else {
                    for (int j = 0; j < i; j++) {
                        if (user_numbers[i] == user_numbers[j]) {
                            i--;
                            System.out.println("중복되지 않는 숫자를 선택해주세요");
                        }
                    }
                }  
            }

        } else if(user == 2) {

            for (int i = 0; i < user_numbers.length; i++) {
                user_numbers[i] = (int)(Math.random() * 45) + 1;
                for (int j = 0; j < i; j++) {
                    if (user_numbers[i] == user_numbers[j]) {
                        i--;
                        break;
                    }
                }
            }

        } else {
            System.out.println("게임 취소");
            return;
        }

        for (int i = 0; i < user_numbers.length - 1; i++) {
            for(int j = i + 1; j < user_numbers.length; j++) {
                if(user_numbers[i] > user_numbers[j]) {
                    int temp = user_numbers[i];
                    user_numbers[i] = user_numbers[j];
                    user_numbers[j] = temp;
                }
            }
        }

        System.out.print("사용자 로또 번호 : ");
        for (int i = 0; i <user_numbers.length; i++) {
            System.out.print(user_numbers[i] + " ");
        }
        System.out.println();

        

    }
}