package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13547 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			char[] game = br.readLine().toCharArray();

			int possible = 15 - game.length;

			for (char c : game) {
				if (c == 'o')
					possible++;
			}
			System.out.printf("#%d %s\n", t, possible >= 8 ? "YES" : "NO");

		}

	}

}
