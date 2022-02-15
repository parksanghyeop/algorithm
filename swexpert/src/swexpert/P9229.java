package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9229 {

	static int[] snacks;
	static int[] choice;
	static boolean[] seleted;
	static int n, m, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] nm = br.readLine().split(" ");

			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);

			snacks = new int[n];
			choice = new int[n];
			seleted = new boolean[n];
			max=-1;

			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;
			while (st.hasMoreTokens()) {
				snacks[cnt] = Integer.parseInt(st.nextToken());
				cnt++;
			}

			combination(0, 0);
			System.out.printf("#%d %d\n", t, max);

		}
	}

	public static void combination(int cnt, int start) {

		if(cnt == 2) {
			int temp=0;
			for(int i=0;i<2;i++) {
				temp += choice[i];
			}
			max = temp<=m ? Math.max(max, temp) : max;
			return;
		}
		
		for(int i=start;i<n;i++) {
			choice[cnt] = snacks[i];
			combination(cnt+1, i+1); // 다음자리는 현재 뽑은 i의 다음 수부터 시작하도록 전달
		}
		
		
	}

}
