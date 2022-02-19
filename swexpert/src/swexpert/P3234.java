package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3234 {
	static int T, N, result, arr[], weight[];
	static boolean seleted[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = 0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			weight = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			seleted = new boolean[N];
			balances(0);

			System.out.println("#" + t + " " + result);
		}

	}

	// 추 세우기
	private static void balances(int cnt) {
		// 모든 추를 세웠다면
		if (cnt == N) {
			check(0, 0, 0);
			return;
		}

		// 세울 수 있는 추 경우의수
		for (int i = 0; i < N; i++) {
			// 이미 사용된 추라면 pass
			if (seleted[i])
				continue;
			seleted[i] = true;
			weight[cnt] = arr[i];
			balances(cnt + 1);
			seleted[i] = false;
		}
	}

	// 세워진 추 저울에 올리기
	private static void check(int idx, int sumL, int sumR) {
		// 모든 추를 저울에 다 올렸다면
		if (idx == N) {
			result++;
			return;
		}
		// 왼쪽 저울에 해당 idx 추 올리기
		check(idx + 1, sumL + weight[idx], sumR);
		// 오른쪽 추들이 왼쪽보다 작으면 오른쪽에 더올리기
		if (sumR + weight[idx] <= sumL)
			check(idx + 1, sumL, sumR + weight[idx]);
	}
}
