package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			
			String str = br.readLine();
			int arr[] = new int[str.length()];
			int weight = 0;
			int sum =0;
			String token[] = str.split("");
			
			for(int j=0;j<arr.length;j++) {
				if(token[j].equals("O")) {
					weight++;
				} else {
					weight = 0;
				}
				arr[j]=weight;
			}
			System.out.println(Arrays.stream(arr).sum());
			
			
		}

	}
}
