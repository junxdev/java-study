class PrimeNumber {

	public static void main(String[] args) {
		
		int[] primeArray = new int[100];
		int[] numArray = new int[100];
		int j = 0;
		
		for (int i = 2; i < 11; i++) {
		
			numArray[i-2] = i;

			while (j < i - 1) {
				
				if ( i % numArray[j] > 0) {
					primeArray[i-2] = i;	
					break;
				}
			j ++;

			}

			/* for (int j = 0; j <= numArray.length; j++) {

				if ( i % numArray[j] > 0) {
					primeArray[i-2] = i;	
					break;
				} else { 
					primeArray[i-2] = 0;
				} 
			} */
		}

		for (int k = 0; k < primeArray.length; k++) {
			
			System.out.println(primeArray[k]);
			
		} 
	}
}
					