package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1225 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			int T = Integer.parseInt(br.readLine()); 
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Queue<Integer> q = new LinkedList<>();
			
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				q.add(n);
			}
			
			int value=1;
			
			while(value!=0) {
				for(int i=1;i<6;i++) {
					value = q.remove();
					value -= i;
					if(value<=0)
						value =0;
					q.add(value);
					if(value==0) break;
				}
			}
			System.out.printf("#%d ",T);
			for(int i=0;i<8;i++) {
				int a = q.remove();
				System.out.print(a+" ");
			}
			System.out.println();
			
				
			
			
		}	
	}
	
}
