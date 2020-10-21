import java.util.Scanner;

public class Div{
    
    public static void main(String[] args) {
        
        float A;
        float B;
        
        Scanner sc = new Scanner(System.in);
        
        A = sc.nextInt();
        B = sc.nextInt();
        
        double result = A / B;
        
        System.out.println(result);
        
    }
}