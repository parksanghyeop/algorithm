package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String2857 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = new String[15];

		for (int i = 0; i < 5; i++)
			str[i] = br.readLine();
				
		for(int i=0;i<15;i++) {
			for(int j=0;j<5;j++) {
				try {
					System.out.print(str[j].charAt(i));	
				} catch (Exception e) {
					continue;
				}				
			}
		}
		
	}
}
