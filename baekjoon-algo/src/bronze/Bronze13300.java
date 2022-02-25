package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[2][6];
		int roomCount = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());

			arr[gender][grade-1] += 1; // 우선 학생 집어 넣
			
			if(arr[gender][grade-1]==1) { // 학생을 넣은 방에 인원이 1이면 0명에서 1이된거라 방이 새로생긴거니까 방 갯수 추가
				roomCount++;
			}else if (arr[gender][grade-1] > K) { // 각 방의 인원제한 K 보다 크다면 
				arr[gender][grade-1] -= K;
				roomCount++;
			}
		}
		
		System.out.println(roomCount);

	}
}
