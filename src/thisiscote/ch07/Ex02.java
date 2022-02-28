package thisiscote.ch07;

import java.io.*;
import java.util.*;

public class Ex02 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int answer = 0;
		int lt = 0;
		int rt = Arrays.stream(a).max().getAsInt();
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			int sum = 0;
			for (int i = 0; i < N; i++)
				if (a[i] > mid) sum += a[i] - mid; // 자를 길이(mid) 보다 클때만 더해줘야지 안그러면 -값을 더해주게 되면서 값이 줄어든다.
			if (sum >= M) {
				answer = mid;
				lt = mid + 1;
			}
			else rt = mid - 1;
		}
		System.out.println(answer);
		
	}

}
