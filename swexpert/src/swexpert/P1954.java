package swexpert;

import java.util.Scanner;

public class P1954 {

	static int[][] snail;
	static int value = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 1; // n*n까지 증가시킬 변수
		int row = -1; // 가로줄
		int col = 0; // 세로줄
		int direction = 1; // 방향 1=우,하 -1=좌,상

		int n = sc.nextInt();
		snail = new int[n][n];

		for (int i = n; i > 0; i--) {
			// 가로 달팽이 채우는 반복문
			for (int j = 0; j < n; j++) {
				row+=direction;
				snail[col][row] = count;
				count++;
			}
			n--;
			// 세로 달팽이 채우는 반복문
			for (int j = 0; j < n; j++) {
				col += direction;
				snail[col][row] = count;
				count++;
			}
			direction*=-1;
		}
		
		for(int i=0;i<snail.length;i++) {
			for(int j=0;j<snail.length;j++) {
				System.out.printf("%2d ", snail[i][j]);
			}
			System.out.println();
		}

	}
}
