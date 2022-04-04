package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver16948 {
	static int n;
	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = {-1, 1, -2, 2, -1, 1};
	static boolean[][] visit = new boolean[200][200];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[4];
		for (int i = 0; i < 4; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		System.out.println(BFS(arr));
	}

	public static int BFS(int[] arr) {
		Queue<Point> q = new LinkedList<>();

		visit[arr[0]][arr[1]] = true;
		q.add(new Point(arr[0], arr[1], 0));

		while (!q.isEmpty()) {
			Point p = q.poll();

			int row = p.row;
			int col = p.col;
			int move = p.move;

			if (row == arr[2] && col == arr[3])
				return move;

			for (int i = 0; i < 6; i++) {
				int nRow = row + dr[i];
				int nCol = col + dc[i];

				if (nRow < 0 || nCol < 0 || nRow > n - 1 || nCol > n - 1 || visit[nRow][nCol])
					continue;

				visit[nRow][nCol] = true;
				q.add(new Point(nRow, nCol, move + 1));
			}
		}
		return -1;
	}
	
	public static class Point {
		int row, col, move;

		public Point(int row, int col, int move) {
			this.row = row;
			this.col = col;
			this.move = move;
		}
	}
}