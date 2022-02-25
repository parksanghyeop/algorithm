package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1012 {

	static int N, M, K;
	static int[][] arr; // 배추밭
	static boolean[][] visited; // 방문ㅊ크

	static int[] dr = { -1, 1, 0, 0 }; // row 상하좌우
	static int[] dc = { 0, 0, -1, 1 }; // col 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) { // 테스트 케이스 만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로 길이
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			K = Integer.parseInt(st.nextToken()); // 배추 심어진 갯수

			arr = new int[M][N];
			visited = new boolean[M][N];

			for (int i = 0; i < K; i++) { // 배추입력
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				arr[row][col] = 1;
			}
			// 입력파트 끝
			// DFS 시작
			int count = 0;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void dfs(int row, int col) {
		visited[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr >= 0 && nc >= 0 && nr < M && nc < N) {
				if (arr[nr][nc] == 1 && !visited[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}

}
