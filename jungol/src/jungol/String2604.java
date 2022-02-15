package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String2604 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int height = 10;

		// 이전 그릇모양이 true = ( || false = ) 를 의미함
		boolean prevFlag = true;

		if (str.charAt(0) == ')') {
			prevFlag = false;
		}

		for (int i = 1; i < str.length(); i++) {
			char bowl = str.charAt(i);

			if (prevFlag) {
				if (bowl == '(')
					height += 5;
				else {
					height += 10;
					prevFlag = false;
				}
					
			} else {
				if (bowl == ')')
					height += 5;
				else {
					height += 10;
					prevFlag = true;
				}
			}
		}
		
		System.out.println(height);

	}
}
