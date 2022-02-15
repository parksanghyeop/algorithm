package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver16926 {

	static int[][] map;
	static int n, m, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < r; i++)
			rotate();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void rotate() {

		// 가로 세로중 작은거에 2로나눈게 사각형 갯수
		// 그냥 n을 2로 나눴다가 대참사.. 생각좀하자...
		int c = Math.min(n, m) / 2;

		for (int cnt = 0; cnt < c; cnt++) {
			int maxN = n - cnt - 1;
			int maxM = m - cnt - 1;

			// 맨처음 시작점은 값이 덮어씌워지니까 임시저장
			int temp = map[cnt][cnt];

			// 왼 <- 오
			for (int i = cnt; i < maxM; i++) {
				map[cnt][i] = map[cnt][i + 1];
			}
			// 아래 <- 위
			for (int i = cnt; i < maxN; i++) {
				map[i][maxM] = map[i + 1][maxM];
			}
			// 왼 -> 오
			for (int i = maxM; i > cnt; i--) {
				map[maxN][i] = map[maxN][i - 1];
			}
			// 위 -> 아래
			for (int i = maxN; i > cnt; i--) {
				map[i][cnt] = map[i - 1][cnt];
			}
			map[cnt + 1][cnt] = temp;
		}

	}
}
