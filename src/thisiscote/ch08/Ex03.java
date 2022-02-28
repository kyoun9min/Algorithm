package thisiscote.ch08;

import java.io.*;
import java.util.*;

public class Ex03 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796;
		}
		System.out.println(dp[N]);
	}

}
