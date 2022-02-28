package thisiscote.ch08;

import java.io.*;
import java.util.*;

public class Ex02 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(st.nextToken());
		int[] dp = new int[N];
		dp[0] = a[0];
		dp[1] = Math.max(a[0], a[1]);
		for (int i = 2; i < N; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + a[i]);
		}
		System.out.println(dp[N - 1]);
	}

}
