package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold14500 {

	static int N, M;
	static int result;
	static int[][] arr;
	static int[] dCol = { -1, 1, 0, 0 };
	static int[] dRow = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visited[i][j] = true;
				DFS(i,j,1,arr[i][j], visited);
				visited[i][j] = false;
			}
		}
		
		System.out.println(result);
	}
	
	// DFS로 상하좌우 4번까지만 탐색하면 테트로미노 모양이 만들어짐
	// ㅗ ㅜ ㅏ ㅓ 빼고
	static void DFS(int row, int col, int count, int sum, boolean[][] visited) {  
		if(count > 4) {
			result = Math.max(count, sum);
		}
		
		for(int i=0;i<4;i++) {
			int nCol = dCol[i] + col;
			int nRow = dRow[i] + row;
			
			if(nCol >= 0 && nRow >= 0 && nRow < N && nCol < M && !visited[nRow][nCol]) {
				visited[nCol][nRow] = true;
				DFS(nCol, nRow, count+1, sum+arr[nCol][nRow], visited);
				visited[nCol][nRow] = false;
			}			
		}
	}
	
	static void ㅓㅜㅏㅓ() {
		
	}
}
