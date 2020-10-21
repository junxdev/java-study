import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Test { 
 
	public static void main(String[] args) throws IOException { 
 
       		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		char A = (char)br.read();
		char B = (char)br.read();

		String C = 2;
		int D = (int)C;


		System.out.println(A);
		System.out.println(B);
		System.out.println(D);
 
	} // main end 
 
} // class end 
