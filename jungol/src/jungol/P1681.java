package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1681 {
	static int N, cost;
	static int[][] matrix;
	static int min = Integer.MAX_VALUE;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit[0] = true;
		dfs(0, 0, 0);
		System.out.println(min);
	}

	static void dfs(int now,int select,int weight) {
		if(select == N-1) {
			if(matrix[now][0] == 0)
				return;
			weight += matrix[now][0];
			min = Math.min(weight, min);
			return;
		}
		if(weight>min)
			return;
		
		
		for(int i = 0 ; i < N ; i++) {
			
			if(visit[i])
				continue;
			if(matrix[now][i] == 0)
				continue;
			
			visit[i] = true;
			dfs(i,select+1,weight+matrix[now][i]);
			visit[i] = false;
		}
	}
}