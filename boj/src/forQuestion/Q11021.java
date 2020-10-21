package forQuestion;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		try {
			int caseNumber = Integer.parseInt(br.readLine());
			for(int i = 0; i < caseNumber; i++) {
				String numbers = br.readLine();
				StringTokenizer st = new StringTokenizer(numbers);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				String result = "Case #" + (i + 1) + ": " + (a + b);
				System.out.println(result);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(isr != null) isr.close();
				if(is != null) is.close();
			} catch (java.io.IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
