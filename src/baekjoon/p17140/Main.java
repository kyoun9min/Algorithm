package baekjoon.p17140;

import java.util.*;
import java.io.*;

public class Main {

	
	
	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(tokenizer.nextToken()) - 1;
		int c = Integer.parseInt(tokenizer.nextToken()) - 1;
		int k = Integer.parseInt(tokenizer.nextToken());
		
		int[][] a = new int[100][100];
		for (int i = 0; i < 3; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				a[i][j] = Integer.parseInt(br.readLine());
		}
	}

}
