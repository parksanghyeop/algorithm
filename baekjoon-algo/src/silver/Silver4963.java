package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4963 {

	static int w, h;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dc = { -1, -1, -1, 0, 1, 1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;

			arr = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && arr[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}

	static void dfs(int row, int col) {
		visited[row][col] = true;

		for (int i = 0; i < 8; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nr >= h || nc < 0 || nc >= w) { // 인덱스 범위 벗어나면
				continue;
			}
			if (arr[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}

}
