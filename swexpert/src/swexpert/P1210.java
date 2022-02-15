package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class P1210 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			String test = br.readLine();

			int[][] sadari = new int[102][102];
			int y = 0;
			
			for(int i=1;i<=100;i++) {
				String[] line = br.readLine().split(" ");
				for(int j=1;j<=100;j++) {
					sadari[i][j] = Integer.parseInt(line[j-1]);
					if(sadari[i][j] ==2)
						y=j;
				}
			}

			// 골인지점부터 위로 올라감
			for (int i = 99; i >= 0; i--) {

				// 오른쪽
				if (sadari[i][y + 1] == 1) {
					while (true) {
						y++;
						if (sadari[i][y + 1] != 1)
							break;
					}

					// 왼쪽
				} else if (sadari[i][y - 1] == 1) {
					while (true) {
						y--;
						if (sadari[i][y - 1] != 1)
							break;
					}
				}
			}
			System.out.printf("#%d %d\n",t,y - 1);

		}
	}

}
