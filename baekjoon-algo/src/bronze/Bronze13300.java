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

			arr[gender][grade-1] += 1;
			
			if(arr[gender][grade-1]==1) {
				roomCount++;
			}else if (arr[gender][grade-1] > K) {
				arr[gender][grade-1] -= K;
				roomCount++;
			}
		}
		
		System.out.println(roomCount);

	}
}
