package baekjoon.p1931;

import java.util.*;
import java.io.*;

public class Main {

	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			
			if (this.end == o.end)
				return this.start - o.start;
			else
				return this.end - o.end;
		}
		
//		public String toString() {
//			return start + " " + end;
//		}
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<Meeting> list = new ArrayList<>();
		
		for (int i = 0; i < T; i++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tokenizer.nextToken());
			int end = Integer.parseInt(tokenizer.nextToken());
			list.add(new Meeting(start, end));
		}
		
		Collections.sort(list);
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		int count = 0;
		int prevEndTime = 0;
		
		for (int i = 0; i < T; i++)
			if (prevEndTime <= list.get(i).start) {
				prevEndTime = list.get(i).end;
				count++;
			}
		
		System.out.println(count);
	}

}


//// 2차원 배열로 풀이
//public class Main {
//	
//	public static void main(String[] args) throws IOException, NumberFormatException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		int[][] a = new int[T][2];
//		
//		for (int i = 0; i < T; i++) {
//			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
//			a[i][0] = Integer.parseInt(tokenizer.nextToken());
//			a[i][1] = Integer.parseInt(tokenizer.nextToken());
//		}
//		
//		Arrays.sort(a, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				if (o1[1] == o2[1])
//					return o1[0] - o2[0];
//				else
//					return o1[1] - o2[1];
//			}
//			
//		});
//		
//		int count = 0;
//		int prevEndTime = 0;
//		
//		for (int i = 0; i < T; i++)
//			if (prevEndTime <= a[i][0]) {
//				prevEndTime = a[i][1];
//				count++;
//			}
//		
//		System.out.println(count);
//	}
//}


