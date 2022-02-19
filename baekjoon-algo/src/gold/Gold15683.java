package gold;

import java.io.IOException;
import java.util.Scanner;

public class Gold15683 {

	static int[][] map;
	static int N, M, ans; // 세로N, 가로M
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };// 0:상 1:하 2:좌 3:우
	static String[][] cctvDir = { {}, // 0번 카메라 없음.
			{ "0", "1", "2", "3" }, // 1번 카메라는 한쪽만 보니까 4방향 회전
			{ "01", "23" }, // 2번 카메라는 상하, 좌우 두번만
			{ "03", "13", "12", "20" }, // 3번 카메라는 ㄱ모양이라 4방향 회전
			{ "012", "023", "013", "123" }, // 4번 카메라는 ㅜ 모양이라 4방향 회전
			{ "0123" } // 5번 카메라는 그냥 한번실행
	};
	static int cctvCnt; // cctv 몇개있나 세어놓고 순열돌릴거임.
	static CCTV[] cctvs;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		cctvs = new CCTV[8]; // 최대갯수 8개
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]>0 && map[i][j]<6) {
					cctvs[cctvCnt] = new CCTV(i, j, map[i][j]);
					cctvCnt++;
				}
			}
		}// end input
		
		ans = Integer.MAX_VALUE;
		perm(map, 0); // 지도를 넣으면 얘는 그 지도를 복사한 다음에 카메라를 배치시켜서 색칠함.
		System.out.println(ans);
	}
	
	static void perm(int[][] arr, int idx) {
		if(idx == cctvCnt) {
			ans = Math.min(ans, countZero(arr));
			return;
		}
		
		String[] camType = cctvDir[cctvs[idx].num]; // 지금 배치할 카메라 { "012", "023", "013", "123" } 회전정보
		for(int r=0; r<camType.length; r++) { // 카메라 종류에 따라 회전수가 다름
			int[][] copy = copyArray(arr); // 나한테 들어온 지도 복사해서 현재 카메라 배치하고 색칠하자.
			
			for(int t=0; t<camType[r].length(); t++) { // "012"인 경우 d는 세개방향으로 색칠하게 됨.
				int nowi = cctvs[idx].i; // 현재 cctv 위치에서 색칠하기 시작
				int nowj = cctvs[idx].j;
				int dir = camType[r].charAt(t)-'0'; // "012" 중에 하나 떼내서 0, 1, 2으로 만들자. 이게 색칠할 방향이다.
				
				while(true) { // 직진하면서 색칠하기.
					int nexti = nowi + di[dir];
					int nextj = nowj + dj[dir];
					
					if(nexti<0 || nexti>=N || nextj<0 || nextj>=M || copy[nexti][nextj]==6) {
						break;
					}
					copy[nexti][nextj] = 9;
					nowi = nexti;
					nowj = nextj;
				}
			}
//			System.out.println("현재카메라"+cctvs[idx].i+","+cctvs[idx].j+"/"+cctvs[idx].num);
//			print(copy);
			perm(copy, idx+1); // 현재 카메라 배치하고 9로 색칠했다. 이 지도에 다음 카메라 배치해봐라.
		}
	}

	
	static int countZero(int[][] arr) { // 사각지대 0의 갯수 세기
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cnt += (arr[i][j] == 0) ? 1 : 0;
			}
		}
		return cnt;
	}

	static int[][] copyArray(int[][] arr) { // 배열을 넣으면 복사본 만들어 주는 메소드
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
	
	static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	static class CCTV {
		int i, j; // 카메라 위치
		int num; // 카메라 종류 1~5

		CCTV(int i, int j, int num) {
			this.i = i;
			this.j = j;
			this.num = num;
		}
	}
}
