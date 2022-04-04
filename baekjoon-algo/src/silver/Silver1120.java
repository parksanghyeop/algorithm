package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1120 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String a = st.nextToken();
		String b = st.nextToken();

		int min = Integer.MAX_VALUE;

		int length = b.length() - a.length() + 1;

		for (int aStart = 0; aStart < length; aStart++) {
			int diff = 0;
			for (int i = aStart; i < aStart + a.length(); i++) {
				diff += a.charAt(i - aStart) != b.charAt(i) ? 1 : 0;
			}
			min = Math.min(min, diff);
		}

		System.out.println(min);

	}
}
