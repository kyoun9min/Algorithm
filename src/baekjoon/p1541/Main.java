package baekjoon.p1541;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] minus = br.readLine().split("-");
		int sum = 0;
		int flag = 0;
		
		for (int i = 0; i < minus.length; i++) {
			String[] plus = minus[i].split("\\+");
			int temp = 0;
			for (int j = 0; j < plus.length; j++)
				temp += Integer.parseInt(plus[j]);
			if (flag == 0) {
				sum += temp;
				flag = 1;
			}
			else
				sum -= temp;
		}
		
		System.out.println(sum);
	}

}

//public class Main {
//	
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
//		int sum = 0;
//		int flag = 0;
//		
//		while (minus.hasMoreTokens()) {
//			StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");
//			int temp = 0;
//			while (plus.hasMoreTokens()) {
//				temp += Integer.parseInt(plus.nextToken());
//			}
//			if (flag == 0) {
//				sum += temp;
//				flag = 1;
//			}
//			else
//				sum -= temp;
//		}
//		System.out.println(sum);
//	}
//}
