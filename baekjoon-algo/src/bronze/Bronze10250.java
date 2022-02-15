package bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bronze10250 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 스트림 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 스트림 생성
		 
		StringBuilder sb = new StringBuilder(); // 결과를 출력할 문자열을 담을 stringbuilder
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 입력
 
		for (int i = 0; i < T; i++) { // 테스크 케이스 갯수만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 입력받은 H,W,N 토큰화
 
			int H = Integer.parseInt(st.nextToken()); // 첫번째 토큰은 입력규칙에 따라 H에 저장
			st.nextToken(); // w를 사용안하므로 패스, 불필요한 변수
			int N = Integer.parseInt(st.nextToken()); // 마지막 토큰도 입력규칙에 따라 N에 저장
 
			if (N % H == 0) { // 호텔의 높이가 N의 배수일 경우
				// H는 손님이 머무를 층수가 되고 N/H=호실 이 된다.
				sb.append((H * 100) + (N / H)).append('\n');
 
			} else { // 그외에 나머지
				// N % H = 층수 
				// N / H = 호실, 인덱스가 0부터 시작하므로 +1
				sb.append(((N % H) * 100) + ((N / H) + 1)).append('\n'); // 
			}
		}
		bw.write(sb.toString()+"\n"); 
		bw.close(); // 출력스트림을 닫는다.
		br.close(); // 입력스트림을 닫는다.
	}
}
