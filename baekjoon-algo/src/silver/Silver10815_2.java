package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver10815_2 {

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {

		int n, m;
		Set<Integer> sangCards = new HashSet<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens())
			sangCards.add(stoi(st.nextToken()));

		m = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int t = stoi(st.nextToken());
			sb.append((sangCards.contains(t) ? 1 : 0) + " ");
		}

		System.out.println(sb);

	}

}
