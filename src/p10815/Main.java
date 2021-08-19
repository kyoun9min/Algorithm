package p10815;

import java.util.*;
import java.io.*;

public class Main {
	
	public static int binarySearch(int[] a, int n) {
		int lt = 0;
		int rt = a.length - 1;
		int mid;
		
		while (lt <= rt) {
			mid = (lt + rt) / 2;
			if (n < a[mid])
				rt = mid - 1;
			else if (n > a[mid])
				lt = mid + 1;
			else
				return 1;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int[] a = new int[M];
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			a[i] = Integer.parseInt(tokenizer.nextToken());
		
		Arrays.sort(a);
		
		int N = Integer.parseInt(br.readLine());
		tokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (binarySearch(a, Integer.parseInt(tokenizer.nextToken())) == 1)
				bw.write("1 ");
			else
				bw.write("0 ");
		}
		bw.flush();
		bw.close();
		
	}

}

//// binarySearch 메소드를 활용
//public class Main {
//
//	public static void main(String[] args) throws IOException, NumberFormatException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int M = Integer.parseInt(br.readLine());
//		int[] a = new int[M];
//		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
//		for (int i = 0; i < M; i++)
//			a[i] = Integer.parseInt(tokenizer.nextToken());
//		
//		Arrays.sort(a);
//		
//		int N = Integer.parseInt(br.readLine());
//		tokenizer = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			if (Arrays.binarySearch(a, Integer.parseInt(tokenizer.nextToken())) >= 0)
//				bw.write("1 ");
//			else
//				bw.write("0 ");
//		}
//		bw.flush();
//		bw.close();
//		
//	}
//}
