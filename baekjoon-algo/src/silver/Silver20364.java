package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Silver20364 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> owned = new HashSet<>(); // 점유된 땅 저장할 해쉬셋
		
		for (int i = 1; i <= Q; i++) {
			int x = Integer.parseInt(br.readLine());
			int stop = 0;
			
			for (int j = x; j >= 2; j /= 2) {
				if (owned.contains(j))
					stop = j;			
			}	
			
			System.out.println(stop);
			if (stop == 0)
				owned.add(x);
		}
	}
}
