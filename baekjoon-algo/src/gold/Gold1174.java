package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gold1174 {

	static int n;
	static int[] numbers = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
	static List<Long> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		if(n>1023)
			System.out.println(-1);
		else {
			comb(0, 0);
			Collections.sort(result);
			System.out.println(result.get(n-1));
		}
		

	}

	static void comb(long sum, int index) {
		if (!result.contains(sum))
			result.add(sum);

		if (index >= 10)
			return;

		comb(sum * 10 + numbers[index], index + 1);
		comb(sum, index + 1);
	}

}
