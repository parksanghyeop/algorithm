package silver;

import java.util.Scanner;

public class Silver15651 {
	
	static int N,M;
	static int[] arr;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		numbers = new int[M];
		
		for(int i=0;i<N;i++)
			arr[i] = i+1;
		
		permutation(0);
		System.out.print(sb);
		
	}
	
	public static void permutation(int idx) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1;i<=N;i++) {
			numbers[idx] = i;
			permutation(idx+1);			
		}
	}
	
	
	
}
