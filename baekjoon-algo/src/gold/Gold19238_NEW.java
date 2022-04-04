package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold19238_NEW {

	static final int R = 0, C = 1; // 인덱스로하면 r인지 c인지 헷갈려서 지정

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int N, M, fuel;
	static int[][] arr;

	static int[] taxi = new int[2];
	static int[][] passenger;
	static int[][] destination;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		taxi[R] = Integer.parseInt(st.nextToken());
		taxi[C] = Integer.parseInt(st.nextToken());

		passenger = new int[M][2];
		destination = new int[M][2];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pr = Integer.parseInt(st.nextToken());
			int pc = Integer.parseInt(st.nextToken());
			int der = Integer.parseInt(st.nextToken());
			int dec = Integer.parseInt(st.nextToken());

			passenger[i][R] = pr;
			passenger[i][C] = pc;
			destination[i][R] = der;
			destination[i][C] = dec;

			arr[pr][pc] = i + 2;
		}
		System.out.println(taxi[R]+" "+taxi[C]);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}

	}
}
