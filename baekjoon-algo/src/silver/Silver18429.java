package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver18429 {

	static int N, K;
	static int[] weights;
	static boolean[] visit;
	static int totalMethods;

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		
		weights = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weights[i] = stoi(st.nextToken());
		}

		find(0, 500);
		System.out.println(totalMethods);
	}

	public static void find(int depth, int weight) {
		if (depth > N) {
			return;
		}

		if (weight < 500) {
			return;
		}

		if (depth == N) {
			totalMethods += 1;
			return;
		}

		for (int i = 0; i < visit.length; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			find(depth + 1, weight + weights[i] - K);
			visit[i] = false;
		}
	}
}
