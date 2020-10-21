import java.util.Scanner;

class Hasnext {

	public static void main(String[] args) {

		String line = "";

		Scanner s = new Scanner(line);

		System.out.println(s.delimiter());
		System.out.println(s.hasNext());
		
		s.close();

	}

}