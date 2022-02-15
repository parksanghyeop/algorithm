package bronze;

import java.util.Scanner;

public class Bronze3040 {
	static int[] arr, ans;
	static int sum;
	static boolean[] visit;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		arr = new int[9];
		visit = new boolean[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = scan.nextInt();
		}
		ans = new int[7];
		bfs(0, 0);
		System.out.println(sb);
	}

	public static void bfs(int index, int sum) {
		if (index == 7) {
			if (sum == 100) {
				sb = new StringBuilder();
				for (int val : ans) {
					sb.append(val).append('\n');
				}
			}
			return;
		}
		for (int i = index; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				ans[index] = arr[i];
				bfs(index + 1, sum + arr[i]);
				visit[i] = false;
			}
		}
	}
}
