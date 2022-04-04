package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1697 {

	static int N, K;
	static int[] visited = new int[100001]; // 시간초를 세기 위해서 평소와 다르게 int 배열로 생성

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 변수 
		
		System.out.println(BFS(N));
	}
	
	static int BFS(int subin) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(subin); // 수빈이의 시작위치를 큐에 추가
		
		int idx = subin; // 
		int n =0; // 큐에서 빼낸 수빈이의 현재 탐색위치를 저장할 변수
		visited[idx] = 0; // 수빈이 위치에서 0초부터 시작
		
		while(!q.isEmpty()) {
			n = q.poll(); // 수빈이가 탐색할 위치를 n에 저장			
			
			if(n==K) { // 찾으면 현재까지 걸린 초 반환
				return visited[n];				
			}
						
			if(n-1>=0 && visited[n-1] == 0) { // n-1
				visited[n-1] = visited[n]+1; // 다음 탐색 위치로 갔다는건 1초가 지났다는거니까 1초 추가
				q.add(n-1);
			}
			if(n+1<=100000 && visited[n+1] == 0) { // n+1
				visited[n+1] = visited[n]+1;
				q.add(n+1);
			}
			if(2*n <= 100000 && visited[2*n] == 0) { // 순간이동
				visited[2*n] = visited[n] +1;
				q.add(2*n);
			}
			
			
		}		
	
		return -1;
	}
}
