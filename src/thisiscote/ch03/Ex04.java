package thisiscote.ch03;

import java.io.*;
import java.util.*;

public class Ex04 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		while (N != 1) {
			if (N % K == 0) {
				N /= K;
				cnt++;
			}
			else {
				int tmp = N % K;
				if (N - tmp == 0) {
					cnt += tmp - 1;
					break;
				}
				N -= tmp;
				cnt += tmp;
			}
		}
		System.out.println(cnt);
	}
	
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		
//		int cnt = 0;
//		while (N != 1) {
//			if (N % K == 0) {
//				N /= K;
//				cnt++;
//			}
//			else {
//				N--;
//				cnt++;
//			}
//		}
//		System.out.println(cnt);
//	}

}
