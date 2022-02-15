package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver11399 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 스트림 생성
		StringTokenizer st; // 읽어들인 문자열을 토큰화 하기위한 객체
		
		int n = Integer.parseInt(br.readLine()); // n 입력
		int[] p = new int[n]; // n 크기의 int 배열 생성, 인출하는데 걸리는 시간
		
		st = new StringTokenizer(br.readLine(), " "); // 공백 기준으로 입력받은 스트링을 토큰화
		
		for(int i=0;i<n;i++)
			p[i] = Integer.parseInt(st.nextToken()); // 각 토큰을 순서대로 p 배열에 저장
		
		Arrays.sort(p); // 최솟값을 구하기 위한 오름차순 정렬
		
		int result = 0; // 결과값
		int temp =0; // 이전 합들을 저장할 변수
		for(int i=0;i<n;i++) {
			temp = temp + p[i]; // 앞에서 더한값 + 현재값 즉 i번째 사람이 걸리는 시간
			result += temp; // 1~n까지 사람이 걸린시간을 더한 결과값
		}
		System.out.println(result);
		
		br.close(); // 입력스트림 종료
		
	}
}
