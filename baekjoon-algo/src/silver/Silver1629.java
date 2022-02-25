package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1629 {
	public static long power(long a, long b) {

		if (b == 0)
			return 1;

		if (a == 0)
			return 0;

		return a * power(a, b - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());

		System.out.println(power(a, b) % c);
		System.out.println(power(a, b));

	}
}
