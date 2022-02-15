package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6808 {

	static int[] i0 = new int[9]; // 인영
	static int[] i0Select = new int[9];
	static int[] g0 = new int[9]; // 규영
	static boolean[] seleted = new boolean[9];
	static int win;
	static int lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] allCards = new int[18];
		for (int i = 1; i <= 18; i++)
			allCards[i - 1] = i;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++) // 규영이 카드 넣기
				g0[i] = Integer.parseInt(st.nextToken());

			int cnt = 0;
			for (int card : allCards) { // 인영이 카드 넣기
				if (!contain(card)) {
					i0[cnt] = card;
					cnt++;
				}
				if (cnt >= 9)
					break;
			}
			win = 0;
			lose = 0;
			permutation(0);
			System.out.printf("#%d %d %d\n", t, win, lose);
		}

	}

	public static void permutation(int cnt) {
		if (cnt == 9) {
			int in = 0;
			int gyu = 0;
			for (int i = 0; i < 9; i++) {
				if (i0Select[i] > g0[i])
					in += i0Select[i] + g0[i];
				else
					gyu += i0Select[i] + g0[i];
			}
			if (in < gyu)
				win++;
			else
				lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (seleted[i])
				continue;

			i0Select[cnt] = i0[i];
			seleted[i] = true;

			permutation(cnt + 1);
			seleted[i] = false;

		}

	}

	public static boolean contain(int card) {
		for (int i = 0; i < 9; i++) {
			if (g0[i] == card)
				return true;
		}
		return false;
	}
}
