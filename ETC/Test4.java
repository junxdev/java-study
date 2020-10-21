import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Test4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());

		int amount_time = hour * 60 + min;
		int new_amount_time = amount_time - 45;

		if (new_amount_time < 0) {
			new_amount_time = (24 * 60) + new_amount_time;
		}

		int new_hour = new_amount_time / 60;
		int new_min = new_amount_time % 60;

		System.out.println(new_hour + " " + new_min);

	}

}
