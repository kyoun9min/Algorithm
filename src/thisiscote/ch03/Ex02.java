package thisiscote.ch03;

import java.io.*;
import java.util.*;

public class Ex02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.valueOf(st.nextToken());
		
		Arrays.sort(arr, Collections.reverseOrder());
		int sum = 0;
		int count = (M / (K + 1)) * K + M % (K + 1);
		sum = count * arr[0] + (M - count) * arr[1];
		System.out.println(sum);
	}
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		Integer[] arr = new Integer[N];
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++)
//			arr[i] = Integer.valueOf(st.nextToken());
//		
//		Arrays.sort(arr, Collections.reverseOrder());
//		int cnt = 0;
//		int sum = 0;
//		for (int i = 0; i < M; i++) {
//			if (cnt == K) {
//				sum += arr[1];
//				cnt = 0;
//			}
//			else {
//				sum += arr[0];
//				cnt++;
//			}
//		}
//		System.out.println(sum);
//	}
}
