package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P86971_전력망을_둘로_나누기 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] wires = new int[6][2];

		for (int i = 0; i < 6; i++) {
			wires[i][0] = sc.nextInt();
			wires[i][1] = sc.nextInt();
		}

		System.out.println(solution(n, wires));
	}

	public static int solution(int n, int[][] wires) {
				
		Node[] tree = new Node[n + 1];
		int answer = n;
		for (int i = 0; i <= n; i++)
			tree[i] = new Node(i);

		for (int[] temp : wires) {
			tree[temp[0]].link.add(temp[1]);
			tree[temp[1]].link.add(temp[0]);
		}
		
		//트리 구성 끝

		for (int i = 1; i <= n; i++) {
			
			if (tree[i].getLinkCount() == 1) // 간선이 1개인 노드는 탐색할 필요 없음
				continue;
			
			boolean[] visited = new boolean[tree.length + 1]; 
			visited[tree[i].node] = true;
			int[] bfsResult = new int[tree[i].getLinkCount()];

			int cnt = 0;
			for (int link : tree[i].link) {
				bfsResult[cnt] = BFS(link, tree, visited);
				cnt++;
			}

			answer = Math.min(answer, compareBfsResult(bfsResult));
		}

		return answer;
	}

	public static int BFS(int link, Node[] tree, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(tree[link].node);

		visited[tree[link].node] = true;
		int count = 1;

		while (!q.isEmpty()) {
			int node = q.poll();
			for (int t : tree[node].link) {
				if (visited[t])
					continue;

				q.offer(t);
				visited[t] = true;
				count++;
			}
		}
		return count;
	}

	public static int compareBfsResult(int[] arr) {
		int sum = 0;
		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 1; i++)
			sum += arr[i];

		return Math.abs(arr[arr.length - 1] - (sum + 1));
	}

	static class Node {
		int node;
		ArrayList<Integer> link = new ArrayList<>();

		public Node(int node) {
			this.node = node;
		}

		public int getLinkCount() {
			return this.link.size();
		}

	}
}
