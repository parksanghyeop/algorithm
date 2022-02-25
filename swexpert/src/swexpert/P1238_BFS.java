package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1238_BFS {
	static final int N = 100;
	static boolean[] visited;
	public static int[][] load;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			load = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken(); // 데이터 길이 필용벗으니까 빼버리자
			int start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				load[from][0]++; // 개수 증가
				load[from][load[from][0]] = to; // 다음 노드 위치 저장
			}

			sb.append("#" + tc + " " + BFS(start) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int BFS(int from) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(from);
		visited[from] = true;
		int[] depth = new int[N + 1];
		depth[from] = 1; // 첫 시작하는 곳은 깊이가 1

		// BFS 탐색 시작
		while (!queue.isEmpty()) {
			from = queue.poll();

			for (int i = 1; i <= load[from][0]; i++) {
				if (!visited[load[from][i]]) {
					queue.add(load[from][i]);
					visited[load[from][i]] = true;
					depth[load[from][i]] += depth[from] + 1; // 깊이 기록
				}
			}
		}

		// 저장된 깊이들 중 가장 큰 값 찾기
		int idx = 1;
		for (int i = 1; i <= N; i++) {
			if (depth[i] >= depth[idx]) {
				idx = i;
			}
		}

		return idx;
	}
}
