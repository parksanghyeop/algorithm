package gold;

import java.util.Scanner;

public class Gold1987 {
	static int R, C, Ans = 0;
	static char[][] arr;
	static boolean[] v;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { -0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		v = new boolean[26];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		v[arr[0][0] - 'A'] = true; // 시작점은 좌측 상단
		dfs(0, 0, 1);
		System.out.println(Ans);
	}

	private static void dfs(int x, int y, int cnt) {
		Ans = Math.max(Ans, cnt);
		// 델타 써보니까 좋긴한데 머리아프다 익숙해지자
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
				if (v[arr[nx][ny] - 'A'] == false) {
					v[arr[nx][ny] - 'A'] = true;
					dfs(nx, ny, cnt + 1);
					v[arr[nx][ny] - 'A'] = false;
				}
			}
		}
	}

}
