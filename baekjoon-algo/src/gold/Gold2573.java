package gold;

import java.util.Scanner;

public class Gold2573 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();
	}
	
	public static void DFS(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		int dx, dy;
		for(int i=0;i<4;i++) {
		}
	}

}
