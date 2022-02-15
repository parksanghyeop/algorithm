package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver6603 {
	
	static int[] numbers;
	static boolean[] seleted;
	static int[] arr;
	
	static int k;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String line = br.readLine();
			
			if(line.equals("0")) break;
			
			StringTokenizer st = new StringTokenizer(line);
			
			k = Integer.parseInt(st.nextToken());
			numbers = new int[k];
			seleted = new boolean[k];
			arr = new int[k];
			
			for(int i=0;i<k;i++)
				numbers[i] = Integer.parseInt(st.nextToken());
			
			comb(0);
			
			
		}		
	}
	public static void comb(int cnt) {
		if(cnt==k) {
			for(int n : arr)
				System.out.print(n+" ");
			System.out.println();
			return;
		}
		
		for(int i=0;i<k;i++) {
			if(seleted[i])
				continue;
			
			arr[cnt] = numbers[i];
			seleted[i] = true;
			comb(cnt+1);		
			seleted[i] = false;
		}

		
	}
}
