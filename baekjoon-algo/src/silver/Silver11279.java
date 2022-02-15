package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Silver11279 {
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi(br.readLine());;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			int current = stoi(br.readLine());
			// 우선순위 큐는 최소 힙을 제공해서 -1을 곱해서 저장하고 꺼낼때 -1을 다시 곱해야 한다
			if(current!=0) {
				q.add(current*-1); 
			} else {
				System.out.println(q.isEmpty() ? 0 : q.poll()*-1);
//				if(q.isEmpty())
//					System.out.println(0);
//				else
//					System.out.println(q.poll()*-1);
			}
		}
		
	}
}
