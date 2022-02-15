package bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze2999 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력스트림 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력스트림 생성
		StringBuilder sb = new StringBuilder(); // 결과값을 저장할 스트링빌더

		char[] str = br.readLine().toCharArray(); // 입력받은 string을 공백을 기준으로 char배열로 변환하여 저장

		int n = str.length; // 입력받은 알파벳 갯수 == 배열의 길이
		
		// n=1 인경우 1x1 행렬의 기본크기는 필요하므로 0이 아닌 1로 초기화
		int r = 1; 
		int c = 1; 
		
		// n보다 작은 모든 숫자중 나눈 몫이 0이 되는 수가 존재하고 i가 n/i보다 작거나 같다면
		// i * (n/i) = n 이므로 r=i c=n/i
		// 1부터 증가시켰기 때문에 자동으로 성립하는 숫자들중 가장 큰값이 r이된다.
		for(int i=1;i<n;i++) {
			if(n%i==0 && i<=n/i) {
				r=i;
				c=n/i;
			}
		}		
		char[][] arr = new char[r][c]; // 위에서 구한 r*c 행렬 생성
		int cnt = 0; // 인덱스 카운트 변수
		
		// 행렬에 새로 방향으로 하나씩 입력
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				arr[j][i] = str[cnt++];
			}
		}

		// 행렬을 가로로 탐색하면서 stringbuilder에 추가
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++)
				sb.append(arr[i][j]);
		}
		// 암호화된 결과 출력
		bw.write(sb.toString());
		bw.close(); // 출력스트림 종료
		br.close(); // 입력스트림 종료
	}

}
