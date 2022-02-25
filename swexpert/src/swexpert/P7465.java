package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7465 {
	static int N, M;
	static int parents[];
	static boolean visited[];
	static int cnt;

	static void makeSet() {
		for (int i = 1; i < N + 1; i++)
			parents[i] = i;
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		if (aRoot < bRoot) {
			parents[bRoot] = aRoot;
			for (int i = 1; i < N + 1; i++) {
				if (parents[i] == bRoot)
					parents[i] = aRoot;
			}
		} else {
			parents[aRoot] = bRoot;
			for (int i = 1; i < N + 1; i++) {
				if (parents[i] == aRoot)
					parents[i] = bRoot;
			}
		}

		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			visited = new boolean[N + 1];
			cnt = 0;

			makeSet();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			for (int i = 1; i < N + 1; i++)
				visited[parents[i]] = true;

			for (int i = 1; i < N + 1; i++) {
				if (visited[i])
					cnt++;
			}

			System.out.println("#" + (t + 1) + " " + cnt);
		}

	}
}
