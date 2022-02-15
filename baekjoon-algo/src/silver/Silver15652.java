package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Silver15652 {

	static int N, M;
	static int[] input, numbers;
	static boolean[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		input = new int[N];
		numbers = new int[M];
		selected = new boolean[N];

		for (int i = 0; i < N; i++)
			input[i] = i + 1;

		combination(0,0);

	}

	public static void combination(int cnt, int start) {

		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i); // 다음자리는 현재 뽑은 i의 다음 수부터 시작하도록 전달
			selected[i]=true;
		}
	}
}
