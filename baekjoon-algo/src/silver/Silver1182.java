package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1182 {
	
	static int n,s, result;
	static int arr[];
	static int subset[];
	static boolean[] seleted;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		arr = new int[n];
		subset = new int[n];
		seleted = new boolean[n];
		result = 0;
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		subset(0);
		System.out.println(s==0 ? result-1 : result);
	}
	
	public static void subset(int cnt) {
		if(cnt == n) {
			int temp=0;
			for(int i=0;i<n;i++) {
				temp += seleted[i] ? arr[i] : 0;
			}
			if(temp==s)
				result++;
			return;
		}
		
		seleted[cnt] = true;
		subset(cnt+1);
		
		seleted[cnt] = false;
		subset(cnt+1);
		
		
	}

}
