package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver10815 {


	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {

		int n, m;
		int[] sangCards;
		int[] compareCards;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = stoi(br.readLine());
		sangCards = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			sangCards[i] = stoi(st.nextToken());

		m = stoi(br.readLine());
		compareCards = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			compareCards[i] = stoi(st.nextToken());
		
		Arrays.sort(sangCards);
		
		for(int i=0;i<m;i++) {
//			int t = Arrays.binarySearch(sangCards, compareCards[i]);
			int t = myBinarySearch(compareCards[i], sangCards);
			sb.append((t>=0 ? 1 : 0)+" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int myBinarySearch(int key, int arr[]) {
		int mid;
		int left=0;
		int right = arr.length -1;
		
		while(right>=left) {
			mid = (right+left)/2;
			
			if(key == arr[mid]) {
				return mid; 
			}
			
			if(key < arr[mid]) {
				right = mid -1;
			} else {
				left = mid +1;
			}
		}
		return -1;
	}
}
