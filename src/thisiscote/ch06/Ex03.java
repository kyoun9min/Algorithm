package thisiscote.ch06;

import java.io.*;
import java.util.*;

public class Ex03 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] a = new int[N];
		int[] b = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			b[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i = 0; i < K; i++) {
			int temp = a[i];
			a[i] = b[N - 1 - i];
			b[N - 1 - i] = temp;
		}
		System.out.println(Arrays.stream(a).sum());
	}

}
