package forQuestion;

public class Q10871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String question = sc.nextLine();
		
		int caseNumber = Integer.parseInt((String) question.subSequence(0, question.indexOf(" ")));
		int limit = Integer.parseInt(question.substring(question.indexOf(" ") + 1));
		
		String[] input = sc.nextLine().split(" ");
		int x;
		String answer = "";
		for(int i = 0; i < input.length; i++) {
			if((x = Integer.parseInt(input[i])) < limit) {
				answer += x + " ";
			}
		}
		answer = answer.substring(0, answer.length() - 1);
		System.out.print(answer);
		
		sc.close();
	}

}
