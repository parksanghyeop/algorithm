package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int length = Integer.parseInt(br.readLine());
			int flag = 0;
			char[] str = new char[length];

			Stack<Character> stack = new Stack<Character>();
			str = br.readLine().toCharArray();
			
			for (char c : str) {
				if (isClose(c)) {
					// 닫는 괄호인데 스택이 비었다면 유효하지 않으므로 바로 종료
					if (stack.isEmpty()) {
						break;
					}
					// stack의 top과 c가 매치가 안되면 종료
					char temp = stack.pop();
					if (c == ')') {
						if ((temp + 1) != c) {
							break;
						}
					} else {
						if ((temp + 2) != c) {
							break;
						}
					}

				} else {
					stack.push(c);
				}
//				System.out.println(stack.toString());
			}
			if(stack.isEmpty())
				flag=1;
			System.out.printf("#%d %d\r\n",t,flag);
		}
	}
	static boolean isClose(char a) {
		boolean flag = false;
		switch (a) {
		case '(':
		case '[':
		case '{':
		case '<':
			flag = false;
			break;
		case ')':
		case ']':
		case '}':
		case '>':
			flag = true;
			break;
		}
		return flag;
	}

}
