package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if (n == 4 || n == 7) // n이 4, 7일때
			System.out.println(-1); 
		else if (n % 5 == 0) // 5의 배수
			System.out.println(n / 5);
		else if (n % 5 == 1 || n % 5 == 3) // 5로 나눈 마ㅓ지 1,3
			System.out.println(n / 5 + 1);
		else if (n % 5 == 2 || n % 5 == 4) // 5로 나눈 나머지 2,4
			System.out.println(n / 5 + 2);

	}
}
