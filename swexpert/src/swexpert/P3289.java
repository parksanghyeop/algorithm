package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3289 {

	static int[] arr;
	static int n, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 집합의 갯수
			m = Integer.parseInt(st.nextToken()); // m 개의 연산

			arr = new int[n + 1];
			makeSet();
			System.out.printf("#%d ", t);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine()); // 연산 토큰화
				int op = Integer.parseInt(st.nextToken()); // 0:union 1:findset
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 1) {
					int resultA = findSet(a);
					int resultB = findSet(b);
					if (resultA == resultB)
						System.out.print(1);
					else
						System.out.print(0);
				} else
					unionSet(a, b);
			}
			System.out.println();
		}

	}

	public static void makeSet() {
		for (int i = 1; i <= n; i++)
			arr[i] = i;
	}

	public static int findSet(int a) {
		if (arr[a] == a)
			return a;

		return arr[a] = findSet(arr[a]);
	}

	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;

		arr[bRoot] = aRoot;
		return true;
	}

}
