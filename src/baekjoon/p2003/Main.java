package baekjoon.p2003;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int lt = 0;
		int sum = 0;
		int answer = 0;
		for (int rt = 0; rt < N; rt++) {
			sum += a[rt];
			if (sum == M) answer++;
			while (sum >= M) {
				sum -= a[lt++];
				if (sum == M) answer++;
			}
		}
		System.out.println(answer);
	}

}
