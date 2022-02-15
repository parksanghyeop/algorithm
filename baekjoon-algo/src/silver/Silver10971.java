package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver10971 {

	static int n;
	static int[][] w;
	static boolean[] visited;
	static long result = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		w = new int[n][n]; // n*n 행렬 생성
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++)
				w[i][j] = Integer.parseInt(st.nextToken());
		}

		
		// 순회 시작!
		for (int start = 0; start < n; start++) {
			visited = new boolean[n]; // 방문한 지점인지 확인하기 위한 배열 초기화
			visited[start] = true; // 시작지점은 방문한걸로 변경
			dfs(start, start , 0); // dfs 호출
		}
		System.out.println(result);

	}

	public static void dfs(int start, int current, long weight) {
		if(allVisited()) {
			if(w[current][start]!=0) {
				// 지금까지 더한 비용 weight + 나한테 돌아오는 비용 w[current][0]
				// 이전에 계산했던 값 result와 비교해서 더작은걸 result로 갱신
				result = Math.min(weight+w[current][0], result);
			}
		}
		
		for(int i=start;i<n;i++) {
			if(!visited[i] && w[current][i] !=0) { // 방문한적이 없고 행렬값이 0이면 갈수없는곳이니까 0인지 확인해야
				visited[i] = true;
				dfs(start, i, weight+w[current][i]);
				visited[i] = false;
			}			
		}
	}
	
	public static boolean allVisited() {
		for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
	}

}
