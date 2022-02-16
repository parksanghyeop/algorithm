package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1992 {

	static int[][] data;
	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		data = new int[n][n];

		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < n; j++)
				data[i][j] = input[j]-'0';
		}

		divide(0, 0, n);
		System.out.println(sb);

	}

	static void divide(int row, int col, int size) {
		if (isPossible(row, col, size)) { // 압축가능하면 압축하고 리턴
			sb.append(data[row][col]);
			return;
		}

		int newSize = size / 2; // 압축이 불가능하면 사이즈 반갈르기
		
		sb.append('(');
		
		divide(row, col, newSize); // 1
		divide(row, col+newSize, newSize); // 2
		divide(row+newSize, col, newSize); // 3
		divide(row+newSize, col+newSize, newSize); // 4
		
		sb.append(')');
	
	}

	static boolean isPossible(int row, int col, int size) { // 0,1로 꽉채워져 있는지 확인

		int value = data[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (value != data[i][j])
					return false;
			}
		}
		return true;
	}

}
