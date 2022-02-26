package thisiscote.ch06;

import java.io.*;
import java.util.*;

public class Ex01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.valueOf(br.readLine());
		Arrays.sort(arr, Collections.reverseOrder());
		for (int x : arr)
			System.out.print(x + " ");
	}

}
