package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] arr = new boolean[101][101];
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int t = y; t < y + 10; t++) {
				for (int k = x; k < x + 10; k++) {
					arr[t][k] = true;
				}
			}

		}

		int cnt = 0;

		for (int i = 0; i < 101; i++)
			for (int j = 0; j < 101; j++)
				cnt = arr[i][j] ? cnt + 1 : cnt;

		System.out.println(cnt);

	}
}
