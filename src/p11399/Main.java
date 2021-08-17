package p11399;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] a = new int[T];
		int sum = 0;
		
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++)
			a[i] = Integer.parseInt(tokenizer.nextToken());
		
		Arrays.sort(a);
		
		for (int i = 0; i < T; i++)
			sum += a[i] * (T - i);
		
		System.out.println(sum);
	}

}
