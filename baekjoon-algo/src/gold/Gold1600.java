package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold1600 {

	static int k;
	static int w, h;
	static int endR, endC;
	static int[][] arr;

	static int[] ddr = { -2, -2, -1, -1, 1, 1, 2, 2 }; // 체스말처럼 움직이는거
	static int[] ddc = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 };

	static boolean[][][] visited; // x,y,k
	static int min = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		w = stoi(st.nextToken());
		h = stoi(st.nextToken());

		arr = new int[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}

		visited = new boolean[h][w][k + 1];

		endR = h - 1; // 도착지점
		endC = w - 1;
		
		// 데이터 입력 끝
		
		// BFS 시작
		min = BFS(0, 0);

		System.out.println(min);

	}

	public static int BFS(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c, 0, k));
		visited[r][c][k] = true;

		while (!q.isEmpty()) {
			Point current = q.poll();

			// 목표지점 도착시 현재 count 반환
			// 최단경로이기 때문에 가장먼저 도착한놈이 빠른거임
			if (current.r == endR && current.c == endC) 
				return current.count;

			
			for (int i = 0; i < 4; i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < h && nc < w && !visited[nr][nc][current.k] && arr[nr][nc] == 0) {
					visited[nr][nc][current.k] = true;
					q.offer(new Point(nr, nc, current.count+1, current.k));
				}
			}

			if (current.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nr = current.r + ddr[i];
					int nc = current.c + ddc[i];
					if (nr >= 0 && nc >= 0 && nr < h && nc < w && !visited[nr][nc][current.k - 1] && arr[nr][nc] == 0) {
						visited[nr][nc][current.k - 1] = true;
						q.offer(new Point(nr, nc, current.count + 1, current.k - 1));
					}
				}
			}

		}

		return min;
	}

	public static class Point {
		int r, c;
		int count;
		int k;

		public Point(int r, int c, int count, int k) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.k = k;
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
