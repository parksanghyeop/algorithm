package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold7576 {

	static class Tomato {
		int row;
		int col;

		Tomato(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int M; // 가로
	static int N; // 세로

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[][] arr;

	static Queue<Tomato> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					q.add(new Tomato(i, j));
			}
		}
		System.out.println(BFS());
	}

	static int BFS() {
		while (!q.isEmpty()) {
//			System.out.println(q.toString());
			Tomato tomato = q.poll();
			int row = tomato.row;
			int col = tomato.col;

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (arr[nr][nc] == 0) { // 토ㅓ마토 안익었으면
						q.add(new Tomato(nr, nc));
						arr[nr][nc] = arr[row][col] + 1;
					}
				}
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
		}



		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					return -1;

				max = Math.max(max, arr[i][j]);
			}
		}

		if (max == 1)
			return 0;

		return max - 1;

	}
}
