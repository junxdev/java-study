package ch4;

public class FlowEx29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 1400; i++) {
			int temp = i + 1;
			System.out.printf("i = %d  ", temp);
			
			// 10의 자리까지 369
//			while(true) {
//				if((temp % 10) % 3 == 0 && temp % 10 != 0) {
//					System.out.print("짝!\n");
//					break;
//				} else {
//					if(temp < 10) {
//						System.out.print("\n");
//						break;
//					}
//					temp = temp / 10;
//				}
//			}
			
			// 숫자의 크기와 무관한 369
			int numberOfDigit = Integer.toString(temp).length();
			char[] digit = new char[numberOfDigit];
			digit = Integer.toString(temp).toCharArray();
			
			int clap = 0;
			for(int j = 0; j < digit.length; j++) {
				if((digit[j] - '0') % 3 == 0 && (digit[j] - '0') != 0) {
					clap++;
				}
			}
			
			while(clap-- > 0) {
				System.out.print("짝! ");
			}
			
			System.out.println("");
		}
	}

}
