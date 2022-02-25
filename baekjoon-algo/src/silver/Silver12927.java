package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver12927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] lights = br.readLine().toCharArray();
		int count = 0;

		for (int i = 0; i < lights.length; i++) {
			if (lights[i] == 'Y') { // 전구가 꺼져있으면
				for (int j = i; j < lights.length; j += i + 1) // i의 배수들 반전
					lights[j] = lights[j] == 'Y' ? 'N' : 'Y';

				count++;
			}
		}
		System.out.println(count);

	}
}
