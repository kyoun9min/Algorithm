package baekjoon.p2839;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int count = 0;
		
		while (T != 0) {
			if (T % 5 == 0) {
				count += T / 5;
				break;
			}
			T -= 3;
			count++;
			
			if (T < 0) {
				count = -1;
				break;
			}
		}
		System.out.println(count);
	}

}

//// dp를 이용한 풀이
//public class Main {
//
//	public static void main(String[] args) throws IOException, NumberFormatException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		
//		if(T < 5) {
//			if(T == 3) System.out.println("1");
//			else System.out.println("-1");
//			return;
//		}
//
//		int[] dp = new int[T + 1];
//		Arrays.fill(dp, 1700);
//		dp[3] = 1;
//		dp[5] = 1;
//		
//		for(int i = 6; i < T + 1; i++)
//				dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
//		if (dp[T] >= 1700)
//			System.out.println("-1");
//		else
//			System.out.println(dp[T]);
//	}
//
//}
