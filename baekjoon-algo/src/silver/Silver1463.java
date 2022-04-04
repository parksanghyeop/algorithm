package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Silver1463 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt();
//
//		int[] dp = new int[n + 1];
//
//		dp[0] = 0;
//		dp[1] = 0;
//
//		for (int i = 2; i <= n; i++) {
//			dp[i] = dp[i - 1] + 1;
//
//			if (i % 2 == 0) {
//				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
//			}
//			if (i % 3 == 0) {
//				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
//			}
//		}
//
//		System.out.println(dp[n]);
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(n == 1 ? 0 : BFS(n));

	}

	static class Node {
		int number;
		int count;

		Node(int number, int count) {
			this.number = number;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node [number=" + number + ", count=" + count + "]";
		}
		
	}

	public static int BFS(int n) {
		int count = 0;
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(n, 0));

		while (!q.isEmpty()) {
			
//			for(Node t : q) {
//				System.out.println(t.toString());
//			}
//			System.out.println("=====");
			Node current = q.poll();

			if (current.number == 1) {
				return current.count;
			}

			if (current.number % 2 == 0) {
				q.offer(new Node(current.number / 2, current.count + 1));
			}
			if (current.number % 3 == 0) {
				q.offer(new Node(current.number / 3, current.count + 1));
			}
			q.offer(new Node(current.number - 1, current.count + 1));
			
		}
		return count;
	}

}
