package swexpert;

import java.util.Scanner;

public class P2805 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test = 1; test <= T; test++) {
			int n = sc.nextInt();
			int[][] farm = new int[n][n];
			int result =0;
			
			for (int i = 0; i < n; i++) {
				String line = sc.next();
				for (int j = 0; j < n; j++)
					farm[i][j] = (int) line.charAt(j) - 48;
			}
			
			int top = n/2+1;
			int bottom = n-top;
			
			for(int i=1;i<=top;i++) {
				int count = 0;
				for(int j=1;j<=top-i;j++) {
//					System.out.print("  ");
					count++;
				}
				for(int j=1;j<=i*2-1;j++) {
//					System.out.printf("%d ",farm[i-1][count]);
					result+=farm[i-1][count++];
				}
//				System.out.println();
			}
			for(int i=bottom;i>0;i--) {
				int count =0;
				for(int j=bottom;j>=i;j--) {
//					System.out.print("  ");
					count++;
				}
				for(int j=1;j<=i*2-1;j++) {
//					System.out.printf("%d ", farm[n-i][count]);
					result+=farm[n-i][count++];
				}
//				System.out.println();
			}

			System.out.printf("#%d %d\r\n",test,result);
	
		}

	}
}
