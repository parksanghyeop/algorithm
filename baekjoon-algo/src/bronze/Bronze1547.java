package bronze;

import java.util.Scanner;

public class Bronze1547 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int hasBall = 1;
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(x==hasBall)
				hasBall=y;
			else if(y==hasBall)
				hasBall=x;
		}
		System.out.println(hasBall);
	}
	
}
