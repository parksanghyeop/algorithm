package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1325 {
	static int N, M;
	static ArrayList<ArrayList<Integer>> adj;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 노드
		M = Integer.parseInt(st.nextToken()); // 간선
		final int SIZE = N + 1; // 1부터 시작하려고 N+1 쓰니깐 깔끔하게 변수에 저장

		adj = new ArrayList<ArrayList<Integer>>(SIZE);
		int max = Integer.MIN_VALUE;

		// 인접행렬 만들기
		for (int i = 0; i < SIZE; i++) {
			adj.add(new ArrayList<Integer>());
		}
		visited = new boolean[SIZE]; // 방문체크
		result = new int[SIZE]; // 각 정점의 갯수를 저장할 변수
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			adj.get(A).add(B);
		}

		for (int i = 1; i < SIZE; i++) {
			BFS(i);
			Arrays.fill(visited, false);
		}

		for (int i = 1; i < SIZE; i++) {
			if (max < result[i])
				max = result[i];
		}

		for (int i = 1; i < SIZE; i++) {
			if (max == result[i])
				sb.append(i).append(' ');
		}

		System.out.println(sb);
	}

	private static void BFS(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;

		while (!q.isEmpty()) {
			int num = q.poll();

			for (int i : adj.get(num)) {
				if (!visited[i]) {
					visited[i] = true;
					q.add(i);
					result[i]++;
				}
			}
		}
	}
}
