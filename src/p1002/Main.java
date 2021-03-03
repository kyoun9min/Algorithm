package p1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int x1 = Integer.parseInt(tokenizer.nextToken());
			int y1 = Integer.parseInt(tokenizer.nextToken());
			int r1 = Integer.parseInt(tokenizer.nextToken());
			int x2 = Integer.parseInt(tokenizer.nextToken());
			int y2 = Integer.parseInt(tokenizer.nextToken());
			int r2 = Integer.parseInt(tokenizer.nextToken());
			double R = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
			
			if (r2 < r1) {
				int temp = r1;
				r1 = r2;
				r2 = temp;
			}
			
			int count = 0;
			if (R != 0) {
				if ((r1 + r2 < R) || (R + r1 < r2))
					count = 0;
				else if ((r1 + r2 == R) || (R + r1 == r2))
					count = 1;
				else if ((r1 + r2 > R))
					count =2;
			}
			else {
				if (r1 != r2)
					count = 0;
				else
					count = -1;
			}
			System.out.println(count);
		}
	}

}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(reader.readLine());
//		
//		for (int i = 0; i < T; i++) {
//			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
//			int x1 = Integer.parseInt(tokenizer.nextToken());
//			int y1 = Integer.parseInt(tokenizer.nextToken());
//			int r1 = Integer.parseInt(tokenizer.nextToken());
//			int x2 = Integer.parseInt(tokenizer.nextToken());
//			int y2 = Integer.parseInt(tokenizer.nextToken());
//			int r2 = Integer.parseInt(tokenizer.nextToken());
//			double R = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
//			
//			if (r2 < r1) {
//				int temp = r1;
//				r1 = r2;
//				r2 = temp;
//			}
//			
//			int count = 0;
//			if (R > r1 + r2 || R + r1 < r2)
//                count = 0;
//            else if ((R == r1 + r2 || R + r1 == r2) && R != 0)
//                count = 1;
//            else if (R < r1 + r2 && R != 0)
//                count = 2;
//            else
//                count = -1;
//			System.out.println(count);
//		}
//	}
//
//}

//package backjoon.p1002;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(reader.readLine());
//		
//		for (int i = 0; i < T; i++) {
//			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
//			int x1 = Integer.parseInt(tokenizer.nextToken());
//			int y1 = Integer.parseInt(tokenizer.nextToken());
//			int r1 = Integer.parseInt(tokenizer.nextToken());
//			int x2 = Integer.parseInt(tokenizer.nextToken());
//			int y2 = Integer.parseInt(tokenizer.nextToken());
//			int r2 = Integer.parseInt(tokenizer.nextToken());
//			double R = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
//			
//			if (r2 < r1) {
//				int temp = r1;
//				r1 = r2;
//				r2 = temp;
//			}
//			
//			int count = 0;
//			
//			if (R > r2) {
//				if (R > r1 + r2)
//					count = 0;
//				else if (R == r1 + r2)
//					count = 1;
//				else
//					count = 2;
//			}
//			else if (R <= r2 && R > 0) {
//				if (r2 > R + r1)
//					count = 0;
//				else if (r2 == R + r1)
//					count = 1;
//				else
//					count = 2;
//			}
//			else {
//				if (r1 != r2)
//					count = 0;
//				else
//					count = -1;
//			}
//			System.out.println(count);
//		}
//	}
//
//}

