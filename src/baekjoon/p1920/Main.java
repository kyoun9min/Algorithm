package baekjoon.p1920;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nArr = new int[N];
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		nArr = arrParsing(nArr, tokenizer);
		
		int M = Integer.parseInt(br.readLine());
		int[] mArr = new int[M];
		tokenizer = new StringTokenizer(br.readLine());
		mArr = arrParsing(mArr, tokenizer);
		
		Arrays.parallelSort(nArr);
		for (int i = 0; i < M; i++) {
				System.out.println(binarySearch(nArr, mArr[i]));
		}
	}
	
	public static int[] arrParsing(int[] arr, StringTokenizer tokenizer) {
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		return arr;
	}
	
	public static int binarySearch(int[] nArr, int n) {
		int lt = 0;
		int rt = nArr.length - 1;
		int mid;
		
		while (lt <= rt) {
			mid = (lt + rt) / 2;
			if (n < nArr[mid])
				rt = mid - 1;
			else if (n > nArr[mid])
				lt = mid + 1;
			else
				return 1;
		}
		return 0;
	}

}
