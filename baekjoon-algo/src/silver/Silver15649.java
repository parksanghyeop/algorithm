package silver;

import java.util.Scanner;

public class Silver15649 {

	static int n, m;
	static int[] numbers;
	static boolean[] seleted;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		numbers = new int[m];
		seleted = new boolean[n];
		

		permutation(0);

	}

	public static void permutation(int cnt) {
		if(cnt == m) {
			for(int t : numbers)
				System.out.print(t);
			System.out.println();
			return;
		}
		
		
		for(int i=1;i<=n;i++) {
			if(seleted[i-1])
				continue;
			
			numbers[cnt] = i;
			seleted[i-1] = true;
			permutation(cnt+1);
			seleted[i-1] = false;
			
		}
		
	}

}
