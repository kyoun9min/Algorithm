package thisiscote.ch11;

import java.io.*;
import java.util.*;

public class Q02 {

	static int[] arr;
	static int max = 0;
	
	public static void DFS(int L, int X) {
		if (L == arr.length - 1) {
			max = Math.max(max, X);
		} else {
			DFS(L + 1, X * arr[L + 1]);
			DFS(L + 1, X + arr[L + 1]);
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		arr = new int[len];
		for (int i = 0; i < len; i++)
			arr[i] = s.charAt(i) - 48;
		DFS(0, arr[0]);
		System.out.println(max);
	}

}

//public class Q02 {
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String s = br.readLine();
//		int answer = 0;
//		for (int i = 0; i < s.length(); i++) {
//			int num = s.charAt(i) - 48;
//			if (answer <= 1 || num <= 1)
//				answer += num;
//			else
//				answer *= num;
//		}
//		
//		System.out.println(answer);
//	}
//}
