package swexpert;

import java.util.Scanner;

public class P2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test=1;test<=T;test++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] arr = new int[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++)
					arr[i][j] = sc.nextInt();
			}
			
			int max = 0;
			
			for(int i=0;i<=n-m;i++) {
				for(int j=0;j<=n-m;j++) {
					int sum = 0;
					for(int k=0;k<m;k++) {
						for(int l=0;l<m;l++) {
							sum += arr[i+k][j+l];
						}
					}
					
					if(max<sum)
						max=sum;
				}
			}
			
			
			
			// 결과 출력
			System.out.printf("#%d %d\r\n",test, max);
		}
		
	}
}
