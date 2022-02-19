package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>(); // reverseFlag가 true일때 입력되는 문자열을 여기다 넣을거임
		StringBuilder sb = new StringBuilder();
		boolean reverseFlag = false; // true면 거꾸로 false면 정상적으로 출력

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char token = str.charAt(i);

			if (token == '<') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append('<');
				reverseFlag = true;
			} else if (token == '>') {
				sb.append('>');
				reverseFlag = false;
			} else if (token == ' ') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(' ');
			}

			if(token != '<' && token != '>' && token != ' ') {
				if (reverseFlag) { // 꺽쇠로 안감싸진 단어인 경우 reverseFlag가 false다
					sb.append(token);
				} else {
					stack.push(token);				
				}	
			}
		}
		while(!stack.isEmpty())
			sb.append(stack.pop());
		System.out.println(sb);

	}
}
