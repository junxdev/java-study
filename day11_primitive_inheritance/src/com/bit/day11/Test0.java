package com.bit.day11;
final class Test {

    private final int value;

    public Test(int value) {
        this.value = value; // instance�� �����ϴ� �����̱⿡ �۵�
//        this.value++; // �Ʒ��� ���� ������ �۵� �Ұ�
    }
    
    public void increment() {
//        value++; // �ν��Ͻ��� �����Ǵ� ���� final�̹Ƿ� �۵����� ����
    }

    public void print() {
        System.out.printf("value = %d%n", value);
    }

    public void plus() {
    }
}
public class Test0 {

    public static void main(String[] args) {
        Test me = new Test(100);
        me.print();
        System.out.println(me);
        //me.value++;
        //System.out.println(me);

        Integer i = new Integer(100);
        System.out.println(Integer.hashCode(i));
        i++;
        System.out.println(Integer.hashCode(i));

        Integer su = new Integer(1000);
        System.out.printf(su.toString());

        

        
    }
    
}