package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gold1759 {
	private static String[] arr;
	private static int L, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = br.readLine().split(" ");
		Arrays.sort(arr);

		comb(0, "");
	}

	private static void comb(int idx, String str) {
		if (str.length() == L) {// 길이가 l개 이고
			if (isPossible(str)) { // 모음하나이상, 자음 2개이상 맞으면 출력
				System.out.println(str);
			}
			return;
		}
		if (idx >= C) {// 끝까지 오면 종료
			return;
		}
		comb(idx + 1, str + arr[idx]);// 나+다음 문자열 길이
		comb(idx + 1, str);// 나만
	}

	private static boolean isPossible(String str) {
		int vowel = 0, consonant = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isVowel(str.charAt(i))) {
				vowel++;
			} else {
				consonant++;
			}
		}
		return vowel >= 1 && consonant >= 2;
	}

	private static boolean isVowel(char ch) {
		return ch == 'a' | ch == 'e' | ch == 'i' | ch == 'o' | ch == 'u';
	}
}
