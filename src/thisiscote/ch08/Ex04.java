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
				// 조건식 없을 시 int최댓값 + 1 되면서 오버플로 발생. 오버플로된 값이 최솟값으로 dp[i]에 들어 간다.
				// int최댓값이란 얘기는 해당 동전으로 구성될 수 없단 소리.
				if (dp[i - x] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - x] + 1);
		}
		if (dp[M] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[M]);
	}

}
