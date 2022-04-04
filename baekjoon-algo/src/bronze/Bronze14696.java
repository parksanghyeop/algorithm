package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze14696 {

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = stoi(br.readLine());
		int[] A, B;

		for (int i = 0; i < N; i++) {

			A = new int[5]; // A가 가지는 딱지의 갯수
			B = new int[5]; // B가 가지는 딱지의 갯수

			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			for (int j = 0; j < a; j++) {
				A[stoi(st.nextToken())]++;
			}

			st = new StringTokenizer(br.readLine());
			int b = stoi(st.nextToken());
			for (int j = 0; j < b; j++) {
				B[stoi(st.nextToken())]++;
			}

			for (int j = 4; j > 0; j--) { // 4,3,2,1 갯수 비교하면서 더 큰값이 있는쪽을 출력
				if (B[j] < A[j]) {
					System.out.println('A');
					continue;
				}
				if (B[j] > A[j]) {
					System.out.println('B');
					continue;
				}
				System.out.println('D'); // 다같으면 D
			}

		}

	}
}
