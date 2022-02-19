package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver11663 {

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력스트림
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] point = new int[N];
		for (int i = 0; i < N; i++)
			point[i] = stoi(st.nextToken());
		Arrays.sort(point);
		
		// 입력 종료

		// 선분 입력받으면서 탐색
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = stoi(st.nextToken());
			int end = stoi(st.nextToken());
			int sum = M;

			int left = 0; // 가장 왼쪽점의 인덱스
			int right = N - 1; // 가장 오른쪽 점 인덱스

			// 최소값 탐색
			while (left <= right) { // 왼쪽 점이 오른쪽 점보다 커지면 종료
				int mid = (left + right) / 2; // 중앙값

				if (point[mid] >= start) // 가운데 점이 선분의 시작보다 크거나 같으면
					right = mid - 1; // 가운데기준 왼쪽 탐색
				else
					left = mid + 1; // 가운데 기준 오른쪽 탐색
			}
			sum -= left;
			right = N - 1;
			
			// 최대값 탐색
			while (left <= right) {
				int mid = (left + right) / 2;

				if (point[mid] > end) // 가운데 점이 선분의 끝보다 크면
					right = mid - 1;
				else
					left = mid + 1;
			}
			sum -= (M - left);
			System.out.println(sum);
		}
	}
}
