package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5215 {

	static int N;
	static int L; // N은 재료 L : 칼로리
	static int[][] material;
	static int maxScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			material = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				material[i][0] = Integer.parseInt(st.nextToken());
				material[i][1] = Integer.parseInt(st.nextToken());
			}

			maxScore = 0;
			getMaterial(0, 0, 0);
			System.out.printf("#%d %d\r\n", t, maxScore);
		}

	}

	public static void getMaterial(int index, int score, int cal) {

        // 칼로리 초과
        if (cal > L) return;
        // 주어진 제한 칼로리 이하의 조합
        if (cal <= L) maxScore = Math.max(maxScore, score);
        // 칼로리 계산 끝까지 해야해서 종료조건이 더 뒤에 와야함
        if (index == N) return;
		getMaterial(index + 1, score+material[index][0], cal + material[index][1]);
		getMaterial(index + 1, score, cal);

		}
}

