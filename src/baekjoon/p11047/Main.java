package baekjoon.p11047;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		int[] a = new int[T];
		int count = 0;
		
		for (int i = 0; i < T; i++)
			a[i] = Integer.parseInt(br.readLine());
		
		for (int i = T - 1; i >= 0; i--) {
			count += K / a[i];
			K %= a[i];
		}
		
		System.out.println(count);
	}

}
