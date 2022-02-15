package thisiscote.ch03;

import java.io.*;
import java.util.*;

public class Ex03 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++)
				min = Math.min(min, arr[i][j]);
			max = Math.max(max, min);
		}
		System.out.println(max);
	}

}
