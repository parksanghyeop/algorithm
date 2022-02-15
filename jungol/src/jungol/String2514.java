package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String2514 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int ioiCount = 0;
		int koiCount = 0;

		for (int i = 0; i < str.length() - 2; i++) {
			String subString = str.substring(i, i + 3);

			if (subString.equals("IOI")) {
				ioiCount++;
			} else if (subString.equals("KOI")) {
				koiCount++;
			}
		}

		System.out.println(koiCount + "\n" + ioiCount);

	}
}
