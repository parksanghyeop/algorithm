package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1780 {

	static int[][] arr;
	static int[] count = new int[3]; // -1 0 1

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N);
		System.out.printf("%d\n%d\n%d", count[0], count[1], count[2]);
	}

	public static void divide(int row, int col, int size) {
//		System.out.printf("%d %d %d \n", row, col, size);
		if (isPossible(row, col, size)) {
			switch (arr[row][col]) {
			case -1:
				count[0]++;
				break;
			case 0:
				count[1]++;
				break;
			case 1:
				count[2]++;
				break;
			default:
				break;
			}
			return;
		}
		int newSize = size / 3;

		divide(row, col, newSize); // 1 1
		divide(row, col + newSize, newSize); // 1 2
		divide(row, col + newSize * 2, newSize); // 1 3
		divide(row + newSize, col, newSize); // 2 1
		divide(row + newSize, col + newSize, newSize); // 2 2
		divide(row + newSize, col + newSize * 2, newSize); // 2 3
		divide(row + newSize * 2, col, newSize); // 3 1
		divide(row + newSize * 2, col + newSize, newSize); // 3 1
		divide(row + newSize * 2, col + newSize * 2, newSize); // 3 1

	}

	public static boolean isPossible(int row, int col, int size) {
		int value = arr[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (value != arr[i][j])
					return false;
			}
		}

		return true;
	}

}
