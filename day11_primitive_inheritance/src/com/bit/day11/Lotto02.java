package com.bit.day11;
class Ball2 {
    private int num;
    boolean check;
    private String color;

    Ball2(int num) {
        this.num = num;
        check = false;
        if (num < 11) {
            color = "�끂���깋";
        } else if (num < 21) {
            color = "�뙆���깋";
        } else if (num < 31) {
            color = "鍮④컯�깋";
        } else {
            color = "寃��젙�깋";
        }
    }

    void marking() {
        check = true;
    }

    boolean checking() {
        return check;
    }

    int showNum() {
        return num;
    }

    void printNum() {
        System.out.print(color + "怨� " + num + " ");
    }
}
public class Lotto02 {
    
    public static void main(String[] args) {

        Ball2[] box = new Ball2[45];
        for (int i = 0; i < box.length; i++) {
            box[i] = new Ball2(i + 1);
        }

/*        Ball temp = null;
        for (int i = 0; i < 99999; i++) {
            temp = box[0];
            int random = (int)(Math.random() * 45);
            box[0] = box[random];
            box[random] = temp;
        }

        for (int i = 0; i < 6; i++) {
            box[i].showNum();
        }
*/

        int[] note = new int[6];
        int count = 0;

        while(count < 6) {                          // 留뚯빟 6踰� 戮묒븯�쑝硫� 戮묎린 醫낅즺
            int random = (int)(Math.random() * 45);
            Ball2 ball = box[random];                // 諛뺤뒪�뿉�꽌 怨� 戮묎린
            if (ball.checking() == true) {          // 戮묒븯�뜕 怨듭씠誘�濡� �떎�떆 戮묎린

            } else {
                ball.printNum();                    // n踰� 怨듭� x踰덉엯�땲�떎
                note[count] = ball.showNum();       // n踰� 怨듭쓣 紐⑸줉�뿉 �벑濡�
                ball.marking();                     // n踰� 怨듭쓣 戮묒� 怨듭쑝濡� �몴�떆
                count++;                            // n+1踰� 怨듭쑝濡� 
            }
        }
        System.out.println();

        int temp = 0;
        for(int i = 0; i < note.length - 1; i++) {
            for(int j = i + 1; j < note.length; j++) {
                if(note[i] > note[j]) {
                    temp = note[i];
                    note[i] = note[j];
                    note[j] = temp;
                }
            }
        }

        for(int i = 0; i < 6; i++) {
            System.out.printf("%d ", note[i]);
        }
    }
}