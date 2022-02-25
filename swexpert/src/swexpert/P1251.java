package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1251 {
	static int N;
	static double E;

	static int[] x;
	static int[] y;

	static Island[] island;
	static final double INF = Double.MAX_VALUE;
	static final int NS = -1; // not start
	static final int END = -2; // end

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			island = new Island[N];
			x = new int[N];
			y = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			// 입력 끝

			// 섬들 만들자
			for (int i = 0; i < N; i++) {
				island[i] = new Island(i);
				island[i].key = INF;
			}

			prim(); // 프림알고리즘 시작

			double answer = 0;
			for (int i = 0; i < N; i++) {
				answer += island[i].key;
			}
			System.out.printf("#%d %d\n", test_case, Math.round(answer));
		}
	}

	public static void prim() {
		ArrayList<Island> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(island[i]);
		}
		// 시작
		island[0].key = 0.0;
		island[0].point = 0;

		Island current;

		while (true) {
			current = getMin(list);
			if (current == null)
				break;
			current.point = END;
			for (int i = 0; i < N; i++) {
				if (island[i].point == END)
					continue;
				double length = (Math.pow(x[current.num] - x[island[i].num], 2) + Math.pow(y[current.num] - y[island[i].num], 2)) * E;
				if (island[i].key > length) {
					island[i].key = length;
					island[i].point = current.num;
				}
			}
		}
	}

	static class Island {
		int num;
		int point;
		double key;

		Island(int num) {
			this.num = num;
			this.point = NS;
			this.key = INF;
		}
	}

	static Island getMin(ArrayList<Island> list) {
		Island min = null;
		for (int i = 0; i < N; i++) {
			if (list.get(i).point == END)
				continue; // 이미 끝난거
			if (min == null) { // 최초설정
				min = list.get(i);
				continue;
			}
			if (list.get(i).key < min.key) { // 작은 값을 가진 섬으로 갱신
				min = list.get(i);
			}
		}
		return min;
	}
}
