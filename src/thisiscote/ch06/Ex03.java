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
			if (a[i] < b[i]) { // a[i] 가 작을때만 swap
				int temp = a[i];
				a[i] = b[N - 1 - i];
				b[N - 1 - i] = temp;
			}
			else // a[i] 가 크거나 같아버리면 b[i] 의 나머지 원소는 볼 것도 없이 캍! (정렬 되어있기 때문)
				break;
		}
		System.out.println(Arrays.stream(a).sum());
	}

}
