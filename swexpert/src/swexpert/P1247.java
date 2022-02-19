package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1247 {

	static boolean[] isSelected;
	static int n;
	static int[] pos;
	static ArrayList<int[]> list;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			pos = new int[4];
			n = Integer.parseInt(br.readLine());
			isSelected = new boolean[n];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				pos[i] = Integer.parseInt(st.nextToken());
			}

			list = new ArrayList<int[]>();
			for (int i = 0; i < n; i++) {
				int[] tmp = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
				list.add(tmp);
			}

			result = Integer.MAX_VALUE;
			permu(0, pos[0], pos[1], 0);
			sb.append(result);
			System.out.println(sb);
			sb.setLength(0);

		}
	}

	public static void permu(int cnt, int row, int col, int sum) {

		if (result <= sum)
			return;

		if (cnt == n) {
			sum += Math.abs(pos[2] - row) + Math.abs(pos[3] - col);
			result = Math.min(result, sum);
			return;
		}

		for (int i = 0; i < n; i++) {

			if (isSelected[i])
				continue;

			if (!isSelected[i]) {
				isSelected[i] = true;
				int tmp = Math.abs(list.get(i)[0] - row) + Math.abs(list.get(i)[1] - col);
				permu(cnt + 1, list.get(i)[0], list.get(i)[1], sum + tmp);
				isSelected[i] = false;
			}
		}
	}
}