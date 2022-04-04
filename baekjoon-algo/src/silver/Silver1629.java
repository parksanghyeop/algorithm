package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1629 {

	static long c;

	public static long power(long a, long b) {

		if (b == 1)
			return a % c;

		long temp = power(a, b / 2);

		if (b % 2 == 1)
			return (temp * temp % c) * a % c;
		else
			return temp * temp % c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		System.out.println(power(a, b));

	}
}
