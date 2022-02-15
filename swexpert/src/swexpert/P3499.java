package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3499 {

	static String[] cards;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		

		for (int t = 1; t <= T; t++) {

			StringBuilder sb = new StringBuilder();
			n = Integer.parseInt(br.readLine());

			cards = br.readLine().split(" ");
			sb.append("#"+t+" ");
			if (n % 2 == 0) {
				for (int i = 0; i < (n / 2); i++) {
//					System.out.printf("%s %s ", cards[i], cards[n / 2 + i]);
					sb.append(cards[i] + " "+ cards[n/2+i]+" ");
				}
			} else {
				for (int i = 0; i < (n / 2); i++) {
//					System.out.printf("%s %s ", cards[i], cards[n / 2 + i + 1]);
					sb.append(cards[i] + " "+ cards[n/2+i+1]+" ");
				}
//				System.out.print(cards[n / 2]);
				sb.append(cards[n/2]);
			}
			System.out.println(sb);
		}

	}

}
