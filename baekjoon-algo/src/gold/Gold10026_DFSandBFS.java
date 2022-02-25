package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


// DFS는 메인함수 위에
// BFS는 메인함수 밑에

public class Gold10026_DFSandBFS {
	static int N;
	static char arr[][], arr2[][];
	static boolean[][] isVisited, isVisited2;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	// 정상
	public static void dfs(int row, int y, char color) {
		// 방문 처리
		arr[row][y] = 'X';

		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = y + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;

			if (arr[nr][nc] == 'X') // 이미 방문한 곳이면 pass
				continue;

			if (color != arr[nr][nc]) // 색이 있는데 다른 색이면 pass
				continue;
			dfs(nr, nc, arr[nr][nc]);
		}
	}

	// 적록색약
	public static void dfs2(int row, int col, char color) {
		// 방문 처리
		arr2[row][col] = 'X';

		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;

			if (arr2[nr][nc] == 'X')
				continue;
			if (color != arr2[nr][nc])
				continue;
			dfs2(nr, nc, arr2[nr][nc]);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N]; // 정상
		arr2 = new char[N][N]; // 적록색약
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = in.charAt(j); // 정상
				// 적록색약: 빨간색과 초록색의 차이를 거의 느끼지 못한다 (G일 경우 R로 저장)
				if (in.charAt(j) == 'G')
					arr2[i][j] = 'R';
				else
					arr2[i][j] = in.charAt(j);
			}
		}

		//DFS
		int count = 0; // 정상
		int count2 = 0; // 적록색약
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != 'X') { // 정상 : 방문하지 않은 곳이면
					dfs(i, j, arr[i][j]);
					count++;
				}

				if (arr2[i][j] != 'X') {// 적록색약 : 방문하지 않은 곳이면
					dfs2(i, j, arr2[i][j]);
					count2++;
				}
			}
		}
		
		//BFS
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				if (!isVisited[i][j]) {
//					bfs(new Point(i, j));
//					count++;
//				}
//			}
//		}
//
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				if (!isVisited2[i][j]) {
//					bfs2(new Point(i, j));
//					count2++;
//				}
//			}
//		}
		System.out.println(count + " " + count2);
	}
	
//	static class Point {
//		int row;
//		int col;
//
//		public Point(int row, int col) {
//			this.row = row;
//			this.col = col;
//		}
//	}

//	private static void bfs(Point point) {
//		Queue<Point> queue = new LinkedList<>();
//		queue.offer(point);
//		isVisited[point.row][point.col] = true;
//		while (!queue.isEmpty()) {
//			Point point2 = queue.poll();
//			for (int i = 0; i < 4; i++) {
//				int row2 = point2.row + dr[i];
//				int col2 = point2.col + dc[i];
//				if (arr[point2.row][point2.col] == arr[row2][col2] && !isVisited[row2][col2]) {
//					queue.offer(new Point(row2, col2));
//					isVisited[row2][col2] = true;
//				}
//			}
//		}
//	}
//
//	private static void bfs2(Point point) {
//		Queue<Point> queue = new LinkedList<>();
//		queue.offer(point);
//		isVisited2[point.row][point.col] = true;
//		while (!queue.isEmpty()) {
//			Point point2 = queue.poll();
//			for (int i = 0; i < 4; i++) {
//				int row2 = point2.row + dr[i];
//				int col2 = point2.col + dc[i];
//				if (arr2[point2.row][point2.col] == arr2[row2][col2] && !isVisited2[row2][col2]) {
//					queue.offer(new Point(row2, col2));
//					isVisited2[row2][col2] = true;
//				}
//			}
//		}
//	}
}
