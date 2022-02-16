package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1074 {

	static int N, r, c; // 전체 크기, 목적지좌표(r,c)
	static int count; // 재귀함수가 1x1로 쪼개졌을 때 방문순서 ++ 하는 변수
	static int ans; // r,c가 몇번째로 방문되는지 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		visit(0, 0, (int) Math.pow(2, N), 1 << N);
		System.out.println(ans);

	}

	static void visit(int si, int sj, int ei, int ej) {

		if (si > r || ei <= r || sj > c || ej <= c) { // 내영역에 목적지없으면 내 크기만큼 count 더하기
			count += (ei-si)*(ej-sj);
			return;
		}

		if (ei - si == 1) { // 정사각형이니까 i만 체크해도 괜춘
			if (si == r && sj == c) {
				ans = count;
			}
			count++;
			return;
		}
		int mi = (si + ei) / 2;
		int mj = (sj + ej) / 2;

		visit(si, sj, mi, mj); // 1
		visit(si, mj, mi, ej); // 2
		visit(mi, sj, ei, mj); // 3
		visit(mi, mj, ei, ej); // 4

	}
}
