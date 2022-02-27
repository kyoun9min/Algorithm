package thisiscote.ch07;

import java.io.*;
import java.util.*;

public class Ex01 {

	public static int binarySearch(int[] a, int target) {
		int lt = 0;
		int rt = a.length - 1;
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (a[mid] == target) return mid;
			else if (a[mid] > target) rt = mid - 1;
			else lt = mid + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		int[] b = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) b[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		for (int i = 0; i < M; i++) {
			int idx = binarySearch(a, b[i]);
			if (idx == -1) System.out.print("no ");
			else System.out.print("yes ");
		}
	}

}
