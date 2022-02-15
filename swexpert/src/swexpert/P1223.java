package swexpert;

import java.util.Scanner;
import java.util.Stack;

public class P1223 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> op = new Stack<>(); 
		Stack<Integer> numStack = new Stack<>(); // 숫자 스택

		for (int t = 1; t <= 10; t++) {
			int length = sc.nextInt(); // 테스트 케이스 길이
			String problem = sc.next(); // 계산식 문자열
			String huwi = ""; // 후위식을 저장할 문자열

			// 후위식으로 변환 problem -> huwi
			for (int i = 0; i < problem.length(); i++) {
				char c = problem.charAt(i);

				if (0 <= c - '0' && c - '0' <= 9) // 숫자면 후위식에 다넣기
					huwi += c;
				else { // 연산자면 스택에 푸시
					if(c=='*') op.push(c); // 곱셈
					
					else {
						while(!op.isEmpty()) {
							huwi += op.pop();
						}
						op.push(c);
					}
				}
			}			
			
			while(!op.empty()) // 나머지 남아있는 연산자들 후위식에 추가
				huwi+= op.pop();
			
			for(int i=0;i<length;i++) { // 후위식 계산 시작
				char c = huwi.charAt(i);
				if(0 <= c-'0' && c-'0' <= 9) // 숫자면 numStack에 push
					numStack.push(c-'0');
				else { // 연산자면 2개를 pop해서 계산 후 다시 numStack에 push
					int num1 = numStack.pop();
					int num2 = numStack.pop();
					
					if(c =='*') numStack.push(num1*num2);
					else if(c=='+') numStack.push(num1+num2);	
				}	
			}
			
			System.out.printf("#%d %d\n", t, numStack.pop());
			
		}

	}
}
