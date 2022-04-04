package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5214 {

	static int N, K, M;
	static ArrayList<ArrayList<Integer>> stationList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N + M; i++) {
			stationList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int temp = N + i + 1;
			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				int target = Integer.parseInt(st.nextToken());
				stationList.get(target).add(temp); // target 역이 어떤 하이퍼 튜브에 있는지 저장
				stationList.get(temp).add(target); // 해당 하이퍼튜브에 target 역 추가
			}
		}

		for(ArrayList<Integer> t : stationList)
			System.out.println(t.toString());
		// 역, 하이퍼튜브까지 입력 끝

		BFS();
	}

	public static void BFS() {
		boolean[] visited = new boolean[N + M + 1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		int[] count = new int[N + M + 1];
		count[1] = 1;
		visited[1] = true;

		while (!q.isEmpty()) {
			int temp = q.poll();

			if (temp == N) {
				break;
			}
			ArrayList<Integer> set = stationList.get(temp); // temp(q에서 뽑아낸 역) 가 속한 하이퍼튜브
			for (int num : set) {
				if (!visited[num]) {

					q.add(num);
					visited[num] = true;
					count[num] = temp > N ? count[temp] + 1 : count[temp];
				}
			}
		}
		// N에 도달 못하면 -1 도달했으면 카운트값
		System.out.println(visited[N] ? count[N] : -1);
	}

}
