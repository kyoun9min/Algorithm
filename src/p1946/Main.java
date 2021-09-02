package p1946;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] a = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				StringTokenizer tokenizer = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				a[u] = v;
			}
			int count = 1;
			int pass = a[1];
			for (int i = 2; i < N + 1; i++) {
				if (pass > a[i]) {
					pass = a[i];
					count++;
				}
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
	}

}

//// 2차원 배열을 이용한 풀이
//public class Main {
//	
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int T = Integer.parseInt(br.readLine());
//		
//		while (T-- > 0) {
//			int N = Integer.parseInt(br.readLine());
//			int[][] a = new int[N][2];
//			for (int i = 0; i < N; i++) {
//				StringTokenizer tokenizer = new StringTokenizer(br.readLine());
//				a[i][0] = Integer.parseInt(tokenizer.nextToken());
//				a[i][1] = Integer.parseInt(tokenizer.nextToken());
//			}
//			Arrays.sort(a, new Comparator<int[]>() {
//				@Override
//				public int compare(int[] o1, int[] o2) {
//					return o1[0] - o2[0];
//				}
//			});
//			int count = 1;
//			int pass = a[0][1];
//			for (int i = 1; i < N; i++) {
//				if (pass > a[i][1]) {
//					pass = a[i][1];
//					count++;
//				}
//			}
//			bw.write(count + "\n");
//		}
//		bw.flush();
//		bw.close();
//	}
//}

//// 객체를 이용한 풀이
//public class Main {
//	
//	static class newEmployee implements Comparable<newEmployee> {
//		int paper;
//		int interview;
//		
//		public newEmployee(int paper, int interview) {
//			this.paper = paper;
//			this.interview = interview;
//		}
//		
//		public int compareTo(newEmployee o) {
//			return this.paper - o.paper;
//		}
//	}
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int T = Integer.parseInt(br.readLine());
//		
//		while (T-- > 0) {
//			int N = Integer.parseInt(br.readLine());
//			List<newEmployee> list = new ArrayList<>();
//			for (int i = 0; i < N; i++) {
//				StringTokenizer tokenizer = new StringTokenizer(br.readLine());
//				int paper = Integer.parseInt(tokenizer.nextToken());
//				int interview = Integer.parseInt(tokenizer.nextToken());
//				list.add(new newEmployee(paper, interview));
//			}
//			Collections.sort(list);
//			int count = 1;
//			int pass = list.get(0).interview;
//			for (int i = 1; i < list.size(); i++) {
//				if (pass > list.get(i).interview) {
//					pass = list.get(i).interview;
//					count++;
//				}
//			}
//			bw.write(count + "\n");
//		}
//		bw.flush();
//		bw.close();
//	}
//}
