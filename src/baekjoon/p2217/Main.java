package baekjoon.p2217;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] a = new int[T];
		
		for (int i = 0; i < T; i++)
			a[i] = Integer.parseInt(br.readLine());
		Arrays.sort(a);
		for (int i = 0; i < T; i++) {
			a[T - i - 1] = a[T - i - 1] * (i + 1);
		}
		Arrays.sort(a);
		System.out.println(a[T - 1]);
	}
}
