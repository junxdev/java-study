class Ex30 { 
 
	public static void main(String[] args) { 
 
		//Q1. 1~50까지 합
		int i = 1;
		int sum = 0;
		while (i < 51) {
			sum += i++;
		}
		System.out.println("A1 : " +sum); 

		//Q2. 1~100까지 짝수들의 합
		i = 2;
		sum = 0;
		while (i < 101) {
			sum += i;
			i += 2;
		}
		System.out.println("\nA2 : " +sum); 

		//Q2. 1~100까지 짝수들의 합
		i = 1;
		sum = 0;
		while (i++ < 101) {
			if ( i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("\nA2 : " +sum); 

		//Q3. 1+3+5+7+9=25 출력

		i = 1;
		sum = 0;
		boolean first = false;

		System.out.print("\nA3 : "); 

		while (i < 11) {
			if (first) {
				System.out.print(" + ");
			}
			first = true;
			System.out.print(i);
			sum += i;
			i += 2;
		}

		System.out.println(" = " +sum);

		//Q3. 1+3+5+7+9=25 출력
		i = 1;
		sum = 0;
		first = false;

		System.out.print("\nA3 : "); 

		while (i++ < 11) {
			if (i % 2 != 0) {
				if (first) {
					System.out.print(" + ");
				}
				first = true;
				System.out.print(i);
				sum += i;
			}
		}

		System.out.println(" = " +sum);

		//Q4. 1~50까지 3의 배수 출력

		i = 3;
		first = false;

		System.out.print("\nA4 : ");

		while (i < 51) {
			if (first) {
				System.out.print(", ");
			}
			first = true;
			System.out.print(i);		
 			i += 3;
		}

		i = 1;
		first = false;

		System.out.print("\nA4 : ");

		while (i++ < 50) {
			if (i % 3 == 0) {
				if (first) {
					System.out.print(", ");
				}
				first = true;
				System.out.print(i);
			}	
		}

		//Q5. 2의1승 ~ 2의5승 출력
		
		System.out.print("\n\nA5 :");
		
		i = 1;
		sum = 2;
		int j = 0;

		while (i < 6) {
			
			System.out.print("\n2의 " + i + "승 " + sum + " = 1");

			sum = 2;
			j = 0;

			while (j++ < i) {
				System.out.print(" * 2");
				sum *= 2;
			}
			i++;
		}

		System.out.print("\n\nA5 :");

		i = 0;
		sum = 2;

		while (i < 6) {
			sum = 2;
			j = 0;

			while (j < i) {
				System.out.print(" * 2");
				sum *= 2;
				j++;
			}

			System.out.print("\n2의 " + ++i + "승 " + sum + " = 1");

		}



	} // main end 
 
} // class end 
