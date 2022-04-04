package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver14889 {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int n;
	static boolean[] visited;
	static int[][] arr;
	static int min = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = stoi(br.readLine());
		visited = new boolean[n + 1];
		arr = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}

		comb(1, 0);
		System.out.println(min);
	}

	// 모든 팀의 조합 구하기
	static void comb(int start, int cnt) {
		if (cnt == n / 2) {
			min = Math.min(min, getDiff());
			return;
		}

		for (int i = start; i < n + 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}

	// 능력치 차이 구하기
	static int getDiff() {
		int sumStart = 0;
		int sumLink = 0;
		

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (visited[i] && visited[j]) // true 면 스타트팀
					sumStart += arr[i][j];

				if (!visited[i] && !visited[j])// false 면 링크팀
					sumLink += arr[i][j];
			}
		}

		return Math.abs(sumStart - sumLink);
	}

}
