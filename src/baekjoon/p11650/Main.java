package baekjoon.p11650;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[][] a = new int[T][2];
		
		for (int i = 0; i < T; i++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(tokenizer.nextToken());
			a[i][1] = Integer.parseInt(tokenizer.nextToken());
		}
		
		Arrays.sort(a, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
			
		});
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int[] n : a)
			bw.write(n[0] + " " + n[1] + "\n");
		
		bw.flush();
		bw.close();
	}

}
