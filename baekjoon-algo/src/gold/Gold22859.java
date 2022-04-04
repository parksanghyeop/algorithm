package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold22859 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), "<");
		st.nextToken(); // main 태그는 의미없으므로 뺀다.

		while (st.hasMoreTokens()) {
			String str = st.nextToken();

			if (str.charAt(0) == '/') { // 닫는 태그는 시작이 / 다
				StringTokenizer temp = new StringTokenizer(str, ">");
				StringTokenizer text = new StringTokenizer(temp.nextToken().substring(1), " ");

				String closeTag = text.nextToken();

				if (closeTag.equals("p")) { // p태그를 닫을 때 스트링빌더에 넣어 뒀던 텍스트 출력
					System.out.println(sb.toString().replaceAll("\\s+", " ").trim());
					sb.setLength(0);
				}

				if (temp.hasMoreTokens())
					sb.append(temp.nextToken());

				// div 태그면 타이틀 출력
			} else if (str.length() >= 3 && str.replaceAll("\\s+", " ").substring(0, 3).equals("div")
					&& str.charAt(3) == ' ' && str.contains("title=\"")) {

				StringTokenizer temp = new StringTokenizer(str, "\"");
				temp.nextToken(); // 앞에 토큰은 div title= 이거니까 패스

				if (temp.hasMoreTokens())
					System.out.println("title : " + temp.nextToken());

				// div 외에 그냥 여는 태그들
			} else {
				StringTokenizer temp = new StringTokenizer(str, ">");
				temp.nextToken();

				if (temp.hasMoreTokens())
					sb.append(temp.nextToken());

			}
		}
	}
}
