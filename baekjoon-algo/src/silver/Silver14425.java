package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Silver14425 {
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, Integer> map = new HashMap<>();		
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		
		for(int i=0;i<n;i++) {
			map.put(br.readLine(), 1);
		}
		int ans = 0;
		for(int i=0;i<m;i++) {
			if(map.get(br.readLine()) != null)
				ans++;
		}
		System.out.println(ans);
	}
}
