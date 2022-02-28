package thisiscote.ch08;

import java.io.*;
import java.util.*;

public class Ex04 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		for (int i = 0; i < N; i++)
			coin[i] = Integer.parseInt(br.readLine());
		int[] dp = new int[M + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int x : coin) {
			for (int i = x; i <= M; i++)
				if (dp[i - x] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - x] + 1);
		}
		if (dp[M] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[M]);
	}

}
