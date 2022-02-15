package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class P1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int test = 1; test <= T; test++) {
			
			int diff = 0;
			int dumpCount = sc.nextInt();
			int[] arr = new int[100];
			for(int i=0;i<100;i++)
				arr[i]=sc.nextInt();
			
			int max=0, maxIdx=0;
			int min=101, minIdx=0;
			
			//6번 테스트 케이스에서 에러가 났는데 
			//평탄화 작업이 끝난후에 min max를 다시 찾아서 값을 구해야했다..
			// 그래서 반복문 횟수를 1회 늘려서 마지막에 값을 다시 찾는다
			for(int i=0;i<=dumpCount;i++) {
				max=0;
				min=101;
				for(int j=0;j<100;j++) {
					if(arr[j]>max) {
						maxIdx=j;
						max=arr[j];
					}
						
					if(arr[j]<min) {
						minIdx=j;
						min=arr[j];
					}
				}
				diff = max-min;
				if(diff<=1)
					break;

				arr[maxIdx]--;
				arr[minIdx]++;				
			}
			
			
			System.out.printf("#%d %d\r\n", test, diff);
		}
	}
}
