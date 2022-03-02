package thisiscote.ch11;

import java.io.*;
import java.util.*;

public class Q01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		
		int cnt = 0;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			cnt++;
			if (cnt >= arr[i]) {
				answer++;
				cnt = 0;
			}
		}
		System.out.println(answer);
	}

}
