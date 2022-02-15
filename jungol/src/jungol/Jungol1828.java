package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Jungol1828 {

	static class Substance { // 화학물질
		int max=0;
		int min=0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Substance[] sub = new Substance[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sub[i] = new Substance();
			sub[i].min = Integer.parseInt(st.nextToken());
			sub[i].max = Integer.parseInt(st.nextToken());	
		}
		
		// 최대온도 기준 오름차순 정렬
		Arrays.sort(sub, new Comparator<Substance>() {
			@Override
			public int compare(Substance s1, Substance s2) {
				return Integer.compare(s1.max, s2.max);
			}
		});

		int numRef = 1;
		int max = sub[0].max; // 첫번째 냉장고의 최대 온도를 초기 최대온돋로 설정
		for(int i=1;i<n;i++) {
			if(max < sub[i].min) { // 마지막 냉장고의 온도보다 높은 최저온도 일때
				max = sub[i].max;
				numRef++;
			}
		}
		System.out.println(numRef);

	}
}
