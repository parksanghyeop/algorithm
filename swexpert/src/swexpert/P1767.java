package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1767 {
	// static boolean visited[][];
	static int arr[][];
	static int n;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static ArrayList<Core> coreList;
	static int maxCore = Integer.MIN_VALUE;
	static int minLine = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < testCase; i++) {
			n = Integer.parseInt(br.readLine().trim());
			arr = new int[n][n];
			coreList = new ArrayList<Core>();
			String[] str;
			for (int j = 0; j < n; j++) {
				str = br.readLine().split(" ");
				for (int k = 0; k < n; k++) {
					arr[j][k] = Integer.parseInt(str[k]);
					if (arr[j][k] == 1) {
						coreList.add(new Core(j, k));
					}
				}
			}

			dfs(0, 0, 0);
			System.out.println("#" + (i + 1) + " " + minLine);
			coreList.clear();
			maxCore = Integer.MIN_VALUE;
			minLine = Integer.MAX_VALUE;

		}

	}

	public static void dfs(int idx, int coreCnt, int lineLen) {

		if (idx == coreList.size()) {
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				minLine = lineLen;

			} else if (coreCnt == maxCore) {
				if (minLine > lineLen) {
					minLine = lineLen;
				}
			}

			return;
		}
		Core current = coreList.get(idx);

		for (int i = 0; i < 4; i++) {
			if (current.r == 0 || current.r == n - 1 || current.c == 0 || current.c == n - 1) {
				dfs(idx + 1, coreCnt + 1, lineLen);
				break;

			}
			int check = checkLine(i, current);
			int nr = current.r;
			int nc = current.c;
			if (check != -1) {
				dfs(idx + 1, coreCnt + 1, lineLen + check);
				for (int j = 0; j < check; j++) {
					nr += dr[i];
					nc += dc[i];
					arr[nr][nc] = 0;

				}
			}

		}
		dfs(idx + 1, coreCnt, lineLen);
	}

	public static int checkLine(int i, Core current) {
		int line = 0;
		int nr = current.r + dr[i];
		int nc = current.c + dc[i];
		boolean check = false;
		while (true) {
			line++;
			if ((nr == 0 || nr == n - 1 || nc == 0 || nc == n - 1) && arr[nr][nc] == 0) {
				check = true;
				break;
			}
			if (arr[nr][nc] != 0) {
				check = false;
				break;
			}
			nr += dr[i];
			nc += dc[i];

		}
		nr = current.r;
		nc = current.c;
		if (check) {
			for (int idx = 0; idx < line; idx++) {
				nr += dr[i];
				nc += dc[i];
				arr[nr][nc] = 2;

			}
			return line;
		}
		return -1;
	}

}

class Core {
	int r;
	int c;

	Core(int r, int c) {
		this.r = r;
		this.c = c;
	}

}