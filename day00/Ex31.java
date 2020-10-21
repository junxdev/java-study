class Ex31 { 
 
	public static void main(String[] args) { 
 
		int i = 0;
		int j = 0;

		while (i < 10) {

			++i;
			j = 0;
			
			while (j < 10) {

				System.out.print(++j + "*" + i + "=" + (i * j) + " ");

			}
			
			System.out.println();

		}
 
	} // main end 
 
} // class end 
