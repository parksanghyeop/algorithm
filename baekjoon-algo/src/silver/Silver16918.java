package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver16918 {

	static int R, C, N;
	static char map[][][];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		N = stoi(st.nextToken());

		// 짝수일 경우 무조건 폭탄이 모두 설치된 상태
		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append('O');
				}
				sb.append("\n");
			}
			System.out.println(sb);
			return;
		}

		map = new char[2][R][C];
		for (int i = 0; i < R; i++) {
			map[0][i] = br.readLine().toCharArray();
		}

		if (N / 2 > 4)
			N = (N / 2 - 4) % 2 + 4;
		else
			N /= 2;

		int idx = find();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[idx][i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int find() {

		int current = 0;
		int next = 1;
		int time = 0;

		while (time < N) {

			++time;
			// 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[current][i][j] == '.') {
						map[next][i][j] = 'O';
					} else {
						// 전에 설치된 폭탄일 경우 폭탄이 있던 칸이 파괴,
						map[next][i][j] = '.';
					}
				}
			}

			// 전에 설치된 폭탄이 모두 폭발
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[current][r][c] == '.')
						continue;
					// 인접한 네 칸도 함께 파괴
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr < 0 || nc < 0 || nr >= R || nc >= C)
							continue;
						map[next][nr][nc] = '.';
					}
				}
			}

			current = 1;
			next = 1;
		}

		return current;
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}