package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3124 {
	static int n, m;
	static int[] parents;
	static Edge[] edgeList;

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(from).append(", ").append(to).append(", ").append(weight).append("]");
			return builder.toString();
		}

	}

	static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int num) {
		// 자신이 root이면 반환
		if (parents[num] == num)
			return num;
		// path compression을 하여 해당 노드를 최상위 노드 바로 밑에 붙게 한다.
		return parents[num] = findSet(parents[num]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) // a와 b의 root가 같으면, 같은 집합이므로 종료
			return false;
		int Min_Parent = Math.min(aRoot, bRoot); // 최대한 한쪽으로 몰아 넣는다.
		parents[aRoot] = Min_Parent;
		parents[bRoot] = Min_Parent;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = stoi(br.readLine());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = stoi(st.nextToken());
			m = stoi(st.nextToken());
			edgeList = new Edge[m];
			parents = new int[n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				edgeList[i] = new Edge(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
			}

			Arrays.sort(edgeList); // 가중치가 적은 순으로 간선들을 정렬한다.

			make();
			long result = 0;
			int count = 0; // 선택한 간선 수

			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) { // 만약 사이클이 존재하게 되면 root가 같으므로, 해당 간선은 넘긴다.
					result += edge.weight;
					if (++count == n - 1) {
						break;
					}
				}
			}

			System.out.println("#" + t + " " + result);
		}

	}

	static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
