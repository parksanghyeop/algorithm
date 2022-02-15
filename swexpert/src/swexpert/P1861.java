package swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.ls.LSOutput;

public class P1861 {

	static int[][] arr;
	static int[][] visited;
	static int n;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringBuilder sb = new StringBuilder();
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			int max = 0;
			int start = 0;

			for (int i = 0; i < n; i++) {
				String[] line = br.readLine().split(" ");

				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(line[j]);
				}
			}

			// 0,0부터 n-1,n-1까지 시작점으로 잡고 탐색
			// n^2번 dfs 실행
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result = 0;
					dfs(i, j, arr[i][j] - 1, 0);
					if (max < result) {
						start = arr[i][j];
						max = result;
					} else if (max == result && arr[i][j] < start) { // max와 result가 같다면 시작지점이 더 작은 값으로 갱신
						start = arr[i][j];
					}
				}
			}

			sb.append("#"+t+" "+start+" "+max);
			System.out.println(sb);
		}
	}

	static void dfs(int row, int col, int lastN, int cnt) {
		// 만약 범위를 벗어나거나 현재 위치가 1차이가 나지 않으면 종료
		if (row < 0 || row >= n || col < 0 || col >= n || arr[row][col] != lastN + 1) {
			result = Math.max(result, cnt);
			return;
		}
		dfs(row - 1, col, arr[row][col], cnt + 1); // 상
		dfs(row + 1, col, arr[row][col], cnt + 1); // 하
		dfs(row, col - 1, arr[row][col], cnt + 1); // 좌
		dfs(row, col + 1, arr[row][col], cnt + 1); // 우
	}

}
