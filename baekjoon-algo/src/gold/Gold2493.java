package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Gold2493 {
	
	static class Tower {
		int height;
		int idx;
		
		Tower(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Tower> stack = new Stack<Tower>();        
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=n;i++) {
			int tower = Integer.parseInt(st.nextToken());
			
			// 스택이 비었다는건 앞에 자기보다 높은 타워가 없다는 뜻
			// 그러므로 0 출력
			if(stack.isEmpty()) {
				sb.append("0 ");
				stack.push(new Tower(tower, i));
			} else {
				while(true) {
					if(stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new Tower(tower, i));
						break;
					}
					
					Tower topTower = stack.peek();
					
					// 내앞을 스택의top이 막고있으면 신호가 거기로 도달함
					// 그래서 그 타워의 인덱스 출력
					if(topTower.height > tower) {
						sb.append(topTower.idx+ " ");
						stack.push(new Tower(tower, i));
						break;
					// 내 앞에 스택이 나보다 낮으면 어짜피 내 뒤에 타워들은 앞에 도달 못함
					// 그니까 다 빼버림
					} else {
						stack.pop();
					}
				}
			}
		}
		
		System.out.println(sb.toString());

	}
}
