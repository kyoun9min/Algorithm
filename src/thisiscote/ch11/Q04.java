package thisiscote.ch11;

import java.io.*;
import java.util.*;

public class Q04 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		
		int target = 1;
		for (int i = 0; i < N; i++) {
			if (target < arr[i]) break;
			target += arr[i];
		}
		System.out.println(target);
	}

}
