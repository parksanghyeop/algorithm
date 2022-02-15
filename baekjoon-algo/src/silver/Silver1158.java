package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Silver1158 {
	public static void main(String[] args) throws IOException{
		
		Queue<Integer> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		// q가 1개 남을때 까지
		while(q.size() != 1 ) {
			// k-1번째까지 맨뒤로 보냄
			for(int i=0; i<k-1;i++) {
				q.offer(q.poll());
			}
			// k번쨰 값은 poll하고 출력
			sb.append(q.poll() + ", ");
		}
		
		sb.append(q.poll()+">");
		bw.write(sb.toString()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
}
