package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold19238 {

	static int N, M, fuel, onTheCar = -1;
	static int[][] arr, guestInfo;
	static int[][] visited;
	static int[] taxi = new int[2];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		fuel = stoi(st.nextToken());

		arr = new int[N + 1][N + 1];
		guestInfo = new int[M + M][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		taxi[0] = stoi(st.nextToken());
		taxi[1] = stoi(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			guestInfo[i][0] = stoi(st.nextToken());
			guestInfo[i][1] = stoi(st.nextToken());
			guestInfo[i + M][0] = stoi(st.nextToken());
			guestInfo[i + M][1] = stoi(st.nextToken());
		}

		int result = 0;
		for (int i = 0; i < M + M; i++) {
			visited = new int[N + 1][N + 1];
			result = BFS();
			if(result == -1)
				break;
			arr[taxi[0]][taxi[1]] = 1;
		}
		
		System.out.println(result);

	}

	public static int BFS() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(taxi[0], taxi[1], 0));
		visited[taxi[0]][taxi[1]] = 1;

		while (!q.isEmpty()) {
			Point current = q.poll();

			if (onTheCar == -1) { // 손님을 안태우고 있다면 손님을 찾고
				for (int i = 0; i < M; i++) {
					if (current.r == guestInfo[i][0] && current.c == guestInfo[i][1]) {

						taxi[0] = current.r;
						taxi[1] = current.c;
						onTheCar = i;
						fuel -= current.cost;
						return fuel > 0 ? fuel : -1;
					}
				}
			} else { // 손님을 태우고 있따면 목적지로 간다.
				if (guestInfo[onTheCar + M][0] == current.r && guestInfo[onTheCar + M][1] == current.c) {

					taxi[0] = current.r;
					taxi[1] = current.c;
					onTheCar = -1;
					fuel -= current.cost;
					if (fuel > 0) {
						fuel += current.cost * 2;
						return fuel;
					} else {
						return -1;
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];
				if (nr > 0 && nc > 0 && nr <= N && nc <= N && arr[nr][nc] == 0 && visited[nr][nc] == 0) {
					q.offer(new Point(nr, nc, current.cost + 1));
					visited[nr][nc] = current.cost;
				}
			}

		}

		return -1;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static class Point {
		int r, c, cost;

		Point(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
	}

}
