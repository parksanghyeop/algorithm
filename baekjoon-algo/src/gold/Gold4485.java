package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold4485 {

	static int n, count=1;
	static int[][] arr;
	static int[][] weight;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				return;

			arr = new int[n][n];
			weight = new int[n][n];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					weight[i][j] = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			BFS();

		}
	}

	public static void BFS() {
		PriorityQueue<Node> q = new PriorityQueue<>();

		q.add(new Node(0, 0, arr[0][0]));
		weight[0][0] = arr[0][0];

		while (!q.isEmpty()) { 
			Node now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < n && nc < n && weight[nr][nc] > weight[now.r][now.c]+arr[nr][nc]) {
					weight[nr][nc] = weight[now.r][now.c] + arr[nr][nc];
					q.add(new Node(nr, nc, weight[nr][nc]));
				}
			}
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++)
//					System.out.print(weight[i][j] + " ");
//				System.out.println();
//			}
//			System.out.println();
		}

		System.out.println("Problem "+(count++)+": "+weight[n - 1][n - 1]);
	}

	public static class Node implements Comparable<Node> {
		int r, c, value;

		public Node(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", value=" + value + "]";
		}

		@Override
		public int compareTo(Node o) {
			return value - o.value;
		}

	}
}
